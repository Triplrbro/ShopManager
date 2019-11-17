package com.example.shopmanager.service.db.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.example.shopmanager.service.db.dao.DaoSession;
import com.example.shopmanager.service.db.dao.BookInfoDao;
import com.example.shopmanager.service.db.dao.OrderBookInfoDao;

/**
 *  订单中图书信息关联使用
 */

@Entity
public class OrderBookInfo {

    @Id
    private Long _id;

    private Long bookId;

    // 图书Id
    @ToOne(joinProperty ="bookId") // 注意该参数的值
    private BookInfo bookInfo;

    private Long orderInfo;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1895838288)
    private transient OrderBookInfoDao myDao;

    @Generated(hash = 451596213)
    public OrderBookInfo(Long _id, Long bookId, Long orderInfo) {
        this._id = _id;
        this.bookId = bookId;
        this.orderInfo = orderInfo;
    }

    @Generated(hash = 132623778)
    public OrderBookInfo() {
    }

    public Long get_id() {
        return this._id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public Long getBookId() {
        return this.bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getOrderInfo() {
        return this.orderInfo;
    }

    public void setOrderInfo(Long orderInfo) {
        this.orderInfo = orderInfo;
    }

    @Generated(hash = 1374280833)
    private transient Long bookInfo__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 321848428)
    public BookInfo getBookInfo() {
        Long __key = this.bookId;
        if (bookInfo__resolvedKey == null || !bookInfo__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BookInfoDao targetDao = daoSession.getBookInfoDao();
            BookInfo bookInfoNew = targetDao.load(__key);
            synchronized (this) {
                bookInfo = bookInfoNew;
                bookInfo__resolvedKey = __key;
            }
        }
        return bookInfo;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 797389900)
    public void setBookInfo(BookInfo bookInfo) {
        synchronized (this) {
            this.bookInfo = bookInfo;
            bookId = bookInfo == null ? null : bookInfo.get_id();
            bookInfo__resolvedKey = bookId;
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
    @Generated(hash = 1502302371)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOrderBookInfoDao() : null;
    }

}
