package com.example.finclaw.controller.account;

import com.example.finclaw.bl.account.AccountService;
import com.example.finclaw.po.User;
import com.example.finclaw.vo.account.UserForm;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.account.UserLoginForm;
import com.example.finclaw.vo.account.UserVO;
import com.example.finclaw.vo.cooperation.CooperationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hwb
 *
 */

@RestController()
@RequestMapping("/api/account")
public class AccountController {
    private final static String ACCOUNT_INFO_ERROR = "用户名或密码错误";
    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserLoginForm userLoginForm) {
        User user = accountService.login(userLoginForm);
        if (user == null) {
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }
        return ResponseVO.buildSuccess(user);
    }

    @GetMapping("/{userID}/getUserInfo")
    public ResponseVO getUserInfo(@PathVariable int userID) {
        UserVO userVO = accountService.getUserInfo(userID);
        if(userVO==null){
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }
        return ResponseVO.buildSuccess(userVO);
    }

    @PostMapping("/{userID}/updateUserInfo")
    public ResponseVO updateUserInfo(@PathVariable int userID,@RequestBody UserForm userForm){
        return accountService.updateUserInfo(userID, userForm);
    }

    @PostMapping("/{userID}/updatePassword")
    public ResponseVO updatePassword(@PathVariable int userID,@RequestParam String oldPassword,@RequestParam String newPassword){
        return accountService.updatePassword(userID,oldPassword,newPassword);
    }

    @PostMapping("/registerDataManager")
    public ResponseVO registerDataManager(@RequestBody UserForm userForm) {
        accountService.registerDataManager(userForm);
        return ResponseVO.buildSuccess();
    }

    @PostMapping("/registerCooperation")
    public ResponseVO registerCooperation(@RequestBody CooperationForm cooperationForm) {
        accountService.registerCooperation(cooperationForm);
        return ResponseVO.buildSuccess();
        // ToDo 检测一下注册的email是否重复，不然重复注册数据库会出问题的
    }

    @PostMapping("/{userID}/deleteUser")
    public ResponseVO deleteUser(@PathVariable int userID){
        return accountService.deleteUser(userID);
    }

    @GetMapping("/getAllDataManagers")
    public ResponseVO getAllDataManagers() {
        List<UserVO> userVOList = accountService.getAllDataManagers();
        return ResponseVO.buildSuccess(userVOList);
    }
}
