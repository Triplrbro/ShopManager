package com.example.shopmanager.service.db.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.example.shopmanager.service.db.dao.DaoSession;
import com.example.shopmanager.service.db.dao.UserInfoDao;
import com.example.shopmanager.service.db.dao.TrendsInfoDao;

/**
 *  动态
 */
@Entity
public class TrendsInfo {

    @Id(autoincrement = true)
    private Long _id;

    // 用户id
    private Long userId;

    //设置一对一关联，连接属性是userId
    @ToOne(joinProperty ="userId") // 注意该参数的值
    private UserInfo userInfo;

    // 书籍ID
    private Long bookId;

    // 文本信息
    private String text;

    // 图片
    private String photoPath;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 829163769)
    private transient TrendsInfoDao myDao;

    @Generated(hash = 248346831)
    public TrendsInfo(Long _id, Long userId, Long bookId, String text,
            String photoPath) {
        this._id = _id;
        this.userId = userId;
        this.bookId = bookId;
        this.text = text;
        this.photoPath = photoPath;
    }

    @Generated(hash = 1629102398)
    public TrendsInfo() {
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

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhotoPath() {
        return this.photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
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
    @Generated(hash = 904645099)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTrendsInfoDao() : null;
    }

}
