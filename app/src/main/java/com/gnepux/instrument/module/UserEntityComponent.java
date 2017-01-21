package com.gnepux.instrument.module;

import com.gnepux.instrument.activity.databindling.DataBindlingSimpleActivity;

import dagger.Component;

/**
 * Created by xupeng on 17/1/20.
 */

@Component(modules = {UserEntityModule.class})
public interface UserEntityComponent {

    void injectSimple(DataBindlingSimpleActivity dataBindlingSimpleActivity);

}
