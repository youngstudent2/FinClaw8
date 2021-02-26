package com.example.finclaw.data.model;

import com.example.finclaw.po.Model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelMapperTest {
    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void createModelTest() {
        Model model = new Model();
        model.setModelName("test");
        model.setModelVerion("test");
        model.setJid("test");
        model.setMid("test");
        modelMapper.createNewModel(model);
        for (Model m : modelMapper.getAllModel()) {
            if (m.getModelVerion().equals("test"))
                return;
        }
        fail();
    }

    @Test
    public void getModelTest() {
        assertEquals("SVM", modelMapper.getModel(1).getModelName());
    }

    @Test
    public void getALlModelTest() {
        assertEquals(4, modelMapper.getAllModel().size());
    }

}
