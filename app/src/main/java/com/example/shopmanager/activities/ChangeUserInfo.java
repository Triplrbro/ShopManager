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
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.service.UserService;
import com.example.shopmanager.service.db.bean.UserInfo;
import com.example.shopmanager.utils.GlideCircleTransform;
import com.example.shopmanager.utils.RealPathFromUriUtils;

public class ChangeUserInfo extends Activity implements View.OnClickListener {

    private Button bt_change_user_info;
    private Button bt_back;
    private EditText et_edit_description;
    private EditText et_edit_name;
    private ImageView iv_userHead;
    private Uri uri;
    private UserInfo userInfo;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_change_userinfo);
        super.onCreate(savedInstanceState);

        initView();
        initData();
    }

    private void initData() {
        userInfo = new UserService().queryUserInfoById(UserController.getUserId());
        Glide.with(this).load(userInfo.getUserPhoto()).placeholder(R.drawable.ic_userhead).bitmapTransform(new GlideCircleTransform(this)).into(iv_userHead);
    }

    private void initView() {
        bt_change_user_info = findViewById(R.id.bt_change_user_info);
        bt_back = findViewById(R.id.bt_back);
        iv_userHead = findViewById(R.id.iv_userHead);
        et_edit_description = findViewById(R.id.et_edit_description);
        et_edit_name = findViewById(R.id.et_edit_name);
        iv_userHead.setOnClickListener(this);
        bt_change_user_info.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_change_user_info:
                    if (userInfo.getUserPhoto().isEmpty()&&uri==null){
                    Toast.makeText(this, "照片未填寫", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    userInfo.setUserName(et_edit_name.getText().toString().trim());
                    userInfo.setDescri(et_edit_description.getText().toString().trim());
                                if( uri != null) {
                                    userInfo.setUserPhoto(RealPathFromUriUtils.getRealPathFromUri(this, uri));
                                }
                    new UserService().insertOrChangeUser(userInfo);
                    finish();
                }
                break;
            case R.id.iv_userHead:
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, 2);
                System.out.println("=========获取图片");
                break;
            case R.id.bt_back:
                finish();
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 2) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                uri = data.getData();
                String uriString = String.valueOf(uri);
                Glide.with(this).load(uriString).bitmapTransform(new GlideCircleTransform(this)).into(iv_userHead);

            }
        }
    }
}
