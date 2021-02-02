package com.example.finclaw.blImpl.account;

import com.example.finclaw.bl.account.AccountService;
import com.example.finclaw.data.account.AccountMapper;
import com.example.finclaw.data.cooperation.CooperationMapper;
import com.example.finclaw.enums.UserType;
import com.example.finclaw.po.Cooperation;
import com.example.finclaw.po.User;
import com.example.finclaw.vo.account.UserForm;
import com.example.finclaw.vo.ResponseVO;
import com.example.finclaw.vo.account.UserLoginForm;
import com.example.finclaw.vo.account.UserVO;
import com.example.finclaw.vo.cooperation.CooperationForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hwb
 */

@Service
public class AccountServiceImpl implements AccountService {
    private final static String ACCOUNT_EXIST = "账号已存在";
    private final static String UPDATE_ERROR = "修改失败";
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private CooperationMapper cooperationMapper;

    @Override
    public Boolean registerDataManager(UserForm userForm) {
        User user = new User();
        BeanUtils.copyProperties(userForm,user);
        user.setCooperation("监管方");
        user.setRole(UserType.DataManager);
        try {
            accountMapper.createNewAccount(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Boolean registerCooperation(CooperationForm cooperationForm) {
        //在cooperation表中添加一个账户
        Cooperation cooperation = new Cooperation();
        cooperation.setCooperationName(cooperationForm.getCooperationName());
        cooperation.setPhoneNumber(cooperationForm.getPhoneNumber());
        try {
            cooperationMapper.addCooperation(cooperation);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        Integer cooperationID = cooperationMapper.getCooperationIDByName(cooperationForm.getCooperationName());
        //在user表中添加一个账户
        User user = new User();
        user.setEmail(cooperationForm.getEmail());
        user.setPassword(cooperationForm.getPassword());
        user.setPhoneNumber(cooperationForm.getPhoneNumber());
        user.setUsername(cooperationForm.getCooperationName());
        user.setCooperation(cooperationForm.getCooperationName());
        user.setRole(UserType.Cooperation);
        user.setCooperationID(cooperationID);
        try {
            accountMapper.createNewAccount(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public User login(UserLoginForm userLoginForm) {
        User user = accountMapper.getAccountByEmail(userLoginForm.getEmail());
        if (null == user || !user.getPassword().equals(userLoginForm.getPassword())) {
            return null;
        }
        return user;
    }

    @Override
    public UserVO getUserInfo(int userID) {
        User user = accountMapper.getAccountById(userID);
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }


    @Override
    public ResponseVO deleteUser(int userID) {
        accountMapper.deleteUser(userID);
        return ResponseVO.buildSuccess(true);
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
    public List<UserVO> getAllDataManagers() {
        List<User> users = accountMapper.getAllDataManagers();
        ArrayList<UserVO> userVOS = new ArrayList<>();
        for (User user : users) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            userVOS.add(userVO);
        }
        return userVOS;
    }


}
