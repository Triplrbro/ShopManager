package com.example.shopmanager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.shopmanager.R;
import com.example.shopmanager.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class FirstPageFragment extends Fragment implements View.OnClickListener {
    private View fragment_firstPage;
    private Banner bn_banner;
    private LinearLayout ll_type_first;
    private View ll_type_second;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        fragment_firstPage = inflater.inflate(R.layout.fragment_firstpage, null);

        initView();
        initData();

        return fragment_firstPage;
    }

    private void initData() {


        List<String> bannerImageList = new ArrayList<>();
        bannerImageList.add("https://ss0.baidu.com/73t1bjeh1BF3odCf/it/u=739872266,1721276772&fm=85&s=21B2379F1C4C4CC82EC5A5EE0300C030");
        bannerImageList.add("https://img.alicdn.com/tfs/TB1PN9_ka61gK0jSZFlXXXDKFXa-860-80.png");
        bannerImageList.add("http://pan.thethreestooges.cn/index.php/s/CnsiLJI51QSpClC");
        bn_banner.setImages(bannerImageList);
        bn_banner.start();
        bn_banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
//                Intent intent = new Intent(getActivity(), CommodityDetailsActivity.class);
//                intent.putExtra("commodityInfo", commodityInfoList.get(position));
//                startActivity(intent);
            }
        });
    }

    private void initView() {

        bn_banner = fragment_firstPage.findViewById(R.id.bn_banner);
        ll_type_first = fragment_firstPage.findViewById(R.id.ll_type_first);
        ll_type_second = fragment_firstPage.findViewById(R.id.ll_type_second);
        ll_type_first.setOnClickListener(this);
        ll_type_second.setOnClickListener(this);
        bn_banner.setImageLoader(new GlideImageLoader());
        bn_banner.isAutoPlay(true);
        bn_banner.setDelayTime(5000);
        bn_banner.setIndicatorGravity(BannerConfig.CENTER);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_type_first:
                Toast.makeText(getContext(), "ll_type_first", Toast.LENGTH_SHORT).show();
            case R.id.ll_type_second:
                Toast.makeText(getContext(), "ll_type_second", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
