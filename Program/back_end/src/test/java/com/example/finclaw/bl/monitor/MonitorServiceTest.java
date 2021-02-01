package com.example.finclaw.bl.monitor;

import com.example.finclaw.vo.monitor.MonitorFormVO;
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
public class MonitorServiceTest {

    @Autowired
    MonitorService monitorService;

    @Test
    public void recordInfo() {
        int num = monitorService.getMonitorInfo(1).size();
        monitorService.recordInfo(1,1,1);
        num = monitorService.getMonitorInfo(1).size() - num;
        Assert.assertThat(num, is(1));
    }

    @Test
    public void getMonitorInfo() {
        List<MonitorFormVO> monitorVOS = monitorService.getMonitorInfo(1);
        Assert.assertThat(monitorVOS.get(0).getOperation(),is("Add"));
    }

    @Test
    public void getMonitorInfo1() {
        List<MonitorFormVO> monitorFormVOS = monitorService.getMonitorInfo(1,3);
        Assert.assertThat(monitorFormVOS.size(),is(0));
    }

    /*
    @Test
    public void getMonitorInfo2() {
        int num = monitorService.getMonitorInfo(1,1,2).size();
        System.out.println(monitorService.getMonitorInfo(1,1,2).size());
        monitorService.recordInfo(1,1,2);
        num = monitorService.getMonitorInfo(1,1,2).size() - num;
        System.out.println(monitorService.getMonitorInfo(1,1,2));
        Assert.assertThat(num,is(1));
    }

     */

    @Test
    public void getCooperationMonitorInfo() {
        List<MonitorFormVO> monitorFormVOS = monitorService.getCooperationMonitorInfo(1,1);
        Assert.assertThat(monitorFormVOS.get(0).getOperation(),is("Add"));
    }
}