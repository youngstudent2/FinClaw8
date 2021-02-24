package com.example.finclaw.bl.file;

import com.example.finclaw.vo.file.FileInfoVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceTest {
    @Autowired
    private FileService fileService;


    @Test
    public void getUserFilesTest(){
        //比较文件数量
        int currentUserFileNum = 1;
        List<FileInfoVO> fileInfoList = fileService.getUserFiles(8);
        assertEquals(1,fileInfoList.size());
        assertEquals(0,fileService.getUserFiles(1).size());
    }

}
