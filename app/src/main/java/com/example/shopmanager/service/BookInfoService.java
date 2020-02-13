package com.example.shopmanager.service;


import com.example.shopmanager.service.db.bean.BookInfo;
import com.example.shopmanager.service.db.dao.BookInfoDao;

import java.util.List;

/**
 * 书详情的数据请求层
 */
public class BookInfoService extends BaseService {

    /**
     *  获取全部图书信息
     */
    public List<BookInfo> queryBookInfoList() {
        BookInfoDao bookInfoDao = daoSession.getBookInfoDao();
        List<BookInfo> list = bookInfoDao.queryBuilder().where(BookInfoDao.Properties.DeleSign.eq("0")).list();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("======================="+list.get(i));
        }
        daoSession.clear();
        return list;
    }

    /**
     *  根据图书编号获得图书信息
     */
    public BookInfo getBookInfByCode(String code) {
        BookInfoDao bookInfoDao = daoSession.getBookInfoDao();
        BookInfo bookInfo = bookInfoDao.queryBuilder().where(BookInfoDao.Properties.DeleSign.eq("0")).where(BookInfoDao.Properties.Code.eq(code)).unique();
        daoSession.clear();
        return bookInfo;
    }

    /**
     *  根据图书名字获得图书信息
     */
    public BookInfo getBookInfoByName(String name){
        BookInfoDao bookInfoDao = daoSession.getBookInfoDao();
        BookInfo bookInfo = bookInfoDao.queryBuilder().where(BookInfoDao.Properties.DeleSign.eq("0")).where(BookInfoDao.Properties.BookNmae.like("%"+name+"%")).unique();
        daoSession.clear();
        return bookInfo;
    }

    /**
     *  设定图书信息
     */
    public void setBookInfo(BookInfo bookInfo){
        System.out.println("============================="+bookInfo.toString());
        BookInfoDao bookInfoDao = daoSession.getBookInfoDao();
        bookInfoDao.insertOrReplace(bookInfo);
        daoSession.clear();
    }

    /**
     *  根据数量获取图书信息
     */
    public List<BookInfo> getNumBookInfo(int num){
        BookInfoDao bookInfoDao = daoSession.getBookInfoDao();
        List<BookInfo> list = bookInfoDao.queryBuilder().where(BookInfoDao.Properties.DeleSign.eq("0")).limit(num).list();
        daoSession.clear();
        return list;
    }

    /**
     *  根据 id 获取图书信息
     */
    public BookInfo getBookInfoById(Long id) {
        BookInfoDao bookInfoDao = daoSession.getBookInfoDao();
        BookInfo bookInfo = bookInfoDao.queryBuilder().where(BookInfoDao.Properties.DeleSign.eq("0")).where(BookInfoDao.Properties._id.eq(id)).unique();
        daoSession.clear();
        return bookInfo;
    }
}
