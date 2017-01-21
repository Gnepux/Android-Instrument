package com.gnepux.instrument.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.ArraySet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gnepux.instrument.BR;
import com.gnepux.instrument.R;
import com.gnepux.instrument.module.News;
import com.gnepux.instrument.viewholder.BindingRecyclerViewHolder;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by xupeng on 17/1/21.
 */

public class BindingRecyclerAdapter extends RecyclerView.Adapter<BindingRecyclerViewHolder> {

    private LayoutInflater mLayoutInflater;

    private ArrayList<News> mDataList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(News news, int position);
    }

    public BindingRecyclerAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setDataList(ArrayList<News> dataList) {
//        mDataList = dataList;
        mDataList = (ArrayList<News>) dataList.clone();
    }

    Random random = new Random(System.currentTimeMillis());

    public void appendDataList(News news) {
        int position = random.nextInt(mDataList.size() + 1);
        mDataList.add(position, news);
        notifyItemInserted(position);
    }

    public void removeDataList() {
        if (mDataList.size() == 0) {
            return;
        }
        int postion = random.nextInt(mDataList.size());
        mDataList.remove(postion);
        notifyItemRemoved(postion);
    }

    public void setListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    @Override
    public BindingRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil
                .inflate(mLayoutInflater, R.layout.item_databinding_recycler_view, parent, false);
        BindingRecyclerViewHolder viewHolder = new BindingRecyclerViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BindingRecyclerViewHolder holder, final int position) {
        final News news = mDataList.get(position);
        holder.getBinding().setVariable(BR.item, news);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(news, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

}
