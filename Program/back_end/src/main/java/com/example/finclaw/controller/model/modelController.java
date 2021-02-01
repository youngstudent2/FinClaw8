package com.example.finclaw.controller.model;

import com.example.finclaw.bl.model.ModelService;
import com.example.finclaw.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: GLH
 * @Date:   2020-10-12
 */

@RestController
@RequestMapping("/api/model")
public class modelController {
    @Autowired
    private ModelService modelService;

    @GetMapping("/getAllModels")
    public ResponseVO getAllModels() {
        return ResponseVO.buildSuccess(modelService.getAllModels());
    }

    //用于测试
    @GetMapping("setModel")
    public ResponseVO setModel() {
        return modelService.addModel();
    }
}
