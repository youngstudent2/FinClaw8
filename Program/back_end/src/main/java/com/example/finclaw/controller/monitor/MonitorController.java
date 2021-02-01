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

    @PostMapping("/setMonitorInfo")
    public ResponseVO setMonitorInfo(@RequestParam int userID, @RequestParam int projectID, @RequestParam int operationID){
        monitorService.recordInfo(userID,projectID,operationID);
        return ResponseVO.buildSuccess();
    }

    @GetMapping("/getProjectMonitorInfo/{operatorID}")
    public ResponseVO getProjectMonitorInfo(@RequestParam int projectID){
        return ResponseVO.buildSuccess(monitorService.getMonitorInfo(projectID));
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
