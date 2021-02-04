package com.example.finclaw.controller.kubefate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LLY
 * @Date:   2021-2-3
 */
@RestController
@RequestMapping("/api/kubefate")
public class KubefateController {
    private static String DEPLOY_ERROR = "部署失败";
    private static String DEPLOY_SUCCESS = "部署成功";
    private static String TRAIN_ERROR = "启动训练失败";
    private static String TRAIN_SUCCESS = "成功开始训练";
    @PostMapping("/deploy")
    public
}
