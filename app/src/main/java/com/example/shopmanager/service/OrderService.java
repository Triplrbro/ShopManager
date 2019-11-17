package com.example.shopmanager.service;

import com.example.shopmanager.service.db.bean.OrderBookInfo;
import com.example.shopmanager.service.db.bean.OrderInfo;
import com.example.shopmanager.service.db.dao.OrderBookInfoDao;
import com.example.shopmanager.service.db.dao.OrderInfoDao;

import java.util.List;

/**
 *  订单数据请求层
 */
public class OrderService extends BaseService{

    /**
     *  生成订单信息
     */
    public void insertOrder(List<Long> bookIdList, OrderInfo orderInfo){
        OrderInfoDao orderInfoDao = daoSession.getOrderInfoDao();
        orderInfoDao.insertOrReplace(orderInfo);
        Long orderInfoId = orderInfo.get_id();

        Double money = 0D;
        // 插入详细图书信息
        OrderBookInfoDao orderBookInfoDao = daoSession.getOrderBookInfoDao();
        for (Long bookId: bookIdList){
            OrderBookInfo orderBookInfo = new OrderBookInfo(null, bookId, orderInfoId);
            orderBookInfoDao.insert(orderBookInfo);
            money+=Double.valueOf(orderBookInfo.getBookInfo().getPrice());
        }
        orderInfo.setMoney(money);
        orderInfoDao.insertOrReplace(orderInfo);
    }

    /**
     *  根据用户id查询列表
     */
    public OrderInfo queryOrderInfoList(Long userId){
        OrderInfoDao orderInfoDao = daoSession.getOrderInfoDao();
        OrderInfo orderInfo = orderInfoDao.queryBuilder().where(OrderInfoDao.Properties.UserId.eq(userId)).unique();
        return orderInfo;
    }



}
