package com.example.finclaw.data.file;

import com.example.finclaw.po.FileInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileMapperTest {
    @Autowired
    private FileMapper fileMapper;

    @Test
    public void uploadFileTest(){
        FileInfo fileInfo = new FileInfo(){{
           setUserID(1000);
           setFileName("tttest.md");
           setFilePath("tttest.md");
        }};
        fileMapper.uploadFile(fileInfo);
        assertTrue(fileMapper.selectUserFiles(1000).size()>0);
    }

    @Test
    public void getFileByFilePathTest(){
        FileInfo fileInfo = fileMapper.getFileByFilePath("D:/user");
        assertEquals(new Integer(1),fileInfo.getFileID());
    }

    @Test
    public void selectUserFilesTest(){
        List<FileInfo> fileInfoList = fileMapper.selectUserFiles(8);
        assertEquals(1,fileInfoList.size());
    }

    @Test
    public void getFileByIDTest(){
        FileInfo fileInfo = fileMapper.getFileByID(1);
        assertEquals(new Integer(1),fileInfo.getFileID());
    }


}
