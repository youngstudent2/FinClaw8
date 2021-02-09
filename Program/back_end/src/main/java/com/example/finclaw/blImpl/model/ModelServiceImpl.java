package com.example.finclaw.blImpl.model;

import com.example.finclaw.bl.kubefate.KubefateService;
import com.example.finclaw.bl.model.ModelService;
import com.example.finclaw.blImpl.kubefate.KubefateServiceImpl;
import com.example.finclaw.data.model.ModelMapper;
import com.example.finclaw.po.Model;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.model.ModelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GLH
 * @Date:   2020-10-12
 */
@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ModelVO> getAllModels() {
        List<Model> modelList = modelMapper.getAllModels();
        ArrayList<ModelVO> modelVOS = new ArrayList<>();
        for (Model model : modelList) {
            modelVOS.add(new ModelVO(model));
        }
        return modelVOS;
    }

    //用于测试，需要修改
    @Override
    public ResponseVO addModel() {
        KubefateService kubefateService = new KubefateServiceImpl();
        String[] userId = new String[]{"1"};
        String[] ip = new String[]{"39.105.36.203"};
        String[] pw = new String[]{"root123456"};
        String[] path = new String[]{"/finclaw/test.csv"};
        //kubefateService.deploy(userId,pw,ip,path,"test");
        return ResponseVO.buildSuccess();
    }
}
