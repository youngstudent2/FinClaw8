package com.example.finclaw.data.account;

import com.example.finclaw.enums.UserType;
import com.example.finclaw.po.User;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountMapperTest {
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void accountMapperTest(){
        createNewAccountTest();
        updatePasswordTest();
        setRoleTest();
        deleteUserTest();
    }

    public void createNewAccountTest(){
        User user = new User();
        user.setUsername("Hewenbing");
        user.setPassword("123456");
        user.setEmail("826947112@qq.com");
        user.setPhoneNumber("12345678911");
        user.setRole(UserType.UnauthorizedDataProvider);
        accountMapper.createNewAccount(user);
        assertEquals(user.getUserID(), accountMapper.getAccountByEmail("826947112@qq.com").getUserID());
    }

    public void updatePasswordTest(){
        User user = accountMapper.getAccountByEmail("826947112@qq.com");
        accountMapper.updatePassword(user.getUserID(),"654321");
        user.setPassword("654321");
        assertEquals(user.getUserID(),accountMapper.getAccountByEmail("826947112@qq.com").getUserID());
    }

    public void setRoleTest(){
        User user = accountMapper.getAccountByEmail("826947112@qq.com");
        user.setRole(UserType.DataProvider);
        accountMapper.setRole(user.getUserID(), UserType.DataProvider);
        assertEquals(user.getUserID(), accountMapper.getAccountByEmail("826947112@qq.com").getUserID());
    }

    public void deleteUserTest(){
        accountMapper.deleteUser(12);
        assertEquals(null, accountMapper.getAccountByEmail("826947112@qq.com"));
    }

}
