package com.example.finclaw.data.model;

import com.example.finclaw.po.Model;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: GLH
 * @Date:   2020-10-12
 */
@Mapper
@Repository
public interface ModelMapper {

    int createNewModel(Model model);

    Model getModel(int modelID);

    /**
     * 得到所有的模型
     * @return
     */
    List<Model> getAllModel();
}
