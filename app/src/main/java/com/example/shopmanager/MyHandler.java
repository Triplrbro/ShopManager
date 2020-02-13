package com.example.shopmanager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MyHandler extends Handler {

    private final Context context;
    private final ImageView view;

    public MyHandler(ImageView  view) {
        context = view.getContext();
        this.view = view;
    }

    protected static final int REQUEST_SUCCESS = 1;
    protected static final int REQUEST_ERROR = 0;


    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case REQUEST_SUCCESS:
                Bitmap bitmap = (Bitmap) msg.obj;
                view.setImageBitmap(bitmap);
                break;
            case REQUEST_ERROR:
                Toast.makeText(context, "服务器繁忙...", 1).show();
                break;
            default:
                break;
        }
    }
}
