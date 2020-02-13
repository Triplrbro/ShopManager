package com.example.shopmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

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

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.shopmanager.R;
import com.example.shopmanager.controller.BookInfoController;
import com.example.shopmanager.service.db.bean.BookInfo;
import com.example.shopmanager.utils.RealPathFromUriUtils;

import jp.wasabeef.glide.transformations.CropSquareTransformation;

public class ChangeBookActivity extends Activity implements View.OnClickListener {

    private BookInfoController bookInfoController;
    private BookInfo bookInfo;
    private EditText et_add_book_code;
    private EditText et_add_book_bookName;
    private EditText et_add_book_price;
    private EditText et_add_book_oldPrice;
    private EditText et_add_book_author;
    private EditText et_add_book_press;
    private EditText et_add_book_binding;
    private EditText et_add_book_score;
    private EditText et_add_book_contents;
    private Button bt_add_book_bookPhoto;
    private ImageView iv_add_book_bookPhoto;
    private Button bt_book_info_add_submit;
    private Button bt_back;
    private Uri uri;
    private String path = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chang_book);
        initView();
        initData();
        setOnClickListener();
    }

    private void initView() {
        et_add_book_code = (EditText) findViewById(R.id.et_add_book_code);
        et_add_book_bookName = (EditText) findViewById(R.id.et_add_book_bookName);
        et_add_book_price = (EditText) findViewById(R.id.et_add_book_price);
        et_add_book_oldPrice = (EditText) findViewById(R.id.et_add_book_oldPrice);
        et_add_book_author = (EditText) findViewById(R.id.et_add_book_author);
        et_add_book_press = (EditText) findViewById(R.id.et_add_book_press);
        et_add_book_binding = (EditText) findViewById(R.id.et_add_book_binding);
        et_add_book_score = (EditText) findViewById(R.id.et_add_book_score);
        et_add_book_contents = (EditText) findViewById(R.id.et_add_book_contents);
        bt_add_book_bookPhoto = (Button) findViewById(R.id.bt_add_book_bookPhoto);
        iv_add_book_bookPhoto = (ImageView) findViewById(R.id.iv_add_book_bookPhoto);
        bt_book_info_add_submit = (Button) findViewById(R.id.bt_book_info_add_submit);
        bt_back = (Button) findViewById(R.id.bt_back);

    }

    private void initData() {
        bookInfoController = new BookInfoController();
        Intent intent = getIntent();
        bookInfo = JSON.parseObject(intent.getStringExtra("bookInfo"), BookInfo.class);
        path = bt_add_book_bookPhoto.getText().toString();
        et_add_book_code.setText(bookInfo.getCode());
        et_add_book_bookName.setText(bookInfo.getBookNmae());
        et_add_book_price.setText(bookInfo.getPrice());
        et_add_book_oldPrice.setText(bookInfo.getOldPrice());
        et_add_book_author.setText(bookInfo.getAuthor());
        et_add_book_press.setText(bookInfo.getPress());
        et_add_book_binding.setText(bookInfo.getBinding());
        et_add_book_score.setText(bookInfo.getScore());
        et_add_book_contents.setText(bookInfo.getContents());
        if (bookInfo.getBookPhoto().equals("hrrp://location")) {
            Glide.with(this).load(R.drawable.photo_default).into(iv_add_book_bookPhoto);
        } else {
            Glide.with(this).load(bookInfo.getBookPhoto()).into(iv_add_book_bookPhoto);
        }
    }

    private void setOnClickListener() {
        bt_back.setOnClickListener(this);
        bt_add_book_bookPhoto.setOnClickListener(this);
        bt_book_info_add_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                finish();
                break;
            case R.id.bt_add_book_bookPhoto:
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, 2);
                System.out.println("=========获取图片");
                break;
            case R.id.bt_book_info_add_submit:
                String code = et_add_book_code.getText().toString();
                String bookName = et_add_book_bookName.getText().toString();
                String price = et_add_book_price.getText().toString();
                String oldPrice = et_add_book_oldPrice.getText().toString();
                String author = et_add_book_author.getText().toString();
                String press = et_add_book_press.getText().toString();
                String binding = et_add_book_binding.getText().toString();
                String score = et_add_book_score.getText().toString();
                String contents = et_add_book_contents.getText().toString();
                if (path.equals("") || path.equals("获取图片")) {
                    Toast.makeText(this, "请选择图片", Toast.LENGTH_SHORT).show();
                }
                bookInfo = new BookInfo(bookInfo.get_id(), code, bookName, price, oldPrice, author, press, binding, score, contents, RealPathFromUriUtils.getRealPathFromUri(this, uri));
                System.out.println("RealPathFromUriUtils" + RealPathFromUriUtils.getRealPathFromUri(this, uri));
                bookInfoController.setBookInfo(bookInfo);
                System.out.println("==================" + bookInfo.toString());
                Toast.makeText(this, "商品信息添加完成！", Toast.LENGTH_SHORT).show();
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
                Glide.with(this).load(uriString).bitmapTransform(new CropSquareTransformation(this)).into(iv_add_book_bookPhoto);

                bt_add_book_bookPhoto.setText(path);
            }
        }


    }
}
