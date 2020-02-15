package com.example.shopmanager.service;


import android.database.Cursor;

import com.example.shopmanager.controller.BookInfoController;
import com.example.shopmanager.service.db.bean.BookInfo;
import com.example.shopmanager.service.db.bean.ShoppingCart;
import com.example.shopmanager.service.db.dao.BookInfoDao;
import com.example.shopmanager.service.db.dao.ShoppingCartDao;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车的数据请求层
 */
public class ShoppingCarService extends BaseService {

    /**
     * 增加或是修改购物车一条数据
     */
    public void insertOrChange(ShoppingCart shoppingCart) {
        ShoppingCartDao shoppingCartDao = daoSession.getShoppingCartDao();
        shoppingCartDao.insertOrReplace(shoppingCart);
        daoSession.clear();
    }

    /**
     * 增加或是修改购物车多条
     */
    public void insertOrChangeList(List<ShoppingCart> shoppingCartList) {
        ShoppingCartDao shoppingCartDao = daoSession.getShoppingCartDao();
        shoppingCartDao.insertOrReplaceInTx(shoppingCartList);
        daoSession.clear();
    }

    /**
     * 移除该用户的所有购物车信息
     */
    public void removeAllByUserId(Long userId) {
        ShoppingCartDao shoppingCartDao = daoSession.getShoppingCartDao();
        shoppingCartDao.queryBuilder().where(ShoppingCartDao.Properties.UserId.eq(userId)).buildDelete().executeDeleteWithoutDetachingEntities();
        daoSession.clear();
    }

    /**
     * 移除单个商品信息
     */
    public void removeOneById(Long id) {
        ShoppingCartDao shoppingCartDao = daoSession.getShoppingCartDao();
        shoppingCartDao.deleteByKey(id);
        daoSession.clear();
    }

    /**
     * 查询单个商品购物车中的信息
     */
    public ShoppingCart queryShopCarOne(Long id) {
        ShoppingCartDao shoppingCartDao = daoSession.getShoppingCartDao();
        ShoppingCart unique = shoppingCartDao.queryBuilder().where(ShoppingCartDao.Properties._id.eq(id)).unique();
        daoSession.clear();
        return unique;
    }

    /**
     * 查询通过图书id
     */
    public ShoppingCart queryShopCarOneByBookId(Long id) {
        ShoppingCartDao shoppingCartDao = daoSession.getShoppingCartDao();
        List<ShoppingCart> unique = shoppingCartDao.queryBuilder().where(ShoppingCartDao.Properties.BookId.eq(id)).list();
        if (unique.size() > 0) {
            return unique.get(0);
        }
        daoSession.clear();
        return null;
    }

    /**
     * 查询用户的购物车
     */
    public List<ShoppingCart> queryUserCarList(Long userId) {
//        List<ShoppingCart> list = daoSession.getShoppingCartDao().queryBuilder()
//                .where(ShoppingCartDao.Properties.UserId.eq(userId))
//                .where(ShoppingCart.eq("0"))
//                .where(ShoppingCartDao.Properties.OrderSettlementInfoId.eq("0")).list();

        String where = "select DISTINCT  " + ShoppingCartDao.TABLENAME + ".* from " + ShoppingCartDao.TABLENAME + "," + BookInfoDao.TABLENAME +
                " where " + ShoppingCartDao.TABLENAME + "." + ShoppingCartDao.Properties.BookId.columnName + " = " + BookInfoDao.TABLENAME + "." + BookInfoDao.Properties._id.columnName
                + " and " + BookInfoDao.Properties.DeleSign.columnName + " = '0'"
                + " and " + ShoppingCartDao.Properties.UserId.columnName + " = " + userId +
                " and " + ShoppingCartDao.Properties.OrderSettlementInfoId.columnName + "= '0'";
        System.out.println("==================" + where);
        Cursor c = daoSession.getDatabase().rawQuery(where, null);
        List<ShoppingCart> shoppingCarts1 = new ArrayList<>();
        int id = c.getColumnIndex(ShoppingCartDao.Properties._id.columnName);
        int userIdNum = c.getColumnIndex(ShoppingCartDao.Properties.UserId.columnName);
        int bookId = c.getColumnIndex(ShoppingCartDao.Properties.BookId.columnName);
        int num = c.getColumnIndex(ShoppingCartDao.Properties.Num.columnName);
        int orderSettlementInfoId = c.getColumnIndex(ShoppingCartDao.Properties.OrderSettlementInfoId.columnName);

        while (c.moveToNext()) {
            ShoppingCart shoppingCart = new ShoppingCart();
            long shopInfoId = c.getLong(id);
            long shopInfoUserIdNum = c.getLong(userIdNum);
            long shopInfoBookId = c.getLong(bookId);
            int shopInfoNum = c.getInt(num);
            long shopinfoOrderSettlementInfoId = c.getLong(orderSettlementInfoId);

            shoppingCart.set_id(shopInfoId);
            shoppingCart.setUserId(shopInfoUserIdNum);
            shoppingCart.setBookId(shopInfoBookId);
            shoppingCart.setNum(shopInfoNum);
            shoppingCart.setOrderSettlementInfoId(shopinfoOrderSettlementInfoId);
            BookInfoController bookInfoController = new BookInfoController();

            BookInfo bookInfoById = bookInfoController.getBookInfoById(shopInfoBookId);
            shoppingCart.setBookInfo(bookInfoById);

            System.out.println("=====================================");
            shoppingCarts1.add(shoppingCart);
        }
        c.close();

//        List<ShoppingCart> shoppingCarts = shoppingCartDao.queryRaw(where, null);
//        for (ShoppingCart shoppingCart : shoppingCarts){
//            BookInfoService bookInfoService = new BookInfoService();
//            BookInfo bookInfoById = bookInfoService.getBookInfoById(shoppingCart.getBookId());
//            shoppingCart.setBookInfo(bookInfoById);
//        }
        daoSession.clear();
        return shoppingCarts1;
    }
}
