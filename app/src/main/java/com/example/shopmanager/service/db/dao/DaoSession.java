package com.example.shopmanager.service.db.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.shopmanager.service.db.bean.BookInfo;
import com.example.shopmanager.service.db.bean.OrderBookInfo;
import com.example.shopmanager.service.db.bean.OrderInfo;
import com.example.shopmanager.service.db.bean.OrderSettlementInfo;
import com.example.shopmanager.service.db.bean.ShoppingCart;
import com.example.shopmanager.service.db.bean.TrendsInfo;
import com.example.shopmanager.service.db.bean.UserInfo;
import com.example.shopmanager.service.db.bean.CollectInfo;

import com.example.shopmanager.service.db.dao.BookInfoDao;
import com.example.shopmanager.service.db.dao.OrderBookInfoDao;
import com.example.shopmanager.service.db.dao.OrderInfoDao;
import com.example.shopmanager.service.db.dao.OrderSettlementInfoDao;
import com.example.shopmanager.service.db.dao.ShoppingCartDao;
import com.example.shopmanager.service.db.dao.TrendsInfoDao;
import com.example.shopmanager.service.db.dao.UserInfoDao;
import com.example.shopmanager.service.db.dao.CollectInfoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bookInfoDaoConfig;
    private final DaoConfig orderBookInfoDaoConfig;
    private final DaoConfig orderInfoDaoConfig;
    private final DaoConfig orderSettlementInfoDaoConfig;
    private final DaoConfig shoppingCartDaoConfig;
    private final DaoConfig trendsInfoDaoConfig;
    private final DaoConfig userInfoDaoConfig;
    private final DaoConfig collectInfoDaoConfig;

    private final BookInfoDao bookInfoDao;
    private final OrderBookInfoDao orderBookInfoDao;
    private final OrderInfoDao orderInfoDao;
    private final OrderSettlementInfoDao orderSettlementInfoDao;
    private final ShoppingCartDao shoppingCartDao;
    private final TrendsInfoDao trendsInfoDao;
    private final UserInfoDao userInfoDao;
    private final CollectInfoDao collectInfoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bookInfoDaoConfig = daoConfigMap.get(BookInfoDao.class).clone();
        bookInfoDaoConfig.initIdentityScope(type);

        orderBookInfoDaoConfig = daoConfigMap.get(OrderBookInfoDao.class).clone();
        orderBookInfoDaoConfig.initIdentityScope(type);

        orderInfoDaoConfig = daoConfigMap.get(OrderInfoDao.class).clone();
        orderInfoDaoConfig.initIdentityScope(type);

        orderSettlementInfoDaoConfig = daoConfigMap.get(OrderSettlementInfoDao.class).clone();
        orderSettlementInfoDaoConfig.initIdentityScope(type);

        shoppingCartDaoConfig = daoConfigMap.get(ShoppingCartDao.class).clone();
        shoppingCartDaoConfig.initIdentityScope(type);

        trendsInfoDaoConfig = daoConfigMap.get(TrendsInfoDao.class).clone();
        trendsInfoDaoConfig.initIdentityScope(type);

        userInfoDaoConfig = daoConfigMap.get(UserInfoDao.class).clone();
        userInfoDaoConfig.initIdentityScope(type);

        collectInfoDaoConfig = daoConfigMap.get(CollectInfoDao.class).clone();
        collectInfoDaoConfig.initIdentityScope(type);

        bookInfoDao = new BookInfoDao(bookInfoDaoConfig, this);
        orderBookInfoDao = new OrderBookInfoDao(orderBookInfoDaoConfig, this);
        orderInfoDao = new OrderInfoDao(orderInfoDaoConfig, this);
        orderSettlementInfoDao = new OrderSettlementInfoDao(orderSettlementInfoDaoConfig, this);
        shoppingCartDao = new ShoppingCartDao(shoppingCartDaoConfig, this);
        trendsInfoDao = new TrendsInfoDao(trendsInfoDaoConfig, this);
        userInfoDao = new UserInfoDao(userInfoDaoConfig, this);
        collectInfoDao = new CollectInfoDao(collectInfoDaoConfig, this);

        registerDao(BookInfo.class, bookInfoDao);
        registerDao(OrderBookInfo.class, orderBookInfoDao);
        registerDao(OrderInfo.class, orderInfoDao);
        registerDao(OrderSettlementInfo.class, orderSettlementInfoDao);
        registerDao(ShoppingCart.class, shoppingCartDao);
        registerDao(TrendsInfo.class, trendsInfoDao);
        registerDao(UserInfo.class, userInfoDao);
        registerDao(CollectInfo.class, collectInfoDao);
    }
    
    public void clear() {
        bookInfoDaoConfig.clearIdentityScope();
        orderBookInfoDaoConfig.clearIdentityScope();
        orderInfoDaoConfig.clearIdentityScope();
        orderSettlementInfoDaoConfig.clearIdentityScope();
        shoppingCartDaoConfig.clearIdentityScope();
        trendsInfoDaoConfig.clearIdentityScope();
        userInfoDaoConfig.clearIdentityScope();
        collectInfoDaoConfig.clearIdentityScope();
    }

    public BookInfoDao getBookInfoDao() {
        return bookInfoDao;
    }

    public OrderBookInfoDao getOrderBookInfoDao() {
        return orderBookInfoDao;
    }

    public OrderInfoDao getOrderInfoDao() {
        return orderInfoDao;
    }

    public OrderSettlementInfoDao getOrderSettlementInfoDao() {
        return orderSettlementInfoDao;
    }

    public ShoppingCartDao getShoppingCartDao() {
        return shoppingCartDao;
    }

    public TrendsInfoDao getTrendsInfoDao() {
        return trendsInfoDao;
    }

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    public CollectInfoDao getCollectInfoDao() {
        return collectInfoDao;
    }

}
