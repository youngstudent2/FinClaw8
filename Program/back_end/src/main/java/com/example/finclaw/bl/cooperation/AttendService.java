package com.example.finclaw.bl.cooperation;

import com.example.finclaw.vo.cooperation.CooperationVO;
import com.example.finclaw.vo.project.ProjectVO;

import java.util.List;

public interface AttendService {

    void attendProject(Integer cooperationID, Integer projectID);

    void quitProject(Integer cooperationID, Integer projectID);

    void setReadyForProject(Integer cooperationID, Integer projectID);

    List<ProjectVO> getCooperationProjects(Integer cooperationID);

    List<CooperationVO> getProjectCooperations(Integer projectID);

    void uploadProjectFilepath(Integer cooperationID, Integer projectID, String filepath);
}
