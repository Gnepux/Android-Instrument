package com.gnepux.instrument.daggerClass;

import com.gnepux.instrument.activity.DaggerActivity;

import dagger.Component;

/**
 * Created by xupeng on 17/1/19.
 */
@ActivityScope
@Component(modules = {CokeModule.class})
public interface CokeComponent {

    void inject(DaggerActivity activity);

}
