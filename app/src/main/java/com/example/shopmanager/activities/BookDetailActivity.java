package com.example.shopmanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.shopmanager.R;
import com.example.shopmanager.controller.BookInfoController;
import com.example.shopmanager.controller.CollectController;
import com.example.shopmanager.controller.ShoppingCarController;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.manager.BookInfoManager;
import com.example.shopmanager.service.db.bean.BookInfo;
import com.example.shopmanager.service.db.bean.CollectInfo;

import jp.wasabeef.glide.transformations.CropSquareTransformation;

public class BookDetailActivity extends Activity implements View.OnClickListener {

    private Long book_id;
    private RelativeLayout rl_back;
    private Button bt_back;
    private Button bt_collect;
    private Button bt_collected;
    private Button bt_add_shopcar;
    private Button bt_goto_index;
    private ImageView im_detail_book;
    private TextView tv_book_name;
    private TextView tv_book_price;
    private TextView tv_book_author;
    private TextView tv_book_press;
    private TextView tv_book_binding;
    private TextView tv_book_score;
    private BookInfoManager bookInfoManager;
    private CollectInfo collectInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        book_id = intent.getLongExtra("book_id", 1);

        Toast.makeText(this, book_id + "", Toast.LENGTH_SHORT).show();
        bookInfoManager = new BookInfoManager(this);
        setContentView(R.layout.activity_detailbooks);
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        BookInfo bookInfByCode = new BookInfoController().getBookInfoById(book_id);
        tv_book_name.setText(bookInfByCode.getBookNmae());
        tv_book_price.setText("￥"+bookInfByCode.getPrice());
        tv_book_author.setText(tv_book_author.getText()+bookInfByCode.getAuthor());
        tv_book_press.setText(tv_book_press.getText()+bookInfByCode.getPress());
        tv_book_binding.setText(tv_book_binding.getText()+bookInfByCode.getBinding());
        tv_book_score.setText(bookInfByCode.getScore());
        boolean coller = new CollectController().isColler(UserController.getUserId(), book_id);
        if (coller){
            bt_collected.setVisibility(View.VISIBLE);
            bt_collect.setVisibility(View.GONE);
        }else {
            bt_collected.setVisibility(View.GONE);
            bt_collect.setVisibility(View.VISIBLE);
        }
        Glide.with(this).load(bookInfByCode.getBookPhoto()).bitmapTransform(new CropSquareTransformation(this)).into(im_detail_book);

        collectInfo = new CollectInfo();
        collectInfo.setBookId(book_id);
        collectInfo.setUserId(UserController.getUserId());

    }

    private void initView() {
        rl_back = findViewById(R.id.rl_back);
        bt_back = findViewById(R.id.bt_back);
        bt_collect = findViewById(R.id.bt_collect);
        bt_collected = findViewById(R.id.bt_collected);
        im_detail_book = findViewById(R.id.im_detail_book);
        tv_book_name = findViewById(R.id.tv_book_name);
        tv_book_price = findViewById(R.id.tv_book_price);
        tv_book_author = findViewById(R.id.tv_book_author);
        tv_book_press = findViewById(R.id.tv_book_press);
        tv_book_binding = findViewById(R.id.tv_book_binding);
        tv_book_score = findViewById(R.id.tv_book_score);
        bt_add_shopcar = findViewById(R.id.bt_add_shopcar);
        bt_goto_index = findViewById(R.id.bt_goto_index);
        rl_back.setOnClickListener(this);
        bt_back.setOnClickListener(this);
        bt_add_shopcar.setOnClickListener(this);
        bt_goto_index.setOnClickListener(this);
        bt_collect.setOnClickListener(this);
        bt_collected.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_collect:
                new CollectController().insertColler(collectInfo);
                bt_collected.setVisibility(View.VISIBLE);
                bt_collect.setVisibility(View.GONE);
                break;
            case R.id.bt_collected:
                new CollectController().insertColler(collectInfo);
                bt_collected.setVisibility(View.GONE);
                bt_collect.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_back:
            case R.id.rl_back:

                finish();
                break;
            case R.id.bt_goto_index:
                finish();
                break;
            case R.id.bt_add_shopcar:

                new ShoppingCarController().setShoppingCarOnce(book_id, UserController.getUserId());
                Toast.makeText(this, "添加购物车成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
