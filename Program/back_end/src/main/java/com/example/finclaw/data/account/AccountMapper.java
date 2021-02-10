package com.example.finclaw.data.account;

import com.example.finclaw.enums.UserType;
import com.example.finclaw.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cgc
 */
@Mapper
@Repository
public interface AccountMapper {

    /**
     * 创建一个新的账号
     *
     * @return
     */
     int createNewAccount(User user);

    /**
     * 根据用户名查找账号
     * @param email
     * @return
     */
     User getAccountByEmail(@Param("email") String email);

     User getAccountById(@Param("userID") int userID);

     int deleteUser(@Param("userID") int userID);

     int updatePassword(@Param("userID") int userID,@Param("newPassword") String newPassword);

     int updateUserInfo(User user);

     int setRole(@Param("userID") int userID, @Param("role") UserType role);

     List<User> getAllUsers();
}
