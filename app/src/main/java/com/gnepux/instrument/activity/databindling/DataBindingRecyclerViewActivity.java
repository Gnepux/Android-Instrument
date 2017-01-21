package com.gnepux.instrument.activity.databindling;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gnepux.instrument.R;
import com.gnepux.instrument.adapter.BindingRecyclerAdapter;
import com.gnepux.instrument.adapter.OriginRecyclerAdapter;
import com.gnepux.instrument.databinding.ActivityDataBindingRecyclerViewBinding;
import com.gnepux.instrument.module.News;

import java.util.ArrayList;

public class DataBindingRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private OriginRecyclerAdapter mOriginAdapter;

    private BindingRecyclerAdapter mBindingAdapter;

    private ActivityDataBindingRecyclerViewBinding mBinding;

    private static class AdapterFactory {
        public static <T extends RecyclerView.Adapter> T getAdapter(Class<T> c) {
            RecyclerView.Adapter adapter = null;
            try {
                adapter = (T)Class.forName(c.getName()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return (T)adapter;
        }
    }

    private ArrayList<News> mLists = new ArrayList<>();
    {
        mLists.add(new News(R.mipmap.ic_launcher, "文章1", "描述1"));
        mLists.add(new News(R.mipmap.ic_launcher, "文章2", "描述2"));
        mLists.add(new News(R.mipmap.ic_launcher, "文章3", "描述3"));
        mLists.add(new News(R.mipmap.ic_launcher, "文章4", "描述4"));
        mLists.add(new News(R.mipmap.ic_launcher, "文章5", "描述5"));
        mLists.add(new News(R.mipmap.ic_launcher, "文章6", "描述6"));
        mLists.add(new News(R.mipmap.ic_launcher, "文章7", "描述7"));
        mLists.add(new News(R.mipmap.ic_launcher, "文章8", "描述8"));
        mLists.add(new News(R.mipmap.ic_launcher, "文章9", "描述9"));
        mLists.add(new News(R.mipmap.ic_launcher, "文章10", "描述10"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_recycler_view);
        mBinding.setPresenter(new Presenter());
        mRecyclerView = mBinding.recyclerView;

        mOriginAdapter = new OriginRecyclerAdapter(getBaseContext());
        mBindingAdapter = new BindingRecyclerAdapter(getBaseContext());
        mOriginAdapter.setDataList(mLists);
        mBindingAdapter.setDataList(mLists);
        mBindingAdapter.setListener(new BindingRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(News news, int position) {
                Toast.makeText(DataBindingRecyclerViewActivity.this, "click: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置增加或删除条目的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

//        mRecyclerView.setAdapter(mOriginAdapter);
        mRecyclerView.setAdapter(mBindingAdapter);
    }

    public class Presenter {

        public void onAddBtnClick(View v) {
            mOriginAdapter.appendDataList(new News(R.mipmap.ic_launcher, "Title", "Desc"));
            mBindingAdapter.appendDataList(new News(R.mipmap.ic_launcher, "Title", "Desc"));
        }

        public void onRemoveBtnClick(View v) {
            mOriginAdapter.removeDataList();
            mBindingAdapter.removeDataList();
        }
    }
}
