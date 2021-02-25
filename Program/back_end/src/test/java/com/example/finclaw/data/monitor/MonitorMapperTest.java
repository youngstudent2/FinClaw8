package com.example.finclaw.data.monitor;

import com.example.finclaw.po.Monitor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonitorMapperTest {
    @Autowired
    private MonitorMapper monitorMapper;

    @Test
    public void monitorTest() {
        monitorMapper.createNewRecord(999,999,"Add");
        assertEquals(1, monitorMapper.getProjectMonitor(999).size());
        assertEquals(1, monitorMapper.getUserMonitor(999).size());
        for (Monitor monitor : monitorMapper.getAllMonitor()) {
            if (monitor.getProjectID() == 999 && monitor.getUserID() == 999 & monitor.getOperation().equals("Add")) {
                return;
            }
        }
        fail();
    }
}
