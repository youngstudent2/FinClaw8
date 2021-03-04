package com.example.finclaw.data.attendance;
import static org.junit.Assert.assertEquals;

import com.example.finclaw.po.ServerInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerInfoMapperTest {
    @Autowired
    private ServerInfoMapper serverInfoMapper;

    @Test
    public void updateServerInfoTest(){
        ServerInfo serverInfo = new ServerInfo();
        serverInfo.setUserID(10);
        serverInfo.setProjectID(1);
        serverInfo.setFilePath("D:/finclaw8");
        serverInfo.setIpAddress("192.168.101.92");
        serverInfo.setServerName("wind");
        serverInfo.setServerPassword("123456");
        serverInfoMapper.updateServerInfo(serverInfo);
        assertEquals(Integer.valueOf(5), serverInfoMapper.getServerInfo(1, 10).getServerInfoID());
    }

}
