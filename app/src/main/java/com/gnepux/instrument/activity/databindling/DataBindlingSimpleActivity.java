package com.gnepux.instrument.activity.databindling;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gnepux.instrument.R;
import com.gnepux.instrument.databinding.ActivityDataBindlingSimpleBinding;
import com.gnepux.instrument.module.DaggerUserEntityComponent;
import com.gnepux.instrument.module.UserEntity;

import javax.inject.Inject;

public class DataBindlingSimpleActivity extends AppCompatActivity {

    @Inject
    UserEntity userEntity;

    ActivityDataBindlingSimpleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_bindling_simple);

        DaggerUserEntityComponent.create().injectSimple(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_bindling_simple);
        binding.setUserEntity(userEntity);
//        binding.setVariable(BR.userEntity, userEntity);
        binding.setPresenter(new Presenter());
        binding.viewStub.getViewStub().inflate();

    }

    public class Presenter {
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            userEntity.setFirstName(s.toString());
//            binding.setUserEntity(userEntity);
        }

        public void onClick(View view) {
            Toast.makeText(getBaseContext(), "点击", Toast.LENGTH_SHORT).show();
            userEntity.setLastName("changed");
            userEntity.setChinese(!userEntity.isChinese());
//            binding.setUserEntity(userEntity);
        }

        public void onClickListenerBinding(UserEntity userEntity) {
            Toast.makeText(getBaseContext(), userEntity.getLastName(), Toast.LENGTH_SHORT).show();
        }
    }

}
