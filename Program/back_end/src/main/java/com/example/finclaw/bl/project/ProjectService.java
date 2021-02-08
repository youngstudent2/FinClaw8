package com.example.finclaw.bl.project;

import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.project.ProjectForm;
import com.example.finclaw.vo.project.ProjectVO;

import java.util.List;

/**
 * @Author: cgc
 */
public interface ProjectService {

    ResponseVO addProject(ProjectForm projectForm);

    ResponseVO deleteProject(Integer projectID);

    ResponseVO modifyProject(int projectID, ProjectForm projectForm);

    List<ProjectVO> getAllProject();

    ProjectVO getProject(Integer projectID);
}
