package com.gnepux.instrument.module;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;

import com.android.databinding.library.baseAdapters.BR;

import javax.inject.Inject;

/**
 * Created by xupeng on 17/1/20.
 */

public class UserEntity extends BaseObservable {

    private String firstName;

    private String lastName;

    private ObservableBoolean chinese;

    public UserEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        chinese = new ObservableBoolean(false);
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    public boolean isChinese() {
        return chinese.get();
    }

    public void setChinese(boolean chinese) {
        this.chinese.set(chinese);
        notifyChange();
    }
}
