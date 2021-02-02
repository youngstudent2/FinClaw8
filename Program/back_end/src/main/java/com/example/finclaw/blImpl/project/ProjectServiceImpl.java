package com.example.finclaw.blImpl.project;

import com.example.finclaw.bl.cooperation.AttendService;
import com.example.finclaw.bl.project.ProjectService;
import com.example.finclaw.data.project.ProjectMapper;
import com.example.finclaw.enums.ProjectStatus;
import com.example.finclaw.po.Project;
import com.example.finclaw.vo.cooperation.CooperationVO;
import com.example.finclaw.vo.project.ProjectForm;
import com.example.finclaw.vo.project.ProjectVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GLH
 * @Date:   2020-10-11
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private AttendService attendService;

    @Override
    public Boolean addProject(ProjectForm projectForm) {
        Project project = new Project();
        BeanUtils.copyProperties(projectForm, project);
        project.setStatus(ProjectStatus.Running);
        projectMapper.createNewProject(project);
        return true;
    }

    @Override
    public Boolean deleteProject(Integer projectID) {
        if (projectExist(projectID)) {
            projectMapper.deleteProject(projectID);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean modifyProject(ProjectVO projectVO) {
        if (projectExist(projectVO.getProjectID())) {
            Project project = new Project();
            BeanUtils.copyProperties(projectVO, project);
            projectMapper.modifyProject(project);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<ProjectVO> getAllProject() {
        List<Project> projectList = projectMapper.getAllProjects();
        ArrayList<ProjectVO> projectVOArrayList = new ArrayList<>();
        for (Project project : projectList) {
            projectVOArrayList.add(new ProjectVO(project));
        }
        return projectVOArrayList;
    }

    @Override
    public ProjectVO getProject(Integer projectID) {
        Project project = projectMapper.getProjectByID(projectID);
        if (project == null) {
            return null;
        }
        return new ProjectVO(project);
    }

    @Override
    public List<CooperationVO> getProjectCooperations(Integer projectID) {
        return attendService.getProjectCooperations(projectID);
    }

    /**
     * 检验某个projectID是否在数据库中存在对应的一行
     * @param projectID 待查询的ID
     * @return 是否存在
     */
    private Boolean projectExist(Integer projectID) {
        Project project = projectMapper.getProjectByID(projectID);
        return project != null;
    }
}
