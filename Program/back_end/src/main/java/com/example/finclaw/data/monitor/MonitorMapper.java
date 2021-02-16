package com.example.finclaw.data.monitor;

import com.example.finclaw.po.Monitor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MonitorMapper {

    void createNewRecord(Integer userID, Integer projectID, String operation);

    List<Monitor> getProjectMonitor(Integer projectID);

    List<Monitor> getUserMonitor(Integer userID);

    List<Monitor> getAllMonitor();

}
