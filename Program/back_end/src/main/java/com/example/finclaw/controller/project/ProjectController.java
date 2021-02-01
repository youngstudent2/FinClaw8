package com.example.finclaw.controller.project;

import com.example.finclaw.bl.project.ProjectService;
import com.example.finclaw.vo.cooperation.CooperationVO;
import com.example.finclaw.vo.project.ProjectForm;
import com.example.finclaw.vo.project.ProjectVO;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: GLH
 * @Date:   2020-10-11
 */
@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final static String PROJECT_CREATE_SUCCESS = "项目创建成功";
    // 出错返回信息
    private final static String PROJECT_CREATE_ERROR = "项目创建失败";
    private final static String PROJECT_NOT_FOUND = "不存在该项目";

    @Autowired
    private ProjectService projectService;

    @PostMapping("/addProject")
    public ResponseVO addProject(@RequestBody ProjectForm projectForm) {
        Boolean result = projectService.addProject(projectForm);
        if (result) {
            return ResponseVO.buildSuccess(PROJECT_CREATE_SUCCESS);
        } else {
            return ResponseVO.buildFailure(PROJECT_CREATE_ERROR);
        }
    }

    @PostMapping("/deleteProject")
    public ResponseVO deleteProject(@RequestParam Integer projectID) {
        Boolean result = projectService.deleteProject(projectID);
        if (result) {
            return ResponseVO.buildSuccess();
        } else {
            return ResponseVO.buildFailure(PROJECT_NOT_FOUND);
        }
    }

    @PostMapping("/modifyProject")
    public ResponseVO modifyProject(@RequestBody ProjectVO projectVO) {
        Boolean result = projectService.modifyProject(projectVO);
        if (result) {
            return ResponseVO.buildSuccess();
        } else {
            return ResponseVO.buildFailure(PROJECT_NOT_FOUND);
        }
    }

    @GetMapping("/getAllProjectInfo")
    public ResponseVO getAllProject() {
        List<ProjectVO> projectVOList =  projectService.getAllProject();
        return ResponseVO.buildSuccess(projectVOList);
    }

    @GetMapping("/getProjectInfo")
    public ResponseVO getProjectInfo(@RequestParam Integer projectID) {
        ProjectVO projectVO = projectService.getProject(projectID);
        if (projectVO == null) {
            return ResponseVO.buildFailure(PROJECT_NOT_FOUND);
        } else {
            return ResponseVO.buildSuccess(projectVO);
        }
    }

    @GetMapping("/getProjectCooperations/{projectID}")
    public ResponseVO getProjectCooperations(@PathVariable Integer projectID) {
        List<CooperationVO> cooperationVOS = projectService.getProjectCooperations(projectID);
        return ResponseVO.buildSuccess(cooperationVOS);
    }
}
