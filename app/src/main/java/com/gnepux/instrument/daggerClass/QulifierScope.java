package com.gnepux.instrument.daggerClass;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by xupeng on 17/1/19.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface QulifierScope {}
