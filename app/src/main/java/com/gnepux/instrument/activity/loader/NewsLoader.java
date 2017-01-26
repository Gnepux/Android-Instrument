package com.gnepux.instrument.activity.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.gnepux.instrument.module.News;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xupeng on 17/1/24.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> implements LoaderRepository.LoaderRepositoryObserver {

    private LoaderRepository mRepository = null;

    public NewsLoader(Context context, LoaderRepository repository) {
        super(context);
        // run only once
        onContentChanged();
        mRepository = repository;
    }

    public void changeData() {
        mRepository.changeData();
    }

    @Override
    protected void onStartLoading() {
        Logger.d("onStartLoading");
        super.onStartLoading();
        mRepository.addObserver(this);
//        if (takeContentChanged()) {
//            forceLoad();
//        }
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onReset() {
        onStopLoading();
        mRepository.removeObserver(this);
    }

    @Override
    public List<News> loadInBackground() {
        Logger.d("loadInBackground");
        List<News> data = mRepository.getNew("新文章", "新描述");
        return data;
    }

    @Override
    public void deliverResult(List<News> news) {
        if (isReset()) {
            return;
        }

        if (isStarted()) {
            super.deliverResult(news);
        }

    }

    @Override
    public void onDataChanged(List<News> list) {
        Logger.d("onDataChanged");
        if (isStarted()) {
            Logger.d("onDataChanged isStarted");
            deliverResult(list);
        }
    }

}
