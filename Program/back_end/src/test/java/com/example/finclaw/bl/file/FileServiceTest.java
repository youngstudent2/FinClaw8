package com.example.finclaw.bl.file;

import com.example.finclaw.vo.file.FileInfoVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author lly
 * @date 2020/10/13
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceTest{

    @Autowired
    private FileService fileService;

    private final FileInfoVO fileInfoVO = new FileInfoVO(0,0,"test");


    @Test
    @Transactional
    public void getAllFilesTest(){
        //检查某项目下文件数量
        int project1ID = 0;
        List<FileInfoVO> allFiles1 = fileService.getAllFiles(project1ID);
        int actualNum1 = 0;
        assertEquals(actualNum1,allFiles1.size());

        int project2ID = 0;
        List<FileInfoVO> allFiles2 = fileService.getAllFiles(project2ID);
        int actualNum2 = 0;
        assertEquals(actualNum2,allFiles2.size());
    }

}

