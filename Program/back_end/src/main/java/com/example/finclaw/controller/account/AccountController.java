package com.example.finclaw.controller.account;

import com.example.finclaw.bl.account.AccountService;
import com.example.finclaw.po.User;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.account.UserForm;
import com.example.finclaw.vo.account.UserLoginForm;
import com.example.finclaw.vo.account.UserVO;
import com.example.finclaw.vo.cooperation.CooperationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CGC
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
        
    }

    @PostMapping("/register")
    public ResponseVO register(@RequestBody UserRegisterForm userRegisterForm) {

    }

    @GetMapping("/getUserInfo/{userID}")
    public ResponseVO getUserInfo(@PathVariable int userID) {
        UserVO userVO = accountService.getUserInfo(userID);
        if(userVO==null){
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }
        return ResponseVO.buildSuccess(userVO);
    }

    @PostMapping("/updateUserInfo/{userID}")
    public ResponseVO updateUserInfo(@PathVariable int userID,@RequestBody UserForm userForm){
        return accountService.updateUserInfo(userID, userForm);
    }

    @PostMapping("/updatePassword/{userID}")
    public ResponseVO updatePassword(@PathVariable int userID,@RequestParam String oldPassword,@RequestParam String newPassword){
        return accountService.updatePassword(userID,oldPassword,newPassword);
    }

    @PostMapping("/registerIdentity/{userID}")
    public ResponseVO updatePassword(@PathVariable int userID,@RequestParam int role){

    }

}
