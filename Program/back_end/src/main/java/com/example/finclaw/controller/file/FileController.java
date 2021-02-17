package com.example.finclaw.controller.file;

import com.example.finclaw.bl.file.FileService;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.file.FileInfoVO;
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

    @PostMapping("/upload/{userID}")
    public ResponseVO upload(@RequestParam MultipartFile multipartFile, @PathVariable Integer userID) {
        return fileService.uploadFile(multipartFile, userID);
    }

    @GetMapping("/getUserFiles/{userID}")
    public ResponseVO getUserFiles(@PathVariable Integer userID){
        return ResponseVO.buildSuccess(fileService.getUserFiles(userID));
    }

    @GetMapping("/download/{fileID}")
    public void download(@PathVariable Integer fileID) throws UnsupportedEncodingException {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse httpResponse = requestAttributes.getResponse();
        if(httpResponse!=null) {
            System.out.println("httpResponse is not null");
            fileService.downloadFile(httpResponse, fileID);
        }
        else {
            //return ResponseVO.buildFailure("error");
        }
    }


}
