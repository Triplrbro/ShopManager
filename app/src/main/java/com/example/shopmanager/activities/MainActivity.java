package com.example.shopmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.shopmanager.R;
import com.example.shopmanager.fragment.BottomFragment;
import com.example.shopmanager.fragment.FirstPageFragment;
import com.example.shopmanager.service.BaseService;
import com.example.shopmanager.service.BookInfoService;
import com.example.shopmanager.service.db.bean.BookInfo;
import com.example.shopmanager.utils.PermissionUtil;
import com.example.shopmanager.utils.SharedPreferencesUtil;

import java.util.List;

public class MainActivity extends Activity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionUtil.requestPower(this, ((Activity) this), "android.permission.WRITE_EXTERNAL_STORAGE");
        PermissionUtil.requestPower(this, ((Activity) this), "android.permission.INTERNET");
        //TODO:购物车，默认地址电话，userinfo修改

        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_content, new FirstPageFragment());
        transaction.replace(R.id.fl_bottom, new BottomFragment());
        transaction.commit();
    }



    private void initDB(){
        BaseService.DBInit(this);
        SharedPreferencesUtil.init(this);
    }

    private void testInsert(){
        BookInfo bookInfo = new BookInfo(null, "xxxx", "新华字典", "200", "400", "中国人民", "北京邮电", "精装", "4.5", "这是简介啊~~~~~~", "hrrp://location",0);
        BookInfoService bookInfoService = new BookInfoService();
        bookInfoService.setBookInfo(bookInfo);
    }

    private void query(){
        BookInfoService bookInfoService = new BookInfoService();
        List<BookInfo> bookInfos = bookInfoService.queryBookInfoList();
        for(BookInfo bookInfo : bookInfos){
            System.out.println("====================="+bookInfo.toString());
        }
    }

}
