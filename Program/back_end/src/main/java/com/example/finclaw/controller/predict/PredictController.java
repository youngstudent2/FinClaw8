package com.example.finclaw.controller.predict;

import com.example.finclaw.util.KubefateService;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.predict.PredictForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/predict")
public class PredictController {

    @Autowired
    private KubefateService kubefateService;

    @PostMapping("/predictCredit")
    public ResponseVO predictCredict(@RequestBody PredictForm predictForm) {
        System.out.println(predictForm.getProjectID());
        for (String value : predictForm.getFeatureVector()) {
            System.out.println(value);
        }
        double score = kubefateService.predict(predictForm.getProjectID()+"",predictForm.getFeatureVector());
        return ResponseVO.buildSuccess(score);
    }
}
