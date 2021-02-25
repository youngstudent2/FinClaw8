package com.example.finclaw.bl.monitor;

import com.example.finclaw.vo.monitor.MonitorVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonitorServiceTest {
    @Autowired
    private MonitorService monitorService;

    @Test
    public void recordMonitorInfoTest() {
        int testUserID= Integer.MAX_VALUE,testProjectID=Integer.MAX_VALUE,testOperatorID=1;
        monitorService.recordInfo(testUserID,testUserID,testOperatorID);
        List<MonitorVO> allInfo = monitorService.getAllOperation();
        for (MonitorVO monitorVO : allInfo) {
            if (monitorVO.getUserID() == testUserID && monitorVO.getProjectID() == testProjectID && monitorVO.getOperation().equals("Add") ) {
                return;
            }
        }
        fail();
    }

    @Test
    public void getUserMonitorTest() {
        List<MonitorVO> monitorVOS = monitorService.getUserMonitor(3);
        assertEquals(monitorVOS.size(), 3);
    }

    @Test
    public void getProjectMonitorTest() {
        List<MonitorVO> monitorVOS = monitorService.getProjectMonitor(1);
        assertEquals(monitorVOS.size(),2);
    }
}
