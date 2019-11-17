package com.example.shopmanager.service;


import com.example.shopmanager.service.db.bean.TrendsInfo;
import com.example.shopmanager.service.db.bean.TrendsInfo;
import com.example.shopmanager.service.db.bean.UserInfo;
import com.example.shopmanager.service.db.dao.TrendsInfoDao;

import java.util.List;

/**
 *  动态数据请求层
 */
public class TrendsService extends BaseService{

    /**
     *  插入或修改动态信息
     */
    public void insertOrChangeTrendsInfo(TrendsInfo trendsInfo){
        daoSession.getTrendsInfoDao().insertOrReplace(trendsInfo);
    }

    /**
     *  查询所有动态信息
     */
    public List<TrendsInfo> queryAllTrendsInfo(){
        List<TrendsInfo> list = daoSession.getTrendsInfoDao().loadAll();
        for(TrendsInfo trendsInfo : list){
            UserService userService = new UserService();
            UserInfo userInfo = userService.queryUserInfoById(trendsInfo.getUserId());
            trendsInfo.setUserInfo(userInfo);
        }
        return list;
    }

    /**
     *  根据用户Id查询动态信息
     */
    public List<TrendsInfo>  queryTrendsInfoById(Long userId){
        List<TrendsInfo> unique = daoSession.getTrendsInfoDao().queryBuilder().where(TrendsInfoDao.Properties.UserId.eq(userId)).list();
        return unique;
    }

}
