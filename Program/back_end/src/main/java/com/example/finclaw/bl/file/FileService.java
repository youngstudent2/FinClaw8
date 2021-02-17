package com.example.finclaw.bl.file;

import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.file.FileInfoVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;


public interface FileService {
    /**
     * 上传文件
     * @param
     * @return
     */
    ResponseVO uploadFile(MultipartFile file, Integer userID);

    void downloadFile(HttpServletResponse httpResponse, Integer fileID) throws UnsupportedEncodingException;

    List<FileInfoVO> getUserFiles(int userID);

}