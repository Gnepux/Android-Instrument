package com.gnepux.instrument.daggerClass;

import com.gnepux.instrument.activity.DaggerActivity;

import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xupeng on 17/1/19.
 */

@Module
public class CokeModule {

    public CokeModule() {}

    @Provides
    Coke provideCoke() {
        return new Coke("Gnepux");
    }

    @QulifierSuger
    @Provides
    Coke provideCokeWithSuger() {
        return new Coke(true);
    }

    @QulifierNonSuger
    @Provides
    Coke provideCokeWithoutSuger() {
        return new Coke(false);
    }

    @Provides
    @QulifierScope
    @ActivityScope
    Coke provideCokeScope() {
        return new Coke(DaggerActivity.class);
    }
}
