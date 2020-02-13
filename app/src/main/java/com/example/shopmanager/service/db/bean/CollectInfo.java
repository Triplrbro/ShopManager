package com.example.shopmanager.service.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.example.shopmanager.service.db.dao.DaoSession;
import com.example.shopmanager.service.db.dao.BookInfoDao;
import com.example.shopmanager.service.db.dao.CollectInfoDao;

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

    // 图书Id
    @ToOne(joinProperty ="bookId") // 注意该参数的值
    private BookInfo bookInfo;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 395631006)
    private transient CollectInfoDao myDao;
    @Generated(hash = 1374280833)
    private transient Long bookInfo__resolvedKey;

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
    @Generated(hash = 791906233)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCollectInfoDao() : null;
    }


}
