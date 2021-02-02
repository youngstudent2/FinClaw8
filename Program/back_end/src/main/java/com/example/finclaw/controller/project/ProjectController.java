package com.example.finclaw.controller.project;

import com.example.finclaw.bl.project.ProjectService;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.cooperation.CooperationVO;
import com.example.finclaw.vo.project.ProjectForm;
import com.example.finclaw.vo.project.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: CGC
 * @Date:   2021-2-2
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
        /*Boolean result = projectService.addProject(projectForm);
        if (result) {
            return ResponseVO.buildSuccess(PROJECT_CREATE_SUCCESS);
        } else {
            return ResponseVO.buildFailure(PROJECT_CREATE_ERROR);
        }*/
    }

    @PostMapping("/deleteProject/{projectID}")
    public ResponseVO deleteProject(@PathVariable Integer projectID) {
        /*Boolean result = projectService.deleteProject(projectID);
        if (result) {
            return ResponseVO.buildSuccess();
        } else {
            return ResponseVO.buildFailure(PROJECT_NOT_FOUND);
        }*/
    }

    @PostMapping("/modifyProject/{projectID}")
    public ResponseVO modifyProject(@PathVariable int projectID, @RequestBody ProjectForm projectForm) {

    }

    @GetMapping("/getAllProjectInfo")
    public ResponseVO getAllProject() {
        /*List<ProjectVO> projectVOList =  projectService.getAllProject();
        return ResponseVO.buildSuccess(projectVOList);*/
    }

    @GetMapping("/getProjectInfo/{projectID}")
    public ResponseVO getProjectInfo(@PathVariable Integer projectID) {
       /* ProjectVO projectVO = projectService.getProject(projectID);
        if (projectVO == null) {
            return ResponseVO.buildFailure(PROJECT_NOT_FOUND);
        } else {
            return ResponseVO.buildSuccess(projectVO);
        }*/
    }


}
