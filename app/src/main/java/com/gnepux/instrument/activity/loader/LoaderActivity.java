package com.gnepux.instrument.activity.loader;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.util.ArrayMap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gnepux.instrument.R;
import com.gnepux.instrument.activity.BaseActivity;
import com.gnepux.instrument.module.News;
import com.orhanobut.logger.Logger;

import java.util.List;

public class LoaderActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "LoaderActivity";

    private static final int LOADER_ID = 1;

    private TextView mTextView;

    ArrayMap<Integer, String> mBtnProp = new ArrayMap<Integer, String>(){
        {
            put(R.id.loader_data_get, "获取数据");
            put(R.id.loader_data_change, "数据改变");
        }
    };

    private NewsLoader mNewsLoader = null;

    private LoaderManager mLoaderMananger = null;

    private LoaderRepository mRepository = new LoaderRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader_x);

        mTextView = (TextView) findViewById(R.id.textview);

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
                StringBuilder builder = new StringBuilder();
                for (News news : data) {
                    Logger.d("onLoadFinished title:" + news.getTitle()
                            + " desc:" + news.getDesc());
                    builder.append(news.getTitle() + ": " + news.getDesc());
                }
                mTextView.setText(builder.toString());
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
