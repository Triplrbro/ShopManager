package com.example.shopmanager.controller;

import com.example.shopmanager.service.OrderService;
import com.example.shopmanager.service.db.bean.OrderBookInfo;
import com.example.shopmanager.service.db.bean.OrderInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 *  订单控制层
 */
public class OrderController {

    private final OrderService orderService;

    public OrderController() {
        orderService = new OrderService();
    }

    /**
     *  生成订单信息
     */
    public void makeOrder(List<Long> bookIdList,Long userId,String phone,String address,String photo){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setPhone(phone);
        orderInfo.setAddress(address);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        orderInfo.setTime(format);
        orderInfo.setPhoto(photo);
        orderInfo.setUserId(userId);
        orderService.insertOrder(bookIdList,orderInfo);
    }

    /**
     *  根据用户id查询列表
     */
    public OrderInfo queryOrderInfoList(Long userId){
        OrderInfo orderInfo = orderService.queryOrderInfoList(userId);
        return orderInfo;
    }

    /**
     * 查询订单详情
     */
    public OrderBookInfo queryOrderBookInfoById(Long id){
        OrderBookInfo orderBookInfo = orderService.queryOrderBookInfoById(id);
        return orderBookInfo;
    }

    public OrderInfo queryOrderInfoById(Long id){
        OrderInfo orderInfo = orderService.queryOrderInfoById(id);
        return orderInfo ;
    }
}
