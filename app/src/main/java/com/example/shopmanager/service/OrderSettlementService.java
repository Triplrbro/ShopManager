package com.example.shopmanager.service;

import com.example.shopmanager.service.db.bean.OrderSettlementInfo;
import com.example.shopmanager.service.db.bean.ShoppingCart;
import com.example.shopmanager.service.db.dao.OrderSettlementInfoDao;

import java.util.List;

/**
 *  订单数据请求层
 */
public class OrderSettlementService extends BaseService {

    ShoppingCarService shoppingCarService;

    public OrderSettlementService() {
        this.shoppingCarService = new ShoppingCarService();
    }

    /**
     *  生成订单信息
     */
    public void insertOrder( OrderSettlementInfo orderSettlementInfo,Long userId){
        // 插入订单信息
        OrderSettlementInfoDao orderSettlementInfoDao = daoSession.getOrderSettlementInfoDao();
        orderSettlementInfoDao.insert(orderSettlementInfo);

        // 获取刚刚生成的Id 更新购物车信息
        Long id = orderSettlementInfo.get_id();

        List<ShoppingCart> shoppingCarts = shoppingCarService.queryUserCarList(userId);
        for (int i = 0; i < shoppingCarts.size(); i++) {
            ShoppingCart shoppingCart = shoppingCarts.get(i);
            shoppingCart.setOrderSettlementInfoId(id);
        }
        // 批量更新
        shoppingCarService.insertOrChangeList(shoppingCarts);
    }

    /**
     *  根据用户id查询列表
     */
    public List<OrderSettlementInfo> queryOrderInfoList(Long userId){
        OrderSettlementInfoDao orderSettlementInfoDao = daoSession.getOrderSettlementInfoDao();
        List<OrderSettlementInfo> list = orderSettlementInfoDao.queryBuilder().where(OrderSettlementInfoDao.Properties.UserId.eq(userId)).list();
        return list;
    }


    /**
     * 查询订单详情
     */
    public OrderSettlementInfo queryOrderBookInfoById(Long id){
        OrderSettlementInfoDao orderSettlementInfoDao = daoSession.getOrderSettlementInfoDao();
        OrderSettlementInfo unique = orderSettlementInfoDao.queryBuilder().where(OrderSettlementInfoDao.Properties._id.eq(id)).unique();
        return unique;
    }


}
