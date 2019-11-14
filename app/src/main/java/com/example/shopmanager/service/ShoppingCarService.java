package com.example.shopmanager.service;


import com.example.shopmanager.service.db.bean.ShoppingCart;
import com.example.shopmanager.service.db.dao.ShoppingCartDao;

import java.util.List;

/**
 *  购物车的数据请求层
 */
public class ShoppingCarService  extends BaseService{

    /**
     *  增加或是修改购物车一条数据
     */
    public void insertOrChange(ShoppingCart shoppingCart){
        ShoppingCartDao shoppingCartDao = daoSession.getShoppingCartDao();
        shoppingCartDao.insertOrReplace(shoppingCart);
    }

    /**
     * 移除该用户的所有购物车信息
     */
    public void removeAllByUserId(Long userId){
        ShoppingCartDao shoppingCartDao = daoSession.getShoppingCartDao();
        shoppingCartDao.queryBuilder().where(ShoppingCartDao.Properties.UserId.eq(userId)).buildDelete().executeDeleteWithoutDetachingEntities();
    }

    /**
     * 移除单个商品信息
     */
    public void removeOneById(Long id){
        ShoppingCartDao shoppingCartDao = daoSession.getShoppingCartDao();
        shoppingCartDao.deleteByKey(id);
    }

    /**
     * 查询单个商品购物车中的信息
     */
    public ShoppingCart queryShopCarOne(Long id){
        ShoppingCartDao shoppingCartDao = daoSession.getShoppingCartDao();
        ShoppingCart unique = shoppingCartDao.queryBuilder().where(ShoppingCartDao.Properties._id.eq(id)).unique();
        return unique;
    }


    /**
     *  查询用户的购物车
     */
    public List<ShoppingCart> queryUserCarList(Long userId){
        List<ShoppingCart> list = daoSession.getShoppingCartDao().queryBuilder().where(ShoppingCartDao.Properties.UserId.eq(userId)).list();
        return list;
    }

}
