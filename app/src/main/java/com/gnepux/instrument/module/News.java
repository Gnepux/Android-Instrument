package com.gnepux.instrument.module;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;

/**
 * Created by xupeng on 17/1/20.
 */

public class News {

    private int imageResId;

    private String title;

    private String desc;

    public News(@DrawableRes int imageResId, String title, String desc) {
        this.imageResId = imageResId;
        this.title = title;
        this.desc = desc;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
