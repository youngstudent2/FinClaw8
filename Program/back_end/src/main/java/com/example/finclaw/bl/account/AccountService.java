package com.example.finclaw.bl.account;

import com.example.finclaw.po.User;
import com.example.finclaw.vo.*;
import com.example.finclaw.vo.account.UserForm;
import com.example.finclaw.vo.account.UserLoginForm;
import com.example.finclaw.vo.account.UserVO;
import com.example.finclaw.vo.cooperation.CooperationForm;

import java.util.List;

/**
 * @author huwen
 * @date 2019/3/23
 */
public interface AccountService {

    /**
     * 注册账号
     *
     * @return
     */
    Boolean registerDataManager(UserForm userForm);

    Boolean registerCooperation(CooperationForm cooperationForm);

    /**
     * 用户登录，登录成功会将用户信息保存再session中
     *
     * @return
     */
    User login(UserLoginForm userLoginForm);

    /**
     * 获取用户个人信息
     * @param userID
     * @return
     */
    UserVO getUserInfo(int userID);

    ResponseVO deleteUser(int userID);

    ResponseVO updateUserInfo(int userID,UserForm userForm);

    ResponseVO updatePassword(int userID,String oldPassword,String newPassword);

    List<UserVO> getAllDataManagers();

}
