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

    // 总价
    private Double money;

    @Generated(hash = 1610368688)
    public OrderInfo(Long _id, String address, String phone, String photo,
            String time, Long userId, Double money) {
        this._id = _id;
        this.address = address;
        this.phone = phone;
        this.photo = photo;
        this.time = time;
        this.userId = userId;
        this.money = money;
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

    public Double getMoney() {
        return this.money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

  
}
