package com.example.finclaw.data.monitor;

import com.example.finclaw.po.MonitorForm;
import com.example.finclaw.vo.monitor.MonitorFormVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface MonitorMapper {
    /**
     * 添加新的监控记录
     * @param monitorForm
     * @return
     */
    int createNewRecord(MonitorForm monitorForm);

    /**
     * 获取项目的所有监控记录
     * @param projectID
     * @return
     */
    List<MonitorForm> getProjectMonitorForms(int projectID);

    /**
     * 获取合作方对应项目的所有监控记录
     * @param projectID
     * @param cooperationID
     * @return
     */
    List<MonitorForm> getCooperationMonitorInfo(int projectID, int cooperationID);
}
