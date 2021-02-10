package com.example.finclaw.data.attendance;

import com.example.finclaw.po.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttendMapper {

    void attendProject(Integer cooperationID, Integer projectID);

    void quitProject(Integer cooperationID, Integer projectID);

    void setReadyForProject(@Param("userID") Integer cooperationID, @Param("projectID") Integer projectID, @Param("isReady") boolean isReady);

    void setChosen(@Param("userID") Integer cooperationID, @Param("projectID") Integer projectID, @Param("isChosen") boolean isChosen);

    List<Integer> getCooperationProjectIDs(Integer cooperationID);

    List<Integer> getProjectDataProducerIDs(Integer projectID);

    Attendance getAttendanceInfo(@Param("userID") Integer userID, @Param("projectID") Integer projectID);
}

