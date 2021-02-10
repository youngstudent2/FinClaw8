package com.example.finclaw.controller.project;

import com.example.finclaw.bl.project.ProjectService;
import com.example.finclaw.vo.ResponseVO;
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
    private final static String NO_PROJECT_ERROR = "指定项目不存在";
    private final static String OTHER_ERROR = "其他错误";

    @Autowired
    private ProjectService projectService;

    @PostMapping("/addProject")
    public ResponseVO addProject(@RequestBody ProjectForm projectForm) {
        return projectService.addProject(projectForm);
    }

    @PostMapping("/deleteProject/{projectID}")
    public ResponseVO deleteProject(@PathVariable Integer projectID) {
        return projectService.deleteProject(projectID);
    }

    @PostMapping("/modifyProject/{projectID}")
    public ResponseVO modifyProject(@PathVariable int projectID, @RequestBody ProjectForm projectForm) {
        return projectService.modifyProject(projectID,projectForm);
    }

    @GetMapping("/getAllProjectInfo")
    public ResponseVO getAllProject() {
        try {
            List<ProjectVO> projectVOList =  projectService.getAllProject();
            return ResponseVO.buildSuccess(projectVOList);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
    }

    @GetMapping("/getProjectInfo/{projectID}")
    public ResponseVO getProjectInfo(@PathVariable Integer projectID) {
        try {
            ProjectVO projectVO = projectService.getProject(projectID);
            if (projectVO == null) {
                return ResponseVO.buildFailure(NO_PROJECT_ERROR);
            } else {
                return ResponseVO.buildSuccess(projectVO);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
    }

    @GetMapping("getAllBankProjectInfo/{userID}")
    public ResponseVO getAllBankProjectInfo(@PathVariable Integer userID){
        try {
            List<ProjectVO> projectVOList =  projectService.getAllBankProjectInfo(userID);
            return ResponseVO.buildSuccess(projectVOList);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
    }
}
