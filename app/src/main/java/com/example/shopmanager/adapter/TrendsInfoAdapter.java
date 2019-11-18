package com.example.shopmanager.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shopmanager.R;
import com.example.shopmanager.service.db.bean.TrendsInfo;
import com.example.shopmanager.utils.SharedPreferencesUtil;

import java.util.List;

import jp.wasabeef.glide.transformations.CropSquareTransformation;

public class TrendsInfoAdapter extends RecyclerView.Adapter<TrendsInfoAdapter.ViewHolder> {
    private List<TrendsInfo> list;
    private Context context;


    public TrendsInfoAdapter(List<TrendsInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bbs, parent, false);
        return new TrendsInfoAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Glide.with(context).load(list.get(position).getPhotoPath()).bitmapTransform(new CropSquareTransformation(context)).into( holder.iv_bbs);
//        Glide.with(context).load(list.get(position).getUserInfo().getUserPhoto()).bitmapTransform(new CropSquareTransformation(context)).into( holder.iv_bbs);
//        Glide.with(context).load("https://img.alicdn.com/tfs/TB1PN9_ka61gK0jSZFlXXXDKFXa-860-80.png").bitmapTransform(new CropSquareTransformation(context)).into(holder.iv_bbs);

        Glide.with(context).load(list.get(position).getPhotoPath()).into(holder.iv_bbs);

        holder.tv_bbs.setText(list.get(position).getText());
        holder.tv_bbs_user.setText(list.get(position).getUserInfo().getUserName());

    }

    @Override
    public int getItemCount() {
        return  list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_bbs_user;
        private final ImageView iv_bbs;
        private final TextView tv_bbs_user;
        private final TextView tv_bbs;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_bbs_user = itemView.findViewById(R.id.iv_bbs_user);
            iv_bbs = itemView.findViewById(R.id.iv_bbs);
            tv_bbs_user = itemView.findViewById(R.id.tv_bbs_user);
            tv_bbs = itemView.findViewById(R.id.tv_bbs);


        }
    }
}