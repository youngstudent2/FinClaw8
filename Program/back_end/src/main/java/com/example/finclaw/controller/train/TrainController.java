package com.example.finclaw.controller.train;

import com.example.finclaw.bl.train.TrainService;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: LLY
 * @Date: 2020-10-23
 */
@RestController
@RequestMapping("/api/train")
public class TrainController {
    private static String DEPLOY_ERROR = "部署失败";
    private static String DEPLOY_SUCCESS = "部署成功";
    private static String TRAIN_ERROR = "启动训练失败";
    private static String TRAIN_SUCCESS = "成功开始训练";

    @Autowired
    TrainService trainService;

    //根据项目ID部署并开始项目训练
    @PostMapping("/startTrain/{projectID}")
    public ResponseVO startDeploy(@PathVariable Integer projectID) {
        if (trainService.startDeploy(projectID)) {
            boolean flag = trainService.startTrain(projectID);
            if (flag) {
                return ResponseVO.buildSuccess(TRAIN_SUCCESS);
            } else {
                return ResponseVO.buildFailure(TRAIN_ERROR);
            }

        } else {
            return ResponseVO.buildFailure(DEPLOY_ERROR);
        }
    }

   /* //根据项目ID启动项目训练
    @PostMapping("/train/{projectID}")
    public ResponseVO startTrain(@PathVariable Integer projectID) {
        if (trainService.startTrain(projectID)) {
            return ResponseVO.buildSuccess(TRAIN_SUCCESS);
        } else {
            return ResponseVO.buildFailure(TRAIN_ERROR);
        }
    }*/


}
