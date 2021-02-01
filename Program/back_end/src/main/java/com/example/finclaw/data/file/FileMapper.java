package com.example.finclaw.data.file;

import com.example.finclaw.po.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileMapper {
    /**
     * 上传文件，插入记录
     * @param fileInfo
     * @return
     */
    int uploadFile(FileInfo fileInfo);

    FileInfo getFileByFilePath(String filePath);

    List<FileInfo> selectAllFilesInProject(int projectID);

    FileInfo getFileByID(int fileID);
}