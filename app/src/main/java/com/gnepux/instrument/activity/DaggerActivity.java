package com.gnepux.instrument.activity;

import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.gnepux.instrument.R;
import com.gnepux.instrument.daggerClass.ActivityScope;
import com.gnepux.instrument.daggerClass.Coke;
import com.gnepux.instrument.daggerClass.DaggerCokeComponent;
import com.gnepux.instrument.daggerClass.QulifierNonSuger;
import com.gnepux.instrument.daggerClass.QulifierScope;
import com.gnepux.instrument.daggerClass.QulifierSuger;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayMap<Integer, String> mBtnProp = new ArrayMap<Integer, String>(){
        {
            put(R.id.dagger_inject_only, "仅使用@Inject");
            put(R.id.dagger_module_and_provider, "使用@Module和@Provider");
            put(R.id.dagger_qulifier, "使用@Qulifier");
            put(R.id.dagger_scope, "使用@Scope");
        }
    };

    // 定义变量并标注
    @Inject Coke coke;

    @QulifierSuger
    @Inject
    Coke cokeWithSuger;

    @QulifierNonSuger
    @Inject
    Coke cokeWithoutSuger;

    @ActivityScope
    @QulifierScope
    @Inject
    Coke cokeA;

    @ActivityScope
    @QulifierScope
    @Inject
    Coke cokeB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_container);
        for (int i = 0; i < mBtnProp.size(); i++) {
            Button button = new Button(this);
            button.setText(mBtnProp.valueAt(i));
            button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            button.setOnClickListener(this);
            button.setId(mBtnProp.keyAt(i));
            linearLayout.addView(button);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dagger_inject_only:
                daggerInjectOnly();
                break;
            case R.id.dagger_module_and_provider:
                daggerModuleAndProvider();
                break;
            case R.id.dagger_qulifier:
                daggerQulifier();
                break;
            case R.id.dagger_scope:
                daggerScope();
                break;
        }
    }

    /**
     * 仅使用@Inject。
     * 在Coke的无参构造方法上使用@Inject,
     * CokeComponent不指定任何modules。
     */
    private void daggerInjectOnly() {
        // DaggerCokeComponent由CokeComponent生成,调用下面的方法实现依赖注入
        DaggerCokeComponent.builder().build().inject(this);
    }

    /**
     * 使用@Module和@Provider。
     * 在CokeModule的provideCoke上使用@Provider,在该方法中通过Coke的有参构造方法进行初始化,
     * CokeComponent指定modules为CokeModule提供依赖。
     */
    private void daggerModuleAndProvider() {
        // DaggerCokeComponent由CokeComponent生成,调用下面的方法实现依赖注入
        DaggerCokeComponent.builder().build().inject(this);
    }

    /**
     * 使用@Qulifier。
     * 先定义两个注解:QulifierNonSuger和QulifierSuger,
     * 在CokeModule为这两个注解提供Provider。
     * Activity通过这两个注解声明两个对象,则CokeModule会通过相应的Provider创建对象。
     */
    private void daggerQulifier() {
        // DaggerCokeComponent由CokeComponent生成,调用下面的方法实现依赖注入
        DaggerCokeComponent.builder().build().inject(this);
    }

    private void daggerScope() {
        // DaggerCokeComponent由CokeComponent生成,调用下面的方法实现依赖注入
        DaggerCokeComponent.builder().build().inject(this);
    }
}
