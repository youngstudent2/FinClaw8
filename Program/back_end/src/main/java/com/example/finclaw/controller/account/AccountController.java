package com.example.finclaw.controller.account;

import com.example.finclaw.bl.account.AccountService;
import com.example.finclaw.po.User;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.account.*;
import org.springframework.beans.BeanUtils;
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
    private final static String OTHER_ERROR = "其他错误";

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserLoginForm userLoginForm) {
        return accountService.login(userLoginForm);
    }

    @PostMapping("/register")
    public ResponseVO register(@RequestBody UserRegisterForm userRegisterForm) {
        return accountService.register(userRegisterForm);
    }

    @GetMapping("/getUserInfo/{userID}")
    public ResponseVO getUserInfo(@PathVariable int userID) {
        try {
            UserVO userVO = accountService.getUserInfo(userID);
            if (userVO == null) {
                return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
            }
            return ResponseVO.buildSuccess(userVO);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
    }

    @PostMapping("/updateUserInfo/{userID}")
    public ResponseVO updateUserInfo(@PathVariable int userID,@RequestBody UserForm userForm){
        return accountService.updateUserInfo(userID, userForm);
    }

    @PostMapping("/updatePassword/{userID}")
    public ResponseVO updatePassword(@PathVariable int userID,@RequestParam String oldPassword,@RequestParam String newPassword){
        return accountService.updatePassword(userID,oldPassword,newPassword);
    }

    // 表示该用户还没有经过认证
    @PostMapping("/registerIdentity/{userID}")
    public ResponseVO registerIdentity(@PathVariable int userID,@RequestParam int role){
        return accountService.registerIdentity(userID,role);
    }

    @GetMapping("/getAllUsers")
    public ResponseVO getAllUsers(){
        try {
            List<UserVO> userVOS = accountService.getAllUsers();
            return ResponseVO.buildSuccess(userVOS);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
    }

    @GetMapping("/getUnauthorizedUsers")
    public ResponseVO getUnauthorizedUsers(){
        try {
            List<UserVO> userVOS = accountService.getUnauthorizedUsers();
            return ResponseVO.buildSuccess(userVOS);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
    }
}
