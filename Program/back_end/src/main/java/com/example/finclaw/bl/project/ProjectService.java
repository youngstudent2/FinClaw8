package com.example.finclaw.bl.project;

import com.example.finclaw.vo.cooperation.CooperationVO;
import com.example.finclaw.vo.project.ProjectForm;
import com.example.finclaw.vo.project.ProjectVO;

import java.util.List;

/**
 * @Author: GLH
 * @Date:   2020-10-11
 */
public interface ProjectService {

    Boolean addProject(ProjectForm projectForm);

    Boolean deleteProject(Integer projectID);

    Boolean modifyProject(ProjectVO projectVO);

    List<ProjectVO> getAllProject();

    ProjectVO getProject(Integer projectID);

    List<CooperationVO> getProjectCooperations(Integer projectID);
}
