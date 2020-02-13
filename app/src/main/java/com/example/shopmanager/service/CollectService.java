package com.example.shopmanager.service;

import com.example.shopmanager.service.db.bean.CollectInfo;
import com.example.shopmanager.service.db.dao.CollectInfoDao;

import java.util.List;

/**
 * 收藏详情的数据请求层
 */

public class CollectService extends BaseService {

    /**
     * 插入收藏信息
     */
    public void insertColler(CollectInfo collectInfo) {
        CollectInfoDao collectInfoDao = daoSession.getCollectInfoDao();
        collectInfoDao.insertOrReplace(collectInfo);
        daoSession.clear();
    }

    /**
     * 插入收藏信息
     */
    public void deleColler(CollectInfo collectInfo) {
        CollectInfoDao collectInfoDao = daoSession.getCollectInfoDao();
        collectInfoDao.delete(collectInfo);
        daoSession.clear();
    }

    /**
     * 是否收藏
     */
    public long isColler(Long userId, Long bookId) {
        CollectInfoDao collectInfoDao = daoSession.getCollectInfoDao();
        long unique = collectInfoDao.queryBuilder().where(CollectInfoDao.Properties.BookId.eq(bookId)).where(CollectInfoDao.Properties.UserId.eq(userId)).count();
        daoSession.clear();
        return unique;
    }

    /**
     *  查询收藏，已删除图书还在
     */
    public List<CollectInfo> queryCollectInfoListByUserId(Long userId){
        CollectInfoDao collectInfoDao = daoSession.getCollectInfoDao();
        List<CollectInfo> unique = collectInfoDao.queryBuilder().where(CollectInfoDao.Properties.UserId.eq(userId)).list();
        daoSession.clear();
        return unique;
    }

}
