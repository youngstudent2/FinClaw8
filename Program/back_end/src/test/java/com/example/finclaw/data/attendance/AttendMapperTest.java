package com.example.finclaw.data.attendance;
import static org.junit.Assert.assertEquals;

import com.example.finclaw.data.account.AccountMapper;
import com.example.finclaw.enums.UserType;
import com.example.finclaw.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttendMapperTest {
    @Autowired
    private AttendMapper attendMapper;
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void attendMapperTest(){
        User user = new User();
        user.setUsername("Hewenbing");
        user.setPassword("123456");
        user.setEmail("826947112@qq.com");
        user.setPhoneNumber("12345678911");
        user.setRole(UserType.DataProvider);
        accountMapper.createNewAccount(user);

        attendProjectTest();
        setReadyForProjectTest();
        setChosenTest();
        quitProjectTest();

        accountMapper.deleteUser(13);
    }

    public void attendProjectTest(){
        attendMapper.attendProject(13, 1);
        assertEquals(false, attendMapper.getAttendanceInfo(13, 1).isChosen());
    }

    public void setReadyForProjectTest(){
        attendMapper.setReadyForProject(13, 1, true);
        assertEquals(true, attendMapper.getAttendanceInfo(13, 1).isReady());
    }

    public void setChosenTest(){
        attendMapper.setChosen(13, 1, true);
        assertEquals(true, attendMapper.getAttendanceInfo(13, 1).isChosen());
    }

    public void quitProjectTest(){
        attendMapper.quitProject(13, 1);
        assertEquals(null,attendMapper.getAttendanceInfo(13, 1));
    }
}
