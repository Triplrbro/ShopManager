package com.example.shopmanager.service.db.bean;

import com.example.shopmanager.service.db.dao.DaoSession;
import com.example.shopmanager.service.db.dao.OrderSettlementInfoDao;
import com.example.shopmanager.service.db.dao.ShoppingCartDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * 订单结算
 */

@Entity
public class OrderSettlementInfo {

    @Id(autoincrement = true)
    private Long _id;

    // 收货地址
    private String address;

    // 收货人电话
    private String phone;

    // 收货人名称
    private String name;

    // 总价格
    private String allPrice;

    // 优惠后价格
    private String realityPrice;

    // 用户ID
    private long userId;

    @ToMany(referencedJoinProperty = "orderSettlementInfoId")//指定与之关联的其他类的id
    private List<ShoppingCart> shoppingCartList;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1228720983)
    private transient OrderSettlementInfoDao myDao;

    @Generated(hash = 1362435195)
    public OrderSettlementInfo(Long _id, String address, String phone, String name,
            String allPrice, String realityPrice, long userId) {
        this._id = _id;
        this.address = address;
        this.phone = phone;
        this.name = name;
        this.allPrice = allPrice;
        this.realityPrice = realityPrice;
        this.userId = userId;
    }

    @Generated(hash = 1181163486)
    public OrderSettlementInfo() {
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllPrice() {
        return this.allPrice;
    }

    public void setAllPrice(String allPrice) {
        this.allPrice = allPrice;
    }

    public String getRealityPrice() {
        return this.realityPrice;
    }

    public void setRealityPrice(String realityPrice) {
        this.realityPrice = realityPrice;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1964052267)
    public List<ShoppingCart> getShoppingCartList() {
        if (shoppingCartList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ShoppingCartDao targetDao = daoSession.getShoppingCartDao();
            List<ShoppingCart> shoppingCartListNew = targetDao
                    ._queryOrderSettlementInfo_ShoppingCartList(_id);
            synchronized (this) {
                if (shoppingCartList == null) {
                    shoppingCartList = shoppingCartListNew;
                }
            }
        }
        return shoppingCartList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1007164370)
    public synchronized void resetShoppingCartList() {
        shoppingCartList = null;
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
    @Generated(hash = 866592958)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOrderSettlementInfoDao() : null;
    }

    @Override
    public String toString() {
        return "OrderSettlementInfo{" +
                "_id=" + _id +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", allPrice='" + allPrice + '\'' +
                ", realityPrice='" + realityPrice + '\'' +
                ", userId=" + userId +
                ", shoppingCartList=" + shoppingCartList +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                '}';
    }
}
