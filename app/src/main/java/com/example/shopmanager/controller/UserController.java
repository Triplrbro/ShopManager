package com.example.shopmanager.controller;


import com.example.shopmanager.service.UserService;
import com.example.shopmanager.service.db.bean.UserInfo;
import com.example.shopmanager.utils.SharedPreferencesUtil;

/**
 * 用户控制层
 */
public class UserController {

    private final UserService userService;

    public UserController() {
        userService = new UserService();
    }

    /**
     * 判断用户登录
     * 成功返回 true
     * 失败返回 false
     */
    public boolean checkUserAccess(String userName, String passWord) {
        UserInfo userInfo = userService.queryUserInfoByName(userName);
        if (userInfo == null || !passWord.equals(userInfo.getPassWord())) {
            return false;
        } else {
            SharedPreferencesUtil sharedPreferencesUtil = new SharedPreferencesUtil();
            sharedPreferencesUtil.setUserName(userName);
            return true;
        }
    }

    /**
     * 自动登录校验
     * 成功返回 true
     * 失败返回 false
     */
    public boolean autoCheckUserAccess() {
        SharedPreferencesUtil sharedPreferencesUtil = new SharedPreferencesUtil();
        String userName = sharedPreferencesUtil.getUserName();
        return userName!=null||!userName.isEmpty();
//        if (userName == null || userName.isEmpty()) {
//            return false;
//        } else {
//            return true;
//        }
    }

    /**
     * 注册账户
     * 修改密码
     */
    public void setUserNameAndPassWord(String userName, String passWord) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassWord(passWord);
        userService.insertOrChangeUser(userInfo);
    }

    /**
     * 修改电话和地址
     */
    public void setUserPhoneAndAdress(String userName, String phone, String address) {
        UserInfo userInfo = userService.queryUserInfoByName(userName);
        userInfo.setAddress(address);
        userInfo.setPhone(phone);
        userService.insertOrChangeUser(userInfo);
    }

    /**
     * 设定用户头像
     */
    public void setUserPhoto(String userName, String userPhoto) {
        UserInfo userInfo = userService.queryUserInfoByName(userName);
        userInfo.setUserPhoto(userPhoto);
        userService.insertOrChangeUser(userInfo);
    }


}
