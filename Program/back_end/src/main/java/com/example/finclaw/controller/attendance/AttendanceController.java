package com.example.finclaw.controller.attendance;

import com.example.finclaw.bl.attendance.AttendService;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.account.UserVO;
import com.example.finclaw.vo.project.ProjectVO;
import com.example.finclaw.vo.server.ServerInfoForm;
import com.example.finclaw.vo.server.ServerInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: CGC
 * @Date:   2021-2-2
 * 注：这里所谓的 Cooperation 实际上指的是 DataProvider（数据提供方）
 *     因此实际是用于 数据提供方
 */
@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private final static String OTHER_ERROR = "其他错误";

    @Autowired
    private AttendService attendService;

    @PostMapping("/attendProject/{projectID}/{cooperationID}")
    public ResponseVO attendProject(@PathVariable Integer projectID, @PathVariable Integer cooperationID) {
        return attendService.attendProject(projectID, cooperationID);
    }

    @PostMapping("/quitProject/{projectID}/{cooperationID}")
    public ResponseVO quitProject(@PathVariable Integer projectID, @PathVariable Integer cooperationID) {
        return attendService.quitProject(projectID, cooperationID);
    }

    @PostMapping("/updateServerInfo")
    public ResponseVO updateServerInfo(@RequestBody ServerInfoForm serverInfoForm) {
        //数据提供方填好表单后上传服务器的相关信息，包括ip地址，root账户名，密码，文件存储地址(感觉还需要userID和projectID吧)
        return attendService.updateServerInfo(serverInfoForm);
    }

    @PostMapping("/setReadyStatus/{projectID}/{cooperationID}")
    public ResponseVO setReadyStatus(@PathVariable Integer projectID, @PathVariable Integer cooperationID, @RequestParam boolean isReady) {
        return attendService.setReadyForProject(projectID, cooperationID, isReady);
    }

    @PostMapping("/setChosenStatus/{projectID}/{cooperationID}")
    public ResponseVO setChosenStatus(@PathVariable Integer projectID, @PathVariable Integer cooperationID, @RequestParam boolean isChosen) {
        //现在的处理方式是数据提供方申请加入项目时直接同意，然后用attendance表中的isChosen来标识项目是否采纳该数据提供方数据
        return attendService.setChosen(projectID, cooperationID, isChosen);
    }

    @GetMapping("/getAllAttendedProjects/{cooperationID}")
    public ResponseVO getAllAttendedProjects(@PathVariable Integer cooperationID) {
        try {
            List<ProjectVO> projectVOList = attendService.getCooperationProjects(cooperationID);
            return ResponseVO.buildSuccess(projectVOList);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
    }

    @GetMapping("/getServerInfo/{projectID}/{cooperationID}")
    public ResponseVO getServerInfo(@PathVariable Integer projectID, @PathVariable Integer cooperationID) {
        try {
            ServerInfoVO serverInfoVO = attendService.getServerInfo(projectID,cooperationID);
            return ResponseVO.buildSuccess(serverInfoVO);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
    }

    @GetMapping("/getProjectCooperation/{projectID}")
    public ResponseVO getProjectCooperation(@PathVariable Integer projectID){
        try {
            List<UserVO> userVOS= attendService.getProjectDataProducers(projectID);
            return ResponseVO.buildSuccess(userVOS);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
    }
}
