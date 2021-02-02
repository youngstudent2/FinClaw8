package com.example.finclaw.bl.file;

import com.example.finclaw.vo.file.FileInfoVO;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;


public interface FileService{
    /**
     * 上传文件
     * @param
     * @return
     */
    ResponseVO uploadFile(MultipartFile file, FileInfoVO fileInfoVO);

    ResponseVO downloadFile(HttpServletResponse httpResponse, FileInfoVO fileInfoVO) throws UnsupportedEncodingException;

    List<FileInfoVO> getAllFiles(int projectID);

}