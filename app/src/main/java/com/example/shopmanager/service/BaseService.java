package com.example.shopmanager.service;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.shopmanager.service.db.dao.DaoMaster;
import com.example.shopmanager.service.db.dao.DaoMaster.DevOpenHelper;
import com.example.shopmanager.service.db.dao.DaoSession;

/**
 *  数据请求层 抽象类
 */
public class BaseService {

    private static Context context;
    private DevOpenHelper mHelper;
    private final DaoMaster daoMaster;
    public final DaoSession daoSession;

    public static void DBInit(Context context){
        BaseService.context = context;
    }

    public BaseService() {
        mHelper = new DevOpenHelper(context, "person.db", null);
        daoMaster = new DaoMaster(getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase(){
        if(mHelper == null){
            mHelper = new DaoMaster.DevOpenHelper(context,"person.db",null);
        }
        SQLiteDatabase db =mHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     * @return
     */
    private SQLiteDatabase getWritableDatabase(){
        if(mHelper == null){
            mHelper =new DaoMaster.DevOpenHelper(context,"person.db",null);
        }
        SQLiteDatabase db = mHelper.getWritableDatabase();
        return db;
    }
}
