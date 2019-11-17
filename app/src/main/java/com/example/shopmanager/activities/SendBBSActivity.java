package com.example.shopmanager.activities;

import android.app.Activity;
import android.content.Intent;
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
import com.example.shopmanager.R;
import com.example.shopmanager.controller.BookInfoController;
import com.example.shopmanager.controller.TrendsController;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.service.db.bean.TrendsInfo;
import com.example.shopmanager.utils.GlideCircleTransform;

import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;

public class SendBBSActivity extends Activity {

    private EditText et_send_bbs;
    private ImageView iv_send_bbs_img_selector;
    private Button bt_send_bbs;
    private Button bt_back;
    private String path;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_bbs);

        initView();


    }

    private boolean setData() {
        TrendsInfo trendsInfo = new TrendsInfo();
        TrendsController trendsController = new TrendsController();

        if (et_send_bbs.getText().toString().trim().isEmpty()||path.isEmpty()){
            return false;
        }else {
            trendsInfo.setText(et_send_bbs.getText().toString().trim());
            trendsInfo.setPhotoPath(path);
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
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, 2);
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                path = uri.getPath();
                System.out.println("========= 图片地址： " + path);
                Glide.with(this).load(uri).bitmapTransform(new CropSquareTransformation(this)).into(iv_send_bbs_img_selector);
            }
        }
    }
}
