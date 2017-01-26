package com.gnepux.instrument.activity.loader;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.util.ArrayMap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gnepux.instrument.R;
import com.gnepux.instrument.activity.BaseActivity;
import com.gnepux.instrument.module.News;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class LoaderActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "LoaderActivity";

    private static final int LOADER_ID = 1;

    ArrayMap<Integer, String> mBtnProp = new ArrayMap<Integer, String>(){
        {
            put(R.id.loader_data_get, "获取数据");
            put(R.id.loader_data_change, "数据改变");
        }
    };

    private NewsLoader mNewsLoader = null;

    private LoaderManager mLoaderMananger = null;

    private LoaderRepository mRepository = new LoaderRepository();

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
        setContentView(R.layout.activity_loader);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_container);
        for (int i = 0; i < mBtnProp.size(); i++) {
            Button button = new Button(this);
            button.setText(mBtnProp.valueAt(i));
            button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            button.setOnClickListener(this);
            button.setId(mBtnProp.keyAt(i));
            linearLayout.addView(button);
        }

        mLoaderMananger = getSupportLoaderManager();
        mNewsLoader = (NewsLoader) mLoaderMananger.initLoader(LOADER_ID, null, new LoaderManager.LoaderCallbacks<List<News>>() {
            @Override
            public Loader<List<News>> onCreateLoader(int id, Bundle args) {
                Logger.d("onCreateLoader");
                NewsLoader loader = new NewsLoader(LoaderActivity.this, mRepository);
                return loader;
            }

            @Override
            public void onLoadFinished(Loader<List<News>> loader, List<News> data) {
                for (News news : data) {
                    Logger.d("onLoadFinished title:" + news.getTitle()
                            + " desc:" + news.getDesc());
                }
            }

            @Override
            public void onLoaderReset(Loader<List<News>> loader) {
                Logger.d("onLoaderReset");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loader_data_get:
                mNewsLoader.forceLoad();
                break;
            case R.id.loader_data_change:
                mNewsLoader.changeData();
                break;
        }
    }
}
