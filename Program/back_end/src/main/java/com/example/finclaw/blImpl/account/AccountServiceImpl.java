package com.example.finclaw.blImpl.account;

import com.example.finclaw.bl.account.AccountService;
import com.example.finclaw.data.account.AccountMapper;
import com.example.finclaw.enums.UserType;
import com.example.finclaw.po.User;
import com.example.finclaw.vo.account.UserForm;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.account.UserLoginForm;
import com.example.finclaw.vo.account.UserRegisterForm;
import com.example.finclaw.vo.account.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cgc
 */

@Service
public class AccountServiceImpl implements AccountService {
    private final static String ACCOUNT_EXIST = "账号已存在";
    private final static String UPDATE_ERROR = "修改失败";
    private final static String ACCOUNT_INFO_ERROR = "用户名或密码错误";
    private final static String OTHER_ERROR = "其他错误";

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public ResponseVO login(UserLoginForm userLoginForm) {
        User user = accountMapper.getAccountByEmail(userLoginForm.getEmail());
        if (null == user || !user.getPassword().equals(userLoginForm.getPassword())) {
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }
        return ResponseVO.buildSuccess(user);
    }

    @Override
    public ResponseVO register(UserRegisterForm userRegisterForm) {
        User user = new User();
        BeanUtils.copyProperties(userRegisterForm,user);
        try {
            accountMapper.createNewAccount(user);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public UserVO getUserInfo(int userID) {
        User user = accountMapper.getAccountById(userID);
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return userVO;
    }

    @Override
    public ResponseVO deleteUser(int userID) {
        try {
            accountMapper.deleteUser(userID);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO updateUserInfo(int userID,UserForm userForm) {
        User user = accountMapper.getAccountById(userID);
        BeanUtils.copyProperties(userForm, user);
        accountMapper.updateUserInfo(user);
        return ResponseVO.buildSuccess("修改成功");
    }

    @Override
    public ResponseVO updatePassword(int userID,String oldPassword,String newPassword) {
        User user = accountMapper.getAccountById(userID);
        if(user.getPassword().equals(oldPassword)){
            accountMapper.updatePassword(userID,newPassword);
        }
        else{
            return ResponseVO.buildFailure("密码错误");
        }
        return ResponseVO.buildSuccess("修改成功");
    }

    @Override
    public ResponseVO registerIdentity(int userID, int role) {
        UserType roleType;
        // 注意：表示该用户还没有经过认证
        switch (role){
            case 1:
            case 5:
                roleType=UserType.UnauthorizedBank;
                break;
            case 2:
            case 6:
                roleType=UserType.UnauthorizedCompany;
                break;
            case 3:
            case 7:
                roleType=UserType.UnauthorizedDataProvider;
                break;
            default:
                return ResponseVO.buildFailure(OTHER_ERROR);
        }

        try {
            accountMapper.setRole(userID,roleType);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(OTHER_ERROR);
        }
        return ResponseVO.buildSuccess();
    }

    @Override
    public List<UserVO> getAllUsers() throws Exception{
        List<User> users = accountMapper.getAllUsers();
        return usersToUserVOs(users);
    }

    @Override
    public List<UserVO> getUnauthorizedUsers() throws Exception {
        List<User> users = accountMapper.getUnauthorizedUsers();
        return usersToUserVOs(users);
    }


    /**
     * 将user列表转变为userVO列表
     * @param users
     * @return
     * @throws Exception
     */
    private List<UserVO> usersToUserVOs(List<User> users) throws Exception {
        ArrayList<UserVO> userVOS = new ArrayList<>();
        for(User user : users){
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user,userVO);
            userVOS.add(userVO);
        }
        return userVOS;
    }
}
