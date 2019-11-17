package com.example.shopmanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.shopmanager.R;
import com.example.shopmanager.TestTwoService;
import com.example.shopmanager.controller.BookInfoController;
import com.example.shopmanager.service.db.bean.BookInfo;

public class AddShopActivity extends Activity implements View.OnClickListener {

    private EditText et_add_book_code;
    private EditText et_add_book_bookName;
    private EditText et_add_book_price;
    private EditText et_add_book_oldPrice;
    private EditText et_add_book_author;
    private EditText et_add_book_press;
    private EditText et_add_book_binding;
    private EditText et_add_book_score;
    private EditText bt_add_book_bookPhoto;
    private EditText et_add_book_contents;
    private ImageView iv_add_book_bookPhoto;
    private BookInfoController bookInfoController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shop);

        bookInfoController = new BookInfoController();
        initView();
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
        bt_add_book_bookPhoto = (EditText) findViewById(R.id.bt_add_book_bookPhoto);
        et_add_book_contents = (EditText) findViewById(R.id.et_add_book_contents);
        iv_add_book_bookPhoto = (ImageView) findViewById(R.id.iv_add_book_bookPhoto);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_add_book_bookPhoto:
                System.out.println("=========获取图片");
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, 2);
                System.out.println("=========获取图片");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String code = et_add_book_code.getText().toString();
        String bookName = et_add_book_bookName.getText().toString();
        String price = et_add_book_price.getText().toString();
        String oldPrice = et_add_book_oldPrice.getText().toString();
        String author = et_add_book_author.getText().toString();
        String press = et_add_book_press.getText().toString();
        String binding = et_add_book_binding.getText().toString();
        String score = et_add_book_score.getText().toString();
        String contents = et_add_book_contents.getText().toString();
//                String code = bt_add_book_bookPhoto.getText().toString();

        String path ="";
        if (requestCode == 2) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                path = uri.getPath();
                System.out.println("========= 图片地址： " + path);
                iv_add_book_bookPhoto.setImageURI(uri);
                bt_add_book_bookPhoto.setText(path);
            }
        }

        BookInfo bookInfo = new BookInfo(null,code,bookName,price,oldPrice,author,press,binding,score,contents,path);
        bookInfoController.setBookInfo(bookInfo);
        System.out.println("=================="+bookInfo.toString());
    }

}
