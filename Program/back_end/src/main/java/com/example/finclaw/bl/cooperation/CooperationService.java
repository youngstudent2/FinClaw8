package com.example.finclaw.bl.cooperation;

import com.example.finclaw.vo.cooperation.CooperationVO;
import com.example.finclaw.vo.project.ProjectVO;

import java.util.List;

/**
 * @Author: GLH
 * @Date:   2020-10-11
 */
public interface CooperationService {

    void addCooperationToProject(Integer cooperationID, Integer projectID);

    void deleteCooperationFromProject(Integer cooperationID, Integer projectID);

    void uploadServiceInfo(CooperationServiceForm cooperationServiceForm);

    void uploadProjectFilepath(Integer cooperationID, Integer projectID, String filepath);

    void setCooperationReady(Integer cooperationID, Integer projectID);

    List<ProjectVO> getCooperationProjects(Integer cooperationID);

    List<ProjectVO> getCooperationUnAttendedProjects(Integer cooperationID);

    CooperationVO getCooperationById(Integer cooperationID);

    List<CooperationVO> getAllCooperations();
}
