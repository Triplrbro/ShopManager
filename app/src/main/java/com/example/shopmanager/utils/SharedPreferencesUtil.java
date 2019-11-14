package com.example.shopmanager.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;


public class SharedPreferencesUtil {

    private static Context context;

    public static void init(Context context) {
        SharedPreferencesUtil.context = context;
    }

    //声明SharedPreferences，用来读取xml;
    private static SharedPreferences sp;
    //声明SharedPreferences.Editor，用来修改xml里面的值。
    private static SharedPreferences.Editor ed;

    private static String USER_NAME = "USER_NAME";


    //TODO:无SharedPreferences文件返回0

    private static String getBase(String key) {
        sp = context.getSharedPreferences("setting", MODE_PRIVATE);
        return sp.getString(key,"0");
    }


    private static void setBase(String key, String inputValue) {
        SharedPreferences setting = context.getSharedPreferences("setting", MODE_PRIVATE);
        SharedPreferences.Editor edit = setting.edit();
        edit.putString(key, inputValue);
        edit.commit();
    }

    /**
     * 获取用户名字
     */
    public String getUserName(){
        String userName = getBase(USER_NAME);
        return userName;
    }

    /**
     *  设定名字
     *  条件 【登录成功】
     */
    public void setUserName(String userName){
        setBase(USER_NAME, String.valueOf(userName));
    }

}
