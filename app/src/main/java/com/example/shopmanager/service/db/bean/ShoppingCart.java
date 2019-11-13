package com.example.shopmanager.service.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 *  购物车
 */
@Entity
public class ShoppingCart {

    @Id(autoincrement = true)
    private Long _id;

    // 用户id
    private Long userId;

    // 书籍ID
    private Long bookId;

    // 数量
    private int num;

    // 删除标记  可用于判断是否在回收站
    private boolean deleSign;

    @Generated(hash = 1509434161)
    public ShoppingCart(Long _id, Long userId, Long bookId, int num,
            boolean deleSign) {
        this._id = _id;
        this.userId = userId;
        this.bookId = bookId;
        this.num = num;
        this.deleSign = deleSign;
    }

    @Generated(hash = 629579973)
    public ShoppingCart() {
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return this.bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean getDeleSign() {
        return this.deleSign;
    }

    public void setDeleSign(boolean deleSign) {
        this.deleSign = deleSign;
    }
}
