package com.example.finclaw.bl.account;

import com.example.finclaw.enums.UserType;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.account.UserForm;
import com.example.finclaw.vo.account.UserLoginForm;
import com.example.finclaw.vo.account.UserRegisterForm;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.finclaw.vo.account.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    private final static String ACCOUNT_INFO_ERROR = "用户名或密码错误";
    private final static String EMAIL_EXIST = "该邮箱已注册";

    @Test
    public void AccountServiceTest(){
        getAllUsersTest();
        getUnauthorizedUsersTest();
        registerTest();
        registerErrorTest();
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

    @Test
    public void loginTest(){
        UserLoginForm userLoginForm = new UserLoginForm();
        userLoginForm.setEmail("826@qq.com");
        userLoginForm.setPassword("123456");
        ResponseVO responseVO = accountService.login(userLoginForm);
        assertEquals(ACCOUNT_INFO_ERROR, responseVO.getMessage());
    }

    public void registerErrorTest(){
        UserRegisterForm userRegisterForm = new UserRegisterForm();
        userRegisterForm.setEmail("826947112@qq.com");
        userRegisterForm.setPassword("123456");
        userRegisterForm.setPhoneNumber("12345678911");
        userRegisterForm.setRole(UserType.UnauthorizedDataProvider);
        userRegisterForm.setUsername("Hewenbing");
        ResponseVO responseVO = accountService.register(userRegisterForm);
        assertEquals(EMAIL_EXIST, responseVO.getMessage());
    }

    public void registerIdentityTest(){
        accountService.registerIdentity(9, 6);
        assertEquals(UserType.UnauthorizedCompany, accountService.getUserInfo(9).getRole());
    }

    public void getAllUsersTest(){
        try{
            List<UserVO> userVOs = accountService.getAllUsers();
            for(int i=0;i<userVOs.size();i++){
                assertTrue(getAllUsersContained(userVOs.get(i).getUserID()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean getAllUsersContained(int i){
        if(i>=0 && i<=8){
            return true;
        }else{
            return false;
        }
    }

    public void getUnauthorizedUsersTest(){
        try{
            List<UserVO> userVOs = accountService.getUnauthorizedUsers();
            for(int i=0;i<userVOs.size();i++){
                assertTrue(getUnauthorizedUsersContained(userVOs.get(i).getUserID()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean getUnauthorizedUsersContained(int i){
        if(i==8){
            return true;
        }else{
            return false;
        }
    }

}
