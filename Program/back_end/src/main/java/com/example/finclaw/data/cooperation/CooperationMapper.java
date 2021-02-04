package com.example.finclaw.data.cooperation;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: GLH
 * @Date:   2020-10-11
 */
@Mapper
@Repository
public interface CooperationMapper {

    /**
     * 注册新的合作方
     * @param cooperation
     */
    void addCooperation(Cooperation cooperation);


    /**
     * 修改合作方的ip地址，主机名和密码
     * @param cooperation
     */
    void uploadServiceInfo(Cooperation cooperation);

    List<Cooperation> getAllCooperation();

    Cooperation getCooperationByCooperationID(Integer CooperationID);

    Integer getCooperationIDByName(String cooperationName);
}
