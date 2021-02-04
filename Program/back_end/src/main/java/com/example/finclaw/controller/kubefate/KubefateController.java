package com.example.finclaw.controller.kubefate;

import com.example.finclaw.bl.kubefate.KubefateService;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private KubefateService kubefateService;

    @PostMapping("/deploy/{projectID}")
    public ResponseVO deploy(@PathVariable Integer projectID){
        return kubefateService.deploy(projectID);
    }

    @PostMapping
}
