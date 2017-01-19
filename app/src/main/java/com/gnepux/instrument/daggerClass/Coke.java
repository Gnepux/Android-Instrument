package com.gnepux.instrument.daggerClass;

import com.orhanobut.logger.Logger;

import java.lang.reflect.Type;

import javax.inject.Inject;

/**
 * Created by xupeng on 17/1/19.
 */

public class Coke {

    @Inject
    public Coke() {
        Logger.d("a cup of coke was made");
    }

    public Coke(String name) {
        Logger.d("a cup of coke was mode by " + name);
    }

    public Coke(Boolean withSuger) {
        if (withSuger) {
            Logger.d("a cup of coke was mode with suger");
        } else {
            Logger.d("a cup of coke was mode by without suger");
        }
    }

    public Coke(Class<?> cls) {
        Logger.d("a cup of coke was mode scope in " + cls.getName());
    }
}
