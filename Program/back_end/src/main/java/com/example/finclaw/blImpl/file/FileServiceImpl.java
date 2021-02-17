package com.example.finclaw.blImpl.file;

import com.example.finclaw.bl.file.FileService;
import com.example.finclaw.data.file.FileMapper;
import com.example.finclaw.data.project.ProjectMapper;
import com.example.finclaw.po.FileInfo;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.file.FileInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Service
public class FileServiceImpl implements FileService {
    private final static String UPLOAD_FAILURE_MESSAGE = "upload failure!";
    private final static String UPLOAD_SUCCESS_MESSAGE = "upload success!";
    private final static String DOWNLOAD_FAILURE_MESSAGE = "download failure!";
    private final static String DOWNLOAD_SUCCESS_MESSAGE = "download success!";

    private static SimpleDateFormat TimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Value("${rootPath}")
    private String rootPath;

    @Autowired
    FileMapper fileMapper;

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public ResponseVO uploadFile(MultipartFile file, Integer userID) {
        //获取当前时间戳
        Timestamp now = new Timestamp(System.currentTimeMillis());
        FileInfo fileInfo = new FileInfo();
        fileInfo.setUserID(userID);
        fileInfo.setFileName(file.getOriginalFilename());
        try {
            String fileTimeStamp = now.getTime()+"";
            //Chrome和IE里这个方法的返回值不同，IE里会带上根路径
            String originalFileName = file.getOriginalFilename();
            // Check for Unix-style path
            int unixSep = originalFileName.lastIndexOf('/');
            // Check for Windows-style path
            int winSep = originalFileName.lastIndexOf('\\');
            // Cut off at latest possible point
            int pos = (Math.max(winSep, unixSep));
            if (pos != -1)  {
                // Any sort of path separator found...
                originalFileName = originalFileName.substring(pos + 1);
            }
            //存储路径为根路径+userID+文件名
            String finalPath = rootPath + "/" + userID + "/" + originalFileName;
            System.out.println(finalPath);
            fileInfo.setFilePath(finalPath);
            File targetFile = new File(finalPath);
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure(UPLOAD_FAILURE_MESSAGE);
        }
        //将文件信息存入数据库
        fileInfo.setUploadTime(now);
        fileMapper.uploadFile(fileInfo);
        return ResponseVO.buildSuccess(UPLOAD_SUCCESS_MESSAGE);
    }

    @Override
    public void downloadFile(HttpServletResponse httpResponse, Integer fileID) throws UnsupportedEncodingException {
        //获取文件路径
        FileInfo fileInfo = fileMapper.getFileByID(fileID);
        String filePath = fileInfo.getFilePath();
        System.out.println(filePath);
        File file = new File(filePath);
        if (file.exists()) {
            //配置文件下载
            httpResponse.setHeader("content-type", "application/octet-stream");
            httpResponse.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            httpResponse.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileInfo.getFileName(), "UTF-8"));
            // 实现文件下载
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = httpResponse.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                System.out.println("Download  successfully!");
               // return ResponseVO.buildSuccess(DOWNLOAD_SUCCESS_MESSAGE);
            } catch (Exception e) {
                System.out.println("Download  failed!");
                //return ResponseVO.buildFailure(DOWNLOAD_FAILURE_MESSAGE);

            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            //return ResponseVO.buildFailure(DOWNLOAD_FAILURE_MESSAGE);
        }
    }

    @Override
    public List<FileInfoVO> getUserFiles(int userID) {
        List<FileInfoVO> res = new ArrayList<>();
        List<FileInfo> allFiles = fileMapper.selectUserFiles(userID);
        for (FileInfo fileInfo : allFiles) {
            FileInfoVO fileInfoVO = new FileInfoVO();
            BeanUtils.copyProperties(fileInfo, fileInfoVO);
            res.add(fileInfoVO);
        }
        return res;
    }
}