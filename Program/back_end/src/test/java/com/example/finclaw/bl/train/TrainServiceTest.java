package com.example.finclaw.bl.train;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainServiceTest {

    @Autowired
    TrainService trainService;

    @Test
    public void startDeploy() {
        boolean test = trainService.startDeploy(1);
        Assert.assertThat(test, is(false));
    }

    @Test
    public void startTrain() {
        boolean test = trainService.startTrain(1);
        Assert.assertThat(test, is(false));
    }
}