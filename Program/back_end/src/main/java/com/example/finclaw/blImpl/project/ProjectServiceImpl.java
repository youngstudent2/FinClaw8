package com.example.finclaw.blImpl.project;

import com.example.finclaw.bl.project.ProjectService;
import com.example.finclaw.data.model.ModelMapper;
import com.example.finclaw.data.project.ProjectMapper;
import com.example.finclaw.enums.ProjectStatus;
import com.example.finclaw.po.Model;
import com.example.finclaw.po.Project;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.model.ModelVO;
import com.example.finclaw.vo.project.ProjectForm;
import com.example.finclaw.vo.project.ProjectVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cgc
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    private final static String NO_PROJECT_ERROR = "指定项目不存在";
    private final static String OTHER_ERROR = "其他错误";

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseVO addProject(ProjectForm projectForm) {
        Project project = new Project();
        BeanUtils.copyProperties(projectForm, project);
        project.setStatus(ProjectStatus.Running);
        try {
            projectMapper.createNewProject(project);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO deleteProject(Integer projectID) {
        if (projectExist(projectID)) {
            try {
                projectMapper.deleteProject(projectID);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                return ResponseVO.buildFailure(OTHER_ERROR);
            }
            return ResponseVO.buildSuccess();
        } else {
            return ResponseVO.buildFailure(NO_PROJECT_ERROR);
        }
    }

    @Override
    public ResponseVO modifyProject(int projectID, ProjectForm projectForm) {
        if (projectExist(projectID)) {
            try {
                Project project = new Project();
                BeanUtils.copyProperties(projectForm, project);
                project.setProjectID(projectID);
                projectMapper.modifyProject(project);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                return ResponseVO.buildFailure(OTHER_ERROR);
            }
            return ResponseVO.buildSuccess();
        } else {
            return ResponseVO.buildFailure(NO_PROJECT_ERROR);
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
    public List<ProjectVO> getAllBankProjectInfo(Integer userID) throws Exception {
        List<Project> projectList = projectMapper.getAllBankProjectInfo(userID);
        ArrayList<ProjectVO> projectVOArrayList = new ArrayList<>();
        for (Project project : projectList) {
            projectVOArrayList.add(new ProjectVO(project));
        }
        return projectVOArrayList;
    }

    @Override
    public List<ModelVO> getAllModel() throws Exception {
        List<Model> models = modelMapper.getAllModel();
        ArrayList<ModelVO> modelVOS = new ArrayList<>();
        for(Model model : models){
            modelVOS.add(new ModelVO(model));
        }
        return modelVOS;
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
