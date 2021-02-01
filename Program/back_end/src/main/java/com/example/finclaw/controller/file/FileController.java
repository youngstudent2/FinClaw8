package com.example.finclaw.controller.file;

import com.example.finclaw.bl.file.FileService;
import com.example.finclaw.vo.file.FileInfoVO;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload/{operatorID}")
    public ResponseVO upload(@RequestParam MultipartFile multipartFile, @RequestParam Integer projectID, @PathVariable Integer operatorID) {
        FileInfoVO fileInfoVO = new FileInfoVO();
        fileInfoVO.setProjectID(projectID);
        fileInfoVO.setOperatorID(operatorID);
        fileInfoVO.setFileName(multipartFile.getOriginalFilename());
        return fileService.uploadFile(multipartFile, fileInfoVO);
    }

    @GetMapping("/download/{operatorID}")
    //fileInfo里填fileName,uploadTime,projectID
    public ResponseVO download(@RequestParam String fileName,
                               @RequestParam Integer projectID,
                               @RequestParam String uploadTime,
                               @RequestParam String filePath,
                               @PathVariable Integer operatorID) throws UnsupportedEncodingException {
        //todo：利用operatorID完成埋点
        FileInfoVO fileInfoVO = new FileInfoVO();
        fileInfoVO.setFileName(fileName);
        fileInfoVO.setProjectID(projectID);
        fileInfoVO.setUploadTime(Timestamp.valueOf(uploadTime));
        fileInfoVO.setFilePath(filePath);
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse httpResponse = requestAttributes.getResponse();
        if(httpResponse!=null) {
            System.out.println("httpResponse is not null");
            return fileService.downloadFile(httpResponse, fileInfoVO);
        }
        else return ResponseVO.buildFailure("error");
    }

    @GetMapping("/viewAllFile/{operatorID}")
    public ResponseVO allFile(@RequestParam Integer projectID, @PathVariable Integer operatorID) {
        //todo:利用operatorID完成埋点
        return ResponseVO.buildSuccess(fileService.getAllFiles(projectID));
    }


}
