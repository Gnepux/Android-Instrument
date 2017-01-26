package com.gnepux.instrument.activity.loader;

import com.gnepux.instrument.R;
import com.gnepux.instrument.module.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xupeng on 17/1/24.
 */

public class LoaderRepository {

    public interface LoaderRepositoryObserver {
        void onDataChanged(List<News> list);
    }

    private ArrayList<LoaderRepositoryObserver> mObservers = new ArrayList<>();

    ArrayList<News> mList = new ArrayList<>();

    public void addObserver(LoaderRepositoryObserver observer) {
        mObservers.add(observer);
    }

    public void removeObserver(LoaderRepositoryObserver observer) {
        if (mObservers.contains(observer)) {
            mObservers.remove(observer);
        }
    }

    public void notifyObserver(List<News> list) {
        for (LoaderRepositoryObserver observer : mObservers) {
            observer.onDataChanged(list);
        }
    }

    public List<News> getNew(String title, String desc) {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        News news = new News(R.mipmap.ic_launcher, title, desc);
        mList.add(news);
        return (List<News>) mList.clone();
    }

    public void changeData() {
        News news = new News(R.mipmap.ic_launcher, "123", "456");
        mList.add(news);
        notifyObserver((List<News>) mList.clone());
    }

}
