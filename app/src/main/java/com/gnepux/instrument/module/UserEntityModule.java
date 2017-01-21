package com.gnepux.instrument.module;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xupeng on 17/1/20.
 */
@Module
public class UserEntityModule {

    public UserEntityModule() {}

    @Provides
    public UserEntity providerUserEntity() {
        return new UserEntity("xu", "peng");
    }

}
