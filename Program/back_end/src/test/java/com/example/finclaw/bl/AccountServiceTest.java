package com.example.finclaw.bl;

import com.example.finclaw.bl.account.AccountService;
import com.example.finclaw.data.account.AccountMapper;
import com.example.finclaw.enums.UserType;
import com.example.finclaw.po.User;
import com.example.finclaw.vo.account.UserForm;
import com.example.finclaw.vo.account.UserLoginForm;
import com.example.finclaw.vo.cooperation.CooperationForm;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    AccountService accountService;
    @Autowired
    AccountMapper accountMapper;

    @Test
    @Transactional
    public void registerDataManager() {
        UserForm userForm = new UserForm(){{
            setUsername("123");
            setCooperation("baidu");
            setEmail("1234@baidu.com");
            setPassword("123456");
            setPhoneNumber("123");
        }};
        boolean ans = accountService.registerDataManager(userForm);


        /*
        User user = accountMapper.getAccountByEmail("1234@baidu.com");
        boolean name = user.getUsername().equals("baidu");
        boolean cooperation = user.getCooperation().equals("baidu");
        boolean password = user.getPassword().equals("123456");
        boolean phone = user.getPassword().equals("123");

        Assert.assertThat(name,is(true));
        Assert.assertThat(cooperation,is(true));
        Assert.assertThat(password,is(true));
        Assert.assertThat(phone,is(true));

         */
        Assert.assertThat(ans,is(true));
    }

    @Test
    @Transactional
    public void registerCooperation() {
        CooperationForm cooperationForm = new CooperationForm(){{
            setCooperationName("baidu");
            setEmail("123@baidu.com");
            setManager("Robin");
            setPassword("123456");
            setPhoneNumber("123");
        }};
        accountService.registerCooperation(cooperationForm);

        User user = accountMapper.getAccountByEmail("123@baidu.com");
        boolean name = user.getUsername().equals("baidu");
        boolean cooperation = user.getCooperation().equals("baidu");
        boolean password = user.getPassword().equals("123456");

        Assert.assertThat(name,is(true));
        Assert.assertThat(cooperation,is(true));
        Assert.assertThat(password,is(true));
    }

    @Test
    @Transactional
    /**
     * 测试登陆成功的情况
     */
    public void login1() {
        UserLoginForm loginForm = new UserLoginForm();
        loginForm.setEmail("123@qq.com");
        loginForm.setPassword("123456");

        User user = new User(){{
            setUserID(1);
            setEmail("123@qq.com");
            setPassword("123456");
            setUsername("root");
            setPhoneNumber("123");
            setRole(UserType.Manager);
            setCooperation("中国银行");
        }};

        User userT = accountService.login(loginForm);
        boolean name = userT.getUsername().equals(user.getUsername());
        boolean phone = userT.getPhoneNumber().equals(user.getPhoneNumber());
        boolean role = userT.getRole().equals(user.getRole());
        boolean cooperation = userT.getCooperation().equals(user.getCooperation());
        Assert.assertThat(name,is(true));
        Assert.assertThat(phone,is(true));
        Assert.assertThat(role,is(true));
        Assert.assertThat(cooperation,is(true));
    }

    @Test
    @Transactional
    /**
     * 测试密码错误
     */
    public void login2() {
        UserLoginForm loginForm = new UserLoginForm();
        loginForm.setEmail("123@qq.com");
        loginForm.setPassword("12346");
        User userT = accountService.login(loginForm);
        boolean ans = userT == null;
        Assert.assertThat(ans,is(true));
    }

    @Test
    @Transactional
    /**
     * 测试用户名错误
     */
    public void login3() {
        UserLoginForm loginForm = new UserLoginForm();
        loginForm.setEmail("1234@qq.com");
        loginForm.setPassword("123456");
        User userT = accountService.login(loginForm);
        boolean ans = userT == null;
        Assert.assertThat(ans,is(true));
    }

    @Test
    @Transactional
    public void getUserInfo() {
    }

    @Test
    @Transactional
    public void deleteUser() {
    }

    @Test
    @Transactional
    public void updateUserInfo() {
    }

    @Test
    @Transactional
    public void updatePassword() {
    }

    @Test
    @Transactional
    public void getAllDataManagers() {
    }
}