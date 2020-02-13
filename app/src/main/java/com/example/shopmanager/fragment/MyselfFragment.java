package com.example.shopmanager.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopmanager.R;
import com.example.shopmanager.activities.AddDataActivity;
import com.example.shopmanager.activities.OrderListActivity;
import com.example.shopmanager.adapter.TrendsInfoAdapter;
import com.example.shopmanager.controller.TrendsController;
import com.example.shopmanager.controller.UserController;
import com.example.shopmanager.service.db.bean.TrendsInfo;
import com.example.shopmanager.service.db.bean.UserInfo;
import com.example.shopmanager.utils.GlideCircleTransform;
import com.example.shopmanager.utils.RealPathFromUriUtils;
import com.example.shopmanager.utils.SharedPreferencesUtil;

import java.util.List;


public class MyselfFragment extends Fragment implements View.OnClickListener {

    private View fragment_myself;
    private LinearLayout ll_userHead;
    private RelativeLayout ll_order;
    private ImageView iv_order;
    private TextView tv_order;
    private RelativeLayout ll_set;
    private ImageView iv_set;
    private TextView tv_set;
    private RecyclerView rv_my_bbs;
    private ImageView iv_userHead;
    private Uri uri;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        fragment_myself = inflater.inflate(R.layout.fragment_myself, null);

        initView();

        initData();
        return fragment_myself;
    }

    private void initData() {
        UserInfo userInfo = UserController.getUserInfo();
        Glide.with(this).load(userInfo.getUserPhoto()).placeholder(R.drawable.ic_userhead).bitmapTransform(new GlideCircleTransform(getActivity())).into(iv_userHead);

        List<TrendsInfo> trendsInfos = new TrendsController().queryTrendsInfoById(UserController.getUserId());
        TrendsInfoAdapter trendsInfoAdapter = new TrendsInfoAdapter(trendsInfos, getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        rv_my_bbs.setLayoutManager(manager);
        rv_my_bbs.setAdapter(trendsInfoAdapter);
    }

    private void initView() {


        ll_set = fragment_myself.findViewById(R.id.ll_set);
        iv_set = fragment_myself.findViewById(R.id.iv_set);
        tv_set = fragment_myself.findViewById(R.id.tv_set);
        ll_order = fragment_myself.findViewById(R.id.ll_order);
        iv_order = fragment_myself.findViewById(R.id.iv_order);
        tv_order = fragment_myself.findViewById(R.id.tv_order);
        rv_my_bbs = fragment_myself.findViewById(R.id.rv_my_bbs);
        iv_userHead = fragment_myself.findViewById(R.id.iv_userHead);
        iv_userHead.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, 2);
                System.out.println("=========获取图片");
                return false;
            }
        });
        iv_userHead.setOnClickListener(this);

        ll_set.setOnClickListener(this);
        iv_order.setOnClickListener(this);
        ll_order.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_set:
            case R.id.iv_set:
            case R.id.tv_set:
                Intent intent = new Intent(getContext(), AddDataActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_order:
            case R.id.iv_order:
            case R.id.tv_order:

                Intent intent2 = new Intent(getContext(), OrderListActivity.class);
                startActivity(intent2);
                break;
            case R.id.iv_userHead:
//                TODO:修改用户名页面实现
//                Intent intent2 = new Intent(getContext());
//                startActivity(intent2);
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                uri = data.getData();
                String uriString = String.valueOf(uri);
                Glide.with(this).load(uriString).bitmapTransform(new GlideCircleTransform(getActivity())).into(iv_userHead);
                new UserController().setUserPhoto(new SharedPreferencesUtil().getUserName(), RealPathFromUriUtils.getRealPathFromUri(getActivity(),uri));
            }
        }
    }

}

