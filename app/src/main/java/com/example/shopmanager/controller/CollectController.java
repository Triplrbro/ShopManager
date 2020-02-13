package com.example.shopmanager.controller;


import com.example.shopmanager.service.CollectService;
import com.example.shopmanager.service.db.bean.CollectInfo;
import com.example.shopmanager.service.db.dao.CollectInfoDao;

import java.util.List;

/**
 *  用于控制展示详情的页面
 */
public class CollectController {
    public final CollectService connectionService ;

    public CollectController() {
        connectionService = new CollectService() ;
    }


    /**
     *  更新收藏信息
     */
    public void insertColler(CollectInfo collectInfo){
        boolean coller = isColler(collectInfo.getUserId(), collectInfo.getBookId());
        if (coller){
            connectionService.deleColler(collectInfo);
        }else {
            connectionService.insertColler(collectInfo);
        }
    }

    /**
     *  是否收藏
     *  true 收藏
     *  false 没收藏
     */
    public boolean isColler(Long userId , Long bookId){
        long coller = connectionService.isColler(userId, bookId);
        // 奇偶判断点击次数
        return coller % 2 != 0;
    }


    /**
     *  查询收藏，已删除图书还在
     */
    public List<CollectInfo> queryCollectInfoListByUserId(Long userId){
        List<CollectInfo> collectInfos = connectionService.queryCollectInfoListByUserId(userId);
        return collectInfos;
    }


}
