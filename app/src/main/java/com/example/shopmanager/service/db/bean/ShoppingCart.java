package com.example.shopmanager.service.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import com.example.shopmanager.service.db.dao.DaoSession;
import com.example.shopmanager.service.db.dao.BookInfoDao;
import com.example.shopmanager.service.db.dao.ShoppingCartDao;

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
    private Long bookId; // 新增的，外键
    //设置一对一关联，连接属性是cardId
    @ToOne(joinProperty ="bookId") // 注意该参数的值
    private BookInfo bookInfo;       // 新增的

    // 数量
    private int num;

    // 删除标记  可用于判断是否在回收站
    private boolean deleSign;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 657826810)
    private transient ShoppingCartDao myDao;

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
    @Generated(hash = 2137147630)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getShoppingCartDao() : null;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "_id=" + _id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", bookInfo=" + bookInfo +
                ", num=" + num +
                ", deleSign=" + deleSign +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                ", bookInfo__resolvedKey=" + bookInfo__resolvedKey +
                '}';
    }
}
