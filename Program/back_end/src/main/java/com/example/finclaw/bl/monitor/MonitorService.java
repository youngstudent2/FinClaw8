package com.example.finclaw.bl.monitor;
import com.example.finclaw.vo.monitor.MonitorFormVO;
import java.util.List;

public interface MonitorService {
    /**
     * 记录监控信息
     * @param projectID
     * @param userID
     * @param operatorID
     */
    void recordInfo(int userID, int projectID, int operatorID);

    /**
     * 查看项目的监控记录
     * @param projectID
     * @return
     */
    List<MonitorFormVO> getMonitorInfo(int projectID);

    /**
     * 查看特定操作的监控记录
     * @param projectID
     * @param operatorID
     * @return
     */
    List<MonitorFormVO> getMonitorInfo(int projectID, int operatorID);

    /**
     * 查看合作企业特定操作的监控记录
     * @param projectID
     * @param cooperationID
     * @param operatorID
     * @return
     */
    List<MonitorFormVO> getMonitorInfo(int projectID,int cooperationID, int operatorID);

    List<MonitorFormVO> getCooperationMonitorInfo(int projectID, int cooperationID);
}
