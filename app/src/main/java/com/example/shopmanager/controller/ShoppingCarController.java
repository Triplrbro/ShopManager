package com.example.shopmanager.controller;


import com.example.shopmanager.service.ShoppingCarService;
import com.example.shopmanager.service.db.bean.BookInfo;
import com.example.shopmanager.service.db.bean.ShoppingCart;

import java.util.List;

/**
 *  购物车控制器
 */
public class ShoppingCarController {

    private final ShoppingCarService shoppingCarService;

    public ShoppingCarController() {
        shoppingCarService = new ShoppingCarService();
    }

    /**
     *  增加商品数量
     */
    public int addShop(Long id){
        ShoppingCart shoppingCart = shoppingCarService.queryShopCarOne(id);
        if (shoppingCart == null){
            return 0;
        }else {
            shoppingCart.setNum(shoppingCart.getNum()+1);
        }
        shoppingCarService.insertOrChange(shoppingCart);
        int i = queryShopNum(id);
        return i;
    }

    /**
     *  减少商品数量
     */
    public int cutShop(Long id){
        ShoppingCart shoppingCart = shoppingCarService.queryShopCarOne(id);
        if (shoppingCart == null||shoppingCart.getNum() <=0||shoppingCart.getNum()==1){
            removeOneById(id);
            return 0;
        }else {
            shoppingCart.setNum(shoppingCart.getNum() - 1);
        }
        shoppingCarService.insertOrChange(shoppingCart);
        int i = queryShopNum(id);
        return i;
    }

    /**
     *  获取商品列表信息
     */
    public List<ShoppingCart> queryUserCarList(Long userId){
        List<ShoppingCart> shoppingCarList = shoppingCarService.queryUserCarList(userId);
        return shoppingCarList;
    }

    private int queryShopNum(Long id){
        ShoppingCart shoppingCart = shoppingCarService.queryShopCarOne(id);
        int num = shoppingCart.getNum();
        return num;
    }

    /**
     *  增加商品条目
     */
    public void setShoppingCarOnce(ShoppingCart shoppingCarOnce){
        ShoppingCart shoppingCart = shoppingCarService.queryShopCarOneByBookId(shoppingCarOnce.getBookId());
        if (shoppingCart != null){
            int i = shoppingCart.getNum() + 1;
            shoppingCart.setNum(i);
            shoppingCarOnce = shoppingCart;
        }
        shoppingCarService.insertOrChange(shoppingCarOnce);
    }

    /**
     *  增加商品条目
     */
    public void setShoppingCarOnce(Long bookId,Long userId){
        ShoppingCart shoppingCart = new ShoppingCart(null, userId, bookId, 1, false);
        setShoppingCarOnce(shoppingCart);
    }

    /**
     *  删除商品条目
     */
    public void removeOneById(Long id){
        shoppingCarService.removeOneById(id);
    }

    /**
     *  清空购物车
     */
    public void removeAllByUserId(Long userId){
        shoppingCarService.removeAllByUserId(userId);
    }

}
