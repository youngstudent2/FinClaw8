package com.example.finclaw.controller.monitor;

import com.example.finclaw.bl.monitor.MonitorService;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hx
 * @date 2020/10/16
 *
 * update cyr
 * date 2020/10/23
 */

@RestController
@RequestMapping("api/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    /**
     * 用于埋点，记录新的监控信息
     * 当用户进行了需要监控的操作时，就要调用这个接口
     * @param userID
     * @param projectID
     * @param operationID
     * @return
     */
    @PostMapping("/setMonitorInfo")
    public ResponseVO setMonitorInfo(@RequestParam int userID, @RequestParam int projectID, @RequestParam int operationID){
        monitorService.recordInfo(userID,projectID,operationID);
        return ResponseVO.buildSuccess();
    }


    /**
     * 获得所有的监控信息
     * @return
     */
    @GetMapping("/getAllOperation")
    public ResponseVO getAllOperation(){
        return ResponseVO.buildSuccess(monitorService.getAllOperation());
    }


    /**
     * 获得特定项目的监控信息
     * @param projectID
     * @return
     */
    @GetMapping("/getProjectOperation")
    public ResponseVO getProjectOperation(@RequestParam int projectID){
        return ResponseVO.buildSuccess(monitorService.getProjectMonitor(projectID));
    }


    /**
     * 获得特定用户的监控信息
     * @param userID
     * @return
     */
    @GetMapping("/getUserOperation")
    public ResponseVO getUserOperation(@RequestParam int userID){
        return ResponseVO.buildSuccess(monitorService.getUserMonitor(userID));
    }

    /*
    @GetMapping("/getMonitorInfo/{operatorID}")
    public ResponseVO getMonitorInfo(@RequestParam int projectID, @PathVariable int operatorID){
        return ResponseVO.buildSuccess(monitorService.getMonitorInfo(projectID,operatorID));
    }

    @GetMapping("/getCooperationMonitorInfo/{operatorID}")
    public ResponseVO getCooperationMonitorInfo(@RequestParam int projectID, @RequestParam int cooperationID, @PathVariable int operatorID){

        return ResponseVO.buildSuccess();
    }

     */
}
