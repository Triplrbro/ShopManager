package com.example.shopmanager;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;


public class TestTwoService extends Service {

    //client 可以通过Binder获取Service实例
    public class MyBinder extends Binder {
        public TestTwoService getService() {
            return TestTwoService.this;
        }
    }

    //通过binder实现调用者client与Service之间的通信
    private MyBinder binder = new MyBinder();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("Kathy", "TestTwoService - onBind - Thread = " + Thread.currentThread().getName());
        return binder;
    }

}