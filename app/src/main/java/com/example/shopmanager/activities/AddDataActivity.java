package com.example.shopmanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.shopmanager.R;
import com.example.shopmanager.controller.BookInfoController;
import com.example.shopmanager.controller.ShoppingCarController;
import com.example.shopmanager.service.BaseService;
import com.example.shopmanager.service.BookInfoService;
import com.example.shopmanager.service.db.bean.BookInfo;
import com.example.shopmanager.service.db.bean.ShoppingCart;

import java.util.List;

public class AddDataActivity extends Activity implements View.OnClickListener {
    private Button bt_add_data_book;
    private Button bt_remove_data_book;
    private Button bt_add_img;
    private BookInfoController bookInfoController;
    private TextView tv_show_data_book;
    private ImageView test_image;
    private Button bt_show_data_book;
    private Button tv_cut_data_shop;
    private Button bt_insert_data_shop;
    private Button bt_add_data_shop;
    private ShoppingCarController shoppingCarController;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resource);

        bookInfoController = new BookInfoController();
        shoppingCarController = new ShoppingCarController();

        initView();
    }

    private void initView() {
        bt_add_data_book = findViewById(R.id.bt_add_data_book);
        bt_remove_data_book = findViewById(R.id.bt_remove_data_book);
        bt_add_img = findViewById(R.id.bt_add_img);
        tv_show_data_book = (TextView) findViewById(R.id.tv_show_data_book);
        test_image = (ImageView) findViewById(R.id.test_image);
        bt_show_data_book = (Button) findViewById(R.id.bt_show_data_book);
        tv_cut_data_shop = (Button) findViewById(R.id.tv_cut_data_shop);
        bt_insert_data_shop = (Button) findViewById(R.id.bt_insert_data_shop);
        bt_add_data_shop = (Button) findViewById(R.id.bt_add_data_shop);

        bt_add_data_book.setOnClickListener(this);
        bt_remove_data_book.setOnClickListener(this);
        bt_add_img.setOnClickListener(this);
        bt_show_data_book.setOnClickListener(this);
        tv_cut_data_shop.setOnClickListener(this);
        bt_insert_data_shop.setOnClickListener(this);
        bt_add_data_shop.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add_img:
                System.out.println("=========获取图片");
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, 2);
                System.out.println("=========获取图片");
                break;
            case R.id.bt_add_data_book:
                testInsert();
                break;
            case R.id.bt_show_data_book:
                List<BookInfo> query = query();
                tv_show_data_book.setText("");
                for (BookInfo bookInfo : query) {
                    tv_show_data_book.setText(tv_show_data_book.getText() + " \n  " + bookInfo.toString());
                }
                break;
            case R.id.bt_remove_data_book:
                BaseService baseService = new BaseService();
                baseService.daoSession.getBookInfoDao().deleteAll();
                break;
            case R.id.tv_cut_data_shop:
                int i = shoppingCarController.cutShop(1L);
                System.out.println("==========="+i);
                tv_show_data_book.setText(String.valueOf(i));
                break;
            case R.id.bt_add_data_shop:
                int i1 = shoppingCarController.addShop(1L);
                tv_show_data_book.setText(String.valueOf(i1));
                System.out.println("==========="+i1);
                break;
            case R.id.bt_insert_data_shop:
                ShoppingCart shoppingCart = new ShoppingCart(null, 1L, 1L, 1, 0L);
                shoppingCarController.setShoppingCarOnce(shoppingCart);
                System.out.println("============="+shoppingCart.toString());
                tv_show_data_book.setText(shoppingCart.toString());
                break;
        }
    }


    private void testInsert() {
        BookInfo bookInfo = new BookInfo(null, "xxxx", "了不起的我：自我发", "44", "400", "中国人民", "北京邮电", "精装", "4.5", "这是简介啊~~~~~~", "hrrp://location","0");
        BookInfoService bookInfoService = new BookInfoService();
        bookInfoService.setBookInfo(bookInfo);
        bookInfo = new BookInfo(null, "xxxx", "永久记录", "200", "12", "中国人民", "北京邮电", "精装", "4.5", "这是简介啊~~~~~~", "hrrp://location","0");
        bookInfoService.setBookInfo(bookInfo);
        bookInfo = new BookInfo(null, "xxxx", "DK儿童英语基础必", "123", "400", "中国人民", "北京邮电", "精装", "4.5", "这是简介啊~~~~~~", "hrrp://location","0");
        bookInfoService.setBookInfo(bookInfo);
        bookInfo = new BookInfo(null, "xxxx", "【独家新品】乖，摸", "32", "400", "中国人民", "北京邮电", "精装", "4.5", "这是简介啊~~~~~~", "hrrp://location","0");
        bookInfoService.setBookInfo(bookInfo);
    }

    private List<BookInfo> query() {
        BookInfoService bookInfoService = new BookInfoService();
        List<BookInfo> bookInfos = bookInfoService.queryBookInfoList();
        return bookInfos;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                String path = uri.getPath();
                System.out.println("========= 图片地址： " + path);
                test_image.setImageURI(uri);
                tv_show_data_book.setText(path);
            }
        }
    }
}
