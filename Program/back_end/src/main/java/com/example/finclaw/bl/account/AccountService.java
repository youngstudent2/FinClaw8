package com.example.finclaw.bl.account;

import com.example.finclaw.vo.*;
import com.example.finclaw.vo.account.UserForm;
import com.example.finclaw.vo.account.UserLoginForm;
import com.example.finclaw.vo.account.UserRegisterForm;
import com.example.finclaw.vo.account.UserVO;

import java.util.List;

/**
 * @author cgc
 * @date 2021/2/3
 */
public interface AccountService {

    /**
     * 用户登录，登录成功会将用户信息保存在session中
     *
     * @return
     */
    ResponseVO login(UserLoginForm userLoginForm);

    /**
     * 注册账号
     *
     * @return
     */
    ResponseVO register(UserRegisterForm userRegisterForm);

    /**
     * 获取用户个人信息
     * @param userID
     * @return
     */
    UserVO getUserInfo(int userID);

    ResponseVO deleteUser(int userID);

    ResponseVO updateUserInfo(int userID,UserForm userForm);

    ResponseVO updatePassword(int userID,String oldPassword,String newPassword);

    ResponseVO registerIdentity(int userID,int role);

    /**
     * 获取所有用户的个人信息
     * @return
     */
    List<UserVO> getAllUsers() throws Exception;

    /**
     * 得到所有未认证的用户
     * @return
     * @throws Exception
     */
    List<UserVO> getUnauthorizedUsers() throws Exception;

    ResponseVO examineAuthentication(Integer userID, Integer isPassed);
}
