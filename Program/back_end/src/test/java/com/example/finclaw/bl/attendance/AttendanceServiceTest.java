package com.example.finclaw.bl.attendance;

import static org.junit.Assert.assertEquals;

import com.example.finclaw.bl.account.AccountService;
import com.example.finclaw.enums.UserType;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.account.UserRegisterForm;
import com.example.finclaw.vo.server.ServerInfoForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttendanceServiceTest {
    @Autowired
    private AttendService attendService;
    @Autowired
    private AccountService accountService;

    @Test
    public void attendServiceTest(){
        register();
        attendProjectTest();
        setAttendInfoTest();
        quitProjectTest();
    }

    public void register(){
        UserRegisterForm userRegisterForm = new UserRegisterForm();
        userRegisterForm.setUsername("Hewenbing");
        userRegisterForm.setPassword("123456");
        userRegisterForm.setEmail("826947112@qq.com");
        userRegisterForm.setPhoneNumber("12345678911");
        userRegisterForm.setRole(UserType.DataProvider);
        accountService.register(userRegisterForm);
    }

    public void attendProjectTest(){
        attendService.attendProject(1, 9);
        try{
            assertEquals(false, attendService.getAttendanceInfo(1, 9).isChosen());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setAttendInfoTest(){
        attendService.setChosen(1, 9, true);
        attendService.setReadyForProject(1, 9, true);
        try {
            assertEquals(true, attendService.getAttendanceInfo(1, 9).isChosen());
            assertEquals(true, attendService.getAttendanceInfo(1, 9).isReady());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void quitProjectTest(){
        attendService.quitProject(1, 9);
        try {
            assertEquals(null, attendService.getAttendanceInfo(1, 9));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void updateServerInfoTest(){
        ServerInfoForm serverInfoForm = new ServerInfoForm();
        serverInfoForm.setUserID(9);
        serverInfoForm.setProjectID(1);
        serverInfoForm.setFilePath("D:/finclaw8");
        serverInfoForm.setIpAddress("192.168.101.92");
        serverInfoForm.setServerName("wind");
        serverInfoForm.setServerPassword("123456");
        ResponseVO responseVO = attendService.updateServerInfo(serverInfoForm);
        assertEquals(ResponseVO.buildSuccess().getSuccess(), responseVO.getSuccess());
    }

}

