package com.example.finclaw.controller.kubefate;

import com.example.finclaw.bl.kubefate.KubefateService;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: LLY
 * @Date:   2021-2-3
 */
@RestController
@RequestMapping("/api/kubefate")
public class KubefateController {

    @Autowired
    private KubefateService kubefateService;

    @PostMapping("/deploy/{projectID}")
    public ResponseVO deploy(@PathVariable Integer projectID){
        return kubefateService.deploy(projectID);
    }

    @PostMapping("/upload/{projectID}")
    public ResponseVO upload(@PathVariable Integer projectID){
        return kubefateService.upload(projectID);
    }

    @PostMapping("/submit/{projectID}")
    public ResponseVO submit(@PathVariable Integer projectID){
        return kubefateService.submit(projectID);
    }

    @GetMapping("/query/{projectID}")
    public ResponseVO query(@PathVariable Integer projectID){
        return kubefateService.query(projectID);
    }

    @PostMapping("/loadBind/{projectID}")
    public ResponseVO loadBind(@PathVariable Integer projectID){
        return kubefateService.loadBind(projectID);
    }

    @GetMapping("/predict")
    public ResponseVO predict(){
        return kubefateService.predict();
    }

}
