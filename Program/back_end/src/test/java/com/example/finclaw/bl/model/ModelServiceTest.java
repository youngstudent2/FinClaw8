package com.example.finclaw.bl.model;

import com.example.finclaw.vo.model.ModelVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelServiceTest {

    @Autowired
    ModelService modelService;

    @Test
    public void getAllModels() {
        List<ModelVO> modelVOS = modelService.getAllModels();
        Assert.assertThat(modelVOS.size(), is(3));
    }

    @Test
    public void addModel() {
        //int num = modelService.getAllModels().size();
        //modelService.addModel();
        //num = modelService.getAllModels().size() - num;
        //Assert.assertThat(num,is(1));
    }
}