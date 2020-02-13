package com.example.shopmanager.service.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 收藏的数据库对应
 */

@Entity
public class CollectInfo {

    @Id(autoincrement = true)
    private Long _id;
    // 用户id
    private Long userId;
    // 图书Id
    private Long bookId;
    @Generated(hash = 426582525)
    public CollectInfo(Long _id, Long userId, Long bookId) {
        this._id = _id;
        this.userId = userId;
        this.bookId = bookId;
    }
    @Generated(hash = 781720191)
    public CollectInfo() {
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


}
