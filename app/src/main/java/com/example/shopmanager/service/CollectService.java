package com.example.shopmanager.service;

import com.example.shopmanager.service.db.bean.CollectInfo;
import com.example.shopmanager.service.db.dao.CollectInfoDao;

/**
 * 收藏详情的数据请求层
 */

public class CollectService extends BaseService{

    /**
     *  插入收藏信息
     */
    public void insertColler(CollectInfo collectInfo){
        CollectInfoDao collectInfoDao = daoSession.getCollectInfoDao();
        collectInfoDao.insertOrReplace(collectInfo);
    }

    /**
     *  是否收藏
     */
    public boolean isColler(Long userId , Long bookId){
        CollectInfoDao collectInfoDao = daoSession.getCollectInfoDao();
        long unique = collectInfoDao.queryBuilder().where(CollectInfoDao.Properties.BookId.eq(bookId)).where(CollectInfoDao.Properties.UserId.eq(userId)).count();
        // 奇偶判断点击次数
        return unique % 2 != 0;
    }

}
