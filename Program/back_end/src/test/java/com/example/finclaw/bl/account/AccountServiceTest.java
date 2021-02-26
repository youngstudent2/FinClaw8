package com.example.finclaw.bl.account;

import com.example.finclaw.enums.UserType;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.account.UserForm;
import com.example.finclaw.vo.account.UserRegisterForm;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void AccountServiceTest(){
        registerTest();
        updateUserInfoTest();
        updatePasswordTest();
        examineAuthenticationTest();
        deleteUserTest();
    }

    public void registerTest(){
        UserRegisterForm userRegisterForm = new UserRegisterForm();
        userRegisterForm.setUsername("Hewenbing");
        userRegisterForm.setPassword("123456");
        userRegisterForm.setEmail("826947112@qq.com");
        userRegisterForm.setPhoneNumber("12345678911");
        userRegisterForm.setRole(UserType.UnauthorizedDataProvider);
        ResponseVO responseVO = accountService.register(userRegisterForm);
        assertEquals(ResponseVO.buildSuccess().getSuccess(),responseVO.getSuccess());
    }

    public void updateUserInfoTest(){
        UserForm userForm = new UserForm();
        userForm.setEmail("826947112@qq.com");
        userForm.setUsername("hwb");
        userForm.setPhoneNumber("12345678911");
        accountService.updateUserInfo(9, userForm);
        assertEquals("hwb", accountService.getUserInfo(9).getUsername());
    }

    public void updatePasswordTest(){
        accountService.updatePassword(9, "123456", "654321");
        assertEquals("654321", accountService.getUserInfo(9).getPassword());
    }

    public void examineAuthenticationTest(){
        accountService.examineAuthentication(9, 1);
        assertEquals(UserType.DataProvider, accountService.getUserInfo(9).getRole());
    }

    public void deleteUserTest(){
        accountService.deleteUser(9);
        assertEquals(null, accountService.getUserInfo(9));
    }
}
