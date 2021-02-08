package com.example.finclaw.data.cooperation;

import com.example.finclaw.po.ServerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ServerInfoMapper {
    /**
     * 获取某project的所有server的信息
     * @param projectID
     * @return
     */
    List<ServerInfo> getProjectServerInfo(Integer projectID);
}
