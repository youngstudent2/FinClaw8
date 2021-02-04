package com.example.finclaw.controller.cooperation;

import com.example.finclaw.bl.cooperation.CooperationService;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: CGC
 * @Date:   2021-2-2
 */
@RestController
@RequestMapping("/api/cooperation")
public class CooperationController {

    @Autowired
    private CooperationService cooperationService;

    @PostMapping("/attendProject/{projectID}/{cooperationID}")
    public ResponseVO attendProject(@PathVariable Integer projectID, @PathVariable Integer cooperationID) {
        /*cooperationService.addCooperationToProject(cooperationID, projectID);
        return ResponseVO.buildSuccess();*/
    }

    @PostMapping("/quitProject/{projectID}/{cooperationID}")
    public ResponseVO quitProject(@PathVariable Integer projectID, @PathVariable Integer cooperationID) {
        /*cooperationService.deleteCooperationFromProject(cooperationID, projectID);
        return ResponseVO.buildSuccess();*/
    }

    @PostMapping("/updateServerInfo")
    public ResponseVO updateServerInfo(@RequestBody ServerInfoForm serverInfoForm) {
        //数据提供方填好表单后上传服务器的相关信息，包括ip地址，root账户名，密码，文件存储地址
    }


    @PostMapping("/setReadyStatus/{projectID}/{cooperationID}")
    public ResponseVO setReady(@PathVariable Integer cooperationID, @PathVariable Integer projectID, @RequestParam boolean isReady) {
        /*cooperationService.setCooperationReady(cooperationID, projectID);
        return ResponseVO.buildSuccess();*/
    }

    @PostMapping("/setChosenStatus/{projectID}/{cooperationID}")
    public ResponseVO setChosen(@PathVariable Integer cooperationID, @PathVariable Integer projectID, @RequestParam boolean isChosen) {
        //现在的处理方式是数据提供方申请加入项目时直接同意，然后用attendance表中的isChosen来标识项目是否采纳该数据提供方数据
    }

    @GetMapping("/getAllAttendedProjects/{cooperationID}")
    public ResponseVO getAllAttendedProjects(@PathVariable Integer cooperationID) {
        /*List<ProjectVO> projectVOList = cooperationService.getCooperationProjects(cooperationID);
        return ResponseVO.buildSuccess(projectVOList);*/
    }

    @GetMapping("/getServerInfo/{projectID}/{cooperationID}")
    public ResponseVO getServerInfo(@PathVariable Integer cooperationID, @PathVariable Integer projectID) {

    }

    @GetMapping("/getProjectCooperation/{projectID}")
    public ResponseVO getProjectCooperation(@PathVariable Integer projectID){

    };
}
