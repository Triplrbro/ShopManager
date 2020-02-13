package com.example.shopmanager.controller;


import com.example.shopmanager.service.OrderSettlementService;
import com.example.shopmanager.service.db.bean.OrderSettlementInfo;

import java.util.List;

/**
 *  订单控制器
 */
public class OrderSettlementController {

    OrderSettlementService orderSettlementService;

    // 创建
    public static final String MAKE_ODER = "0";
    // 发货
    public static final String SEND_ODER = "1";
    // 收货
    public static final String FINISH_ODER = "2";


    public OrderSettlementController() {
        this.orderSettlementService = new OrderSettlementService();
    }

    /**
     *  创建订单
     */
    public void makeOrder(OrderSettlementInfo orderSettlementInfo,Long userId){
        orderSettlementInfo.setState("0");
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

    /**
     *  更新订单信息
     */
    public void updateOrder(OrderSettlementInfo orderSettlementInfo,String stateCode){
        orderSettlementInfo.setState(String.valueOf(stateCode));
        orderSettlementService.updateOrder(orderSettlementInfo);
    }


    /**
     *  根据状态查询列表
     */
    public List<OrderSettlementInfo> queryOrderInfoList(String  stateCode){
        List<OrderSettlementInfo> orderSettlementInfos = orderSettlementService.queryOrderInfoList(stateCode);
        return orderSettlementInfos;
    }

}
