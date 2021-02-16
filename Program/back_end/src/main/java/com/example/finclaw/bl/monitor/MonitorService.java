package com.example.finclaw.bl.monitor;


import com.example.finclaw.vo.monitor.MonitorVO;
import java.util.List;

public interface MonitorService {

    void recordInfo(int userID, int projectID, int operatorID);

    List<MonitorVO> getAllOperation();

    List<MonitorVO> getProjectMonitor(int projectID);

    List<MonitorVO> getUserMonitor(int userID);
}
