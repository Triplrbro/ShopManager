package com.example.shopmanager.controller;

import com.example.shopmanager.service.TrendsService;
import com.example.shopmanager.service.db.bean.TrendsInfo;

import java.util.List;

/**
 * 动态控制层
 */
public class TrendsController {

    private final TrendsService trendsService;

    public TrendsController() {
        trendsService = new TrendsService();
    }

    /**
     *  插入或修改动态信息
     */
    public void insertOrChangeUser(TrendsInfo trendsInfo){
        trendsService.insertOrChangeTrendsInfo(trendsInfo);
    }

    /**
     *  查询所有动态信息
     */
    public List<TrendsInfo> queryAllTrendsInfo(){
        List<TrendsInfo> list = trendsService.queryAllTrendsInfo();
        return list;
    }

    /**
     *  根据用户Id查询动态信息
     */
    public List<TrendsInfo>  queryTrendsInfoById(Long userId){
        List<TrendsInfo>  unique = trendsService.queryTrendsInfoById(userId);
        return unique;
    }

}
