package com.example.finclaw.data.cooperation;

import com.example.finclaw.po.ServerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ServerInfoMapper {
    /**
     * 上传服务器的相关信息，包括ip地址，root账户名，密码，文件存储地址
     * @param serverInfo
     * @return
     */
    int updateServerInfo(ServerInfo serverInfo);

    /**
     * 获取指定的server信息
     * @param projectID
     * @param userID
     * @return
     */
    ServerInfo getServerInfo(@Param("projectID") Integer projectID, @Param("userID") Integer userID);

    /**
     * 获取某project的所有server的信息
     * @param projectID
     * @return
     */
    List<ServerInfo> getProjectServerInfo(Integer projectID);
}
