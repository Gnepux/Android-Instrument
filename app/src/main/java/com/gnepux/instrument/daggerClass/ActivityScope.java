package com.gnepux.instrument.daggerClass;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by xupeng on 17/1/19.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {}