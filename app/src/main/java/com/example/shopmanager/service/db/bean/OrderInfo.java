package com.example.shopmanager.service.db.bean;


import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

import java.net.IDN;

/**
 *  订单信息
 *
 */
public class OrderInfo {

    @Id
    private Long _id;

    private String address;

    private String phone;

    private String photo;

    private String time;

    // 用户id
    private Long userId;

    //设置一对一关联，连接属性是userId
    @ToOne(joinProperty ="userId") // 注意该参数的值
    private UserInfo userInfo;


}
