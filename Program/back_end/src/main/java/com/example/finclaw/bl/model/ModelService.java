package com.example.finclaw.bl.model;

import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.model.ModelVO;

import java.util.List;

/**
 * @Author: GLH
 * @Date:   2020-10-12
 */
public interface ModelService {
    public List<ModelVO> getAllModels();

    //测试接口调用先写的方法
    public ResponseVO addModel();



}
