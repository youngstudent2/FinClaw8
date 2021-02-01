package com.example.finclaw.controller.cooperation;

import com.example.finclaw.bl.cooperation.CooperationService;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.cooperation.CooperationServiceForm;
import com.example.finclaw.vo.project.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: GLH
 * @Date:   2020-10-11
 */
@RestController
@RequestMapping("/api/cooperation")
public class CooperationController {

    @Autowired
    private CooperationService cooperationService;

    @PostMapping("/attendProject/{projectID}")
    public ResponseVO attendProject(@PathVariable Integer projectID, @RequestParam Integer cooperationID) {
        cooperationService.addCooperationToProject(cooperationID, projectID);
        return ResponseVO.buildSuccess();
    }

    @PostMapping("/quitProject/{projectID}")
    public ResponseVO quitProject(@PathVariable Integer projectID, @RequestParam Integer cooperationID) {
        cooperationService.deleteCooperationFromProject(cooperationID, projectID);
        return ResponseVO.buildSuccess();
    }

    @PostMapping("/uploadServiceInfo")
    public ResponseVO uploadServiceInfo(@RequestBody CooperationServiceForm cooperationServiceForm) {
        cooperationService.uploadServiceInfo(cooperationServiceForm);
        return ResponseVO.buildSuccess();
    }

    @PostMapping("/uploadFilepath")
    public ResponseVO uploadFilepath(@RequestParam Integer cooperationID, @RequestParam Integer projectID, @RequestParam String filepath) {
        cooperationService.uploadProjectFilepath(cooperationID, projectID, filepath);
        return ResponseVO.buildSuccess();
    }

    @PostMapping("/setReady")
    public ResponseVO setReady(@RequestParam Integer cooperationID, @RequestParam Integer projectID) {
        cooperationService.setCooperationReady(cooperationID, projectID);
        return ResponseVO.buildSuccess();
    }

    @GetMapping("/getAllAttendedProjects/{cooperationID}")
    public ResponseVO getAllAttendedProjects(@PathVariable Integer cooperationID) {
        List<ProjectVO> projectVOList = cooperationService.getCooperationProjects(cooperationID);
        return ResponseVO.buildSuccess(projectVOList);
    }

    @GetMapping("/getAllUnAttendedProjects/{cooperationID}")
    public ResponseVO getAllUnAttendedProjects(@PathVariable Integer cooperationID) {
        List<ProjectVO> projectVOList = cooperationService.getCooperationUnAttendedProjects(cooperationID);
        return ResponseVO.buildSuccess(projectVOList);
    }

    @GetMapping("/getAllCooperations")
    public ResponseVO getAllCooperations() {
        return ResponseVO.buildSuccess();
    }
}
