package com.example.finclaw.data.cooperation;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttendMapper {

    void attendProject(Integer cooperationID, Integer projectID);

    void quitProject(Integer cooperationID, Integer projectID);

    void setReadyForProject(Integer cooperationID, Integer projectID);

    Integer getAuthority(Integer cooperationID, Integer projectID);

    void openAuthority(Integer cooperationID, Integer projectID);

    void closeAuthority(Integer cooperationID, Integer projectID);

    void uploadProjectFilepath(Integer cooperationID, Integer projectID, String filepath);

    List<Integer> getCooperationProjectIDs(Integer cooperationID);

    List<Integer> getProjectCooperationIDs(Integer projectID);
}

