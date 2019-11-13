package com.example.shopmanager.service;

import com.example.shopmanager.service.db.bean.UserInfo;
import com.example.shopmanager.service.db.dao.UserInfoDao;

import java.util.List;

/**
 * 用户的数据请求层
 */

public class UserService extends BaseService{

    /**
     *  插入或修改用户信息
     */
    public void insertOrChangeUser(UserInfo userInfo){
        daoSession.getUserInfoDao().insertOrReplace(userInfo);
    }

    /**
     *  查询所有用户信息
     */
    public List<UserInfo> queryAllUserInfo(){
        List<UserInfo> list = daoSession.getUserInfoDao().queryBuilder().list();
        return list;
    }

    /**
     *  根据用户Id查询用户信息
     */
    public UserInfo queryUserInfoById(Long userId){
        UserInfo unique = daoSession.getUserInfoDao().queryBuilder().where(UserInfoDao.Properties._id.eq(userId)).unique();
        return unique;
    }

    /**
     *  根据用户Id查询用户信息
     */
    public UserInfo queryUserInfoByName(String userName){
        UserInfo unique = daoSession.getUserInfoDao().queryBuilder().where(UserInfoDao.Properties.UserName.eq(userName)).unique();
        return unique;
    }


}
