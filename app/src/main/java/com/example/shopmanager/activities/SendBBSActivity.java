package com.example.shopmanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.shopmanager.Properties.Properties;
import com.example.shopmanager.R;
import com.example.shopmanager.controller.TrendsController;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.service.db.bean.TrendsInfo;
import com.example.shopmanager.utils.ChooseImageDialogUtil;
import com.example.shopmanager.utils.RealPathFromUriUtils;

import jp.wasabeef.glide.transformations.CropSquareTransformation;

public class SendBBSActivity extends Activity {

    private EditText et_send_bbs;
    private ImageView iv_send_bbs_img_selector;
    private Button bt_send_bbs;
    private Button bt_back;
    private String path;
    private Uri uri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_bbs);

        initView();


    }

    private boolean setData() {
        TrendsInfo trendsInfo = new TrendsInfo();
        TrendsController trendsController = new TrendsController();

        if (et_send_bbs.getText().toString().trim().isEmpty()){
            return false;
        }else {
            SharedPreferences sendContext = getSharedPreferences("sendContext", MODE_PRIVATE);
            String send_img = sendContext.getString("SEND_IMG", "");
            trendsInfo.setText(et_send_bbs.getText().toString().trim());
            trendsInfo.setPhotoPath(send_img);
            trendsInfo.setUserId(UserController.getUserId());
            trendsInfo.setUserInfo(UserController.getUserInfo());
            trendsController.insertOrChangeUser(trendsInfo);
            return true;
        }


    }

    private void initView() {
        et_send_bbs = findViewById(R.id.et_send_bbs);
        iv_send_bbs_img_selector = findViewById(R.id.iv_send_bbs_img_selector);
        bt_send_bbs = findViewById(R.id.bt_send_bbs);
        bt_send_bbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setData()) {
                    Toast.makeText(SendBBSActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        bt_back = findViewById(R.id.bt_back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        iv_send_bbs_img_selector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseImageDialogUtil.onlySelectImage(SendBBSActivity.this);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Properties.FROM_GALLERY:
                SharedPreferences sharedPreferences = this.getSharedPreferences("sendContext", MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                uri = data.getData();
                Glide.with(this).load(data.getData()).bitmapTransform(new CropSquareTransformation(this)).into(iv_send_bbs_img_selector);
                edit.putString("SEND_IMG", String.valueOf(data.getData()));
                edit.apply();
        }
    }
}
