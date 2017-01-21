package com.gnepux.instrument.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.ArraySet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gnepux.instrument.R;
import com.gnepux.instrument.module.News;
import com.gnepux.instrument.viewholder.OriginRecyclerViewHolder;

import java.util.ArrayList;

/**
 * Created by xupeng on 17/1/21.
 */

public class OriginRecyclerAdapter extends RecyclerView.Adapter<OriginRecyclerViewHolder> {

    private LayoutInflater mLayoutInflater;

    private ArrayList<News> mDataList;

    public OriginRecyclerAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setDataList(ArrayList<News> dataList) {
//        mDataList = dataList;
        mDataList = (ArrayList<News>) dataList.clone();
    }

    public void appendDataList(News news) {
        mDataList.add(news);
        notifyItemInserted(mDataList.size());
    }

    public void removeDataList() {
        if (mDataList.size() == 0) {
            return;
        }
        mDataList.remove(0);
        notifyItemRemoved(0);
    }

    @Override
    public OriginRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_origin_recycler_view, parent, false);
        OriginRecyclerViewHolder viewHolder = new OriginRecyclerViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OriginRecyclerViewHolder holder, int position) {
        News news = mDataList.get(position);
        holder.imageView.setImageResource(news.getImageResId());
        holder.titleTv.setText(news.getTitle());
        holder.descTv.setText(news.getDesc());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
