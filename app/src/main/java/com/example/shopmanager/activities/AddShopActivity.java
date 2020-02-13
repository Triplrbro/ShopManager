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
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.shopmanager.R;
import com.example.shopmanager.TestTwoService;
import com.example.shopmanager.controller.BookInfoController;
import com.example.shopmanager.service.db.bean.BookInfo;
import com.example.shopmanager.utils.RealPathFromUriUtils;

import jp.wasabeef.glide.transformations.CropSquareTransformation;

public class AddShopActivity extends Activity implements View.OnClickListener {

    private EditText et_add_book_code;
    private EditText et_add_book_bookName;
    private EditText et_add_book_price;
    private EditText et_add_book_oldPrice;
    private EditText et_add_book_author;
    private EditText et_add_book_press;
    private EditText et_add_book_binding;
    private EditText et_add_book_score;
    private Button bt_add_book_bookPhoto;
    private Button bt_book_info_add_submit;
    private EditText et_add_book_contents;
    private ImageView iv_add_book_bookPhoto;
    private BookInfoController bookInfoController;
    private String path = "";
    private Uri uri;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
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
        bt_add_book_bookPhoto = (Button) findViewById(R.id.bt_add_book_bookPhoto);
        bt_book_info_add_submit = (Button) findViewById(R.id.bt_book_info_add_submit);
        et_add_book_contents = (EditText) findViewById(R.id.et_add_book_contents);
        iv_add_book_bookPhoto = (ImageView) findViewById(R.id.iv_add_book_bookPhoto);
        Glide.with(this).load(R.drawable.photo_default).into(iv_add_book_bookPhoto);


        /*et_add_book_code.setText("01111");
        et_add_book_bookName.setText("白鹿原");
        et_add_book_price.setText("11.11");
        et_add_book_oldPrice.setText("18.99");
        et_add_book_author.setText("王伟");
        et_add_book_press.setText("长江文学出版社");
        et_add_book_score.setText("9.8");
        et_add_book_binding.setText("精装");
        et_add_book_contents.setText("这是一本值得读一读的好书");*/

        bt_add_book_bookPhoto.setOnClickListener(this);
        bt_book_info_add_submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add_book_bookPhoto:

                System.out.println("=========获取图片");
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
                if (path.equals("")) {
                    Toast.makeText(this, "请选择图片", Toast.LENGTH_SHORT).show();
                    return;
                }
                BookInfo bookInfo = new BookInfo(null, code, bookName, price, oldPrice, author, press, binding, score, contents, RealPathFromUriUtils.getRealPathFromUri(this,uri),0);
                System.out.println("RealPathFromUriUtils"+ RealPathFromUriUtils.getRealPathFromUri(this,uri));
                bookInfoController.setBookInfo(bookInfo);
                System.out.println("==================" + bookInfo.toString());
                Toast.makeText(this, "商品信息添加完成！", Toast.LENGTH_SHORT).show();
                et_add_book_code.setText("");
                et_add_book_bookName.setText("");
                et_add_book_price.setText("");
                et_add_book_oldPrice.setText("");
                et_add_book_author.setText("");
                et_add_book_press.setText("");
                et_add_book_binding.setText("");
                et_add_book_score.setText("");
                et_add_book_contents.setText("");
                Glide.with(this).load(R.drawable.photo_default).into(iv_add_book_bookPhoto);
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
