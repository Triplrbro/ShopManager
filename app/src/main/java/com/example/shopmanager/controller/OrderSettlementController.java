package com.example.shopmanager.controller;


import com.example.shopmanager.service.OrderSettlementService;
import com.example.shopmanager.service.db.bean.OrderSettlementInfo;

import java.util.List;

/**
 *  订单控制器
 */
public class OrderSettlementController {

    OrderSettlementService orderSettlementService;

    public OrderSettlementController() {
        this.orderSettlementService = new OrderSettlementService();
    }

    /**
     *  创建订单
     */
    public void makeOrder(OrderSettlementInfo orderSettlementInfo,Long userId){
        orderSettlementService.insertOrder(orderSettlementInfo,userId);
    }

    /**
     *  查询订单列表
     * @return
     */
    public List<OrderSettlementInfo> queryOrderList(long userId){
        List<OrderSettlementInfo> orderSettlementInfos = orderSettlementService.queryOrderInfoList(userId);
        return orderSettlementInfos;
    }

    /**
     *  查询订单详情
     */
    public OrderSettlementInfo queryOrderInfo(Long userId){
        OrderSettlementInfo orderSettlementInfo = orderSettlementService.queryOrderBookInfoById(userId);
        return orderSettlementInfo;
    }

}
