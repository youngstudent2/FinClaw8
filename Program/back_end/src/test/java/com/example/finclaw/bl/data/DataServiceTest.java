package com.example.finclaw.bl.data;

import com.example.finclaw.vo.data.ProjectDataVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataServiceTest {

    @Autowired
    DataService dataService;

    @Test
    public void getFileMetadata() {
        //String[] metadata = dataService.getFileMetadata(1);
        //Assert.assertThat(metadata[0], is());
    }

    @Test
    public void getProjectData() {
        ProjectDataVO projectVO =  dataService.getProjectData(1);
        Assert.assertThat(projectVO.getName(),is("南京市活动1"));
    }
}