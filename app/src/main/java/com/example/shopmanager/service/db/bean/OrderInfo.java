package com.example.shopmanager.service.db.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.net.IDN;
import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.example.shopmanager.service.db.dao.DaoSession;
import com.example.shopmanager.service.db.dao.UserInfoDao;
import com.example.shopmanager.service.db.dao.OrderInfoDao;
import com.example.shopmanager.service.db.dao.OrderBookInfoDao;

/**
 *  订单信息
 *
 */
@Entity
public class OrderInfo {

    @Id
    private Long _id;

    private String address;

    private String phone;

    private String photo;

    private String time;

    // 用户id
    private Long userId;

    //设置一对一关联，连接属性是userId
    @ToOne(joinProperty ="userId") // 注意该参数的值
    private UserInfo userInfo;

    @ToMany(referencedJoinProperty = "orderInfo")
    private List<OrderBookInfo> orderBookInfoList;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 2087209612)
    private transient OrderInfoDao myDao;

    @Generated(hash = 1624904452)
    public OrderInfo(Long _id, String address, String phone, String photo,
            String time, Long userId) {
        this._id = _id;
        this.address = address;
        this.phone = phone;
        this.photo = photo;
        this.time = time;
        this.userId = userId;
    }

    @Generated(hash = 1695813404)
    public OrderInfo() {
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated(hash = 2066097151)
    private transient Long userInfo__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1827626095)
    public UserInfo getUserInfo() {
        Long __key = this.userId;
        if (userInfo__resolvedKey == null || !userInfo__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserInfoDao targetDao = daoSession.getUserInfoDao();
            UserInfo userInfoNew = targetDao.load(__key);
            synchronized (this) {
                userInfo = userInfoNew;
                userInfo__resolvedKey = __key;
            }
        }
        return userInfo;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1769423228)
    public void setUserInfo(UserInfo userInfo) {
        synchronized (this) {
            this.userInfo = userInfo;
            userId = userInfo == null ? null : userInfo.get_id();
            userInfo__resolvedKey = userId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1732476797)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOrderInfoDao() : null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 79364959)
    public List<OrderBookInfo> getOrderBookInfoList() {
        if (orderBookInfoList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OrderBookInfoDao targetDao = daoSession.getOrderBookInfoDao();
            List<OrderBookInfo> orderBookInfoListNew = targetDao
                    ._queryOrderInfo_OrderBookInfoList(_id);
            synchronized (this) {
                if (orderBookInfoList == null) {
                    orderBookInfoList = orderBookInfoListNew;
                }
            }
        }
        return orderBookInfoList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 632998510)
    public synchronized void resetOrderBookInfoList() {
        orderBookInfoList = null;
    }


}
