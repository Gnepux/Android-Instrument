package com.gnepux.instrument.activity;

import android.support.annotation.StringRes;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gnepux.instrument.R;
import com.gnepux.instrument.constant.Constant;
import com.gnepux.instrument.convert.MyConverterFactory;
import com.gnepux.instrument.module.Login;
import com.gnepux.instrument.module.Post;
import com.gnepux.instrument.module.Repo;
import com.gnepux.instrument.repository.Repository;
import com.gnepux.instrument.utils.Utils;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "RetrofitActivity";

    private ArrayMap<Integer, String> mBtnProp = new ArrayMap<Integer, String>(){
        {
            put(R.id.retrofit_get_repo, "Get请求GithubRepo");
            put(R.id.retrofit_get_posts, "Get请求本地文章");
            put(R.id.retrofit_post_login, "Post请求登录RF");
            put(R.id.retrofit_rxjava_get_posts, "Retrofit + RxJava 请求GithubRepo");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

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
            case R.id.retrofit_get_repo:
                retrofitGetRepo("Gnepux");
                break;
            case R.id.retrofit_get_posts:
                retrofitGetPost("1", "3");
                break;
            case R.id.retrofit_post_login:
                retrofitPostLogin();
                break;
            case R.id.retrofit_rxjava_get_posts:
                retrofitGetRepoRxJava("Gnepux");
                break;
        }
    }

    private void retrofitGetRepo(final String user) {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.REMOTE_BASE_URL_GET)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        Repository.IGithubRepo service = retrofit.create(Repository.IGithubRepo.class);
        Call<List<Repo>> call = service.getGithubRepo(user);

//        同步调用
//        try {
//            Response<List<Repo>> data = repos.execute();
//            Logger.d(data.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//         异步调用
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> data = response.body();
                Logger.d(response.toString());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Logger.e(t.toString());
            }
        });


    }

    private void retrofitGetPost(String page, String pageSize) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.LOCAL_BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(new MyConverterFactory())
                .client(client)
                .build();
        Repository.IGetPost service = retrofit.create(Repository.IGetPost.class);
        Call<Post> call = service.getPost("get_posts", page, pageSize);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();
                Logger.d(post);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Logger.e(t.toString());
            }
        });
    }

    private void retrofitPostLogin() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.REMOTE_BASE_URL_POST)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        Repository.ILoginRF iLoginRF = retrofit.create(Repository.ILoginRF.class);
        String[] value = { "15010551", "-1", "", "-1" };
        HashMap<String, String> params = new HashMap<>();
        params.put("interfaceName", "login");
        params.put("userCode", "15010551");
        params.put("password", "q");
        params.put("ip", "0.0.0.0");
        params.put("hostname", "android");
        params.put("functionName", "");
        params.put("paramName", "");
        params.put("paramValue", "");
        params.put("ports", Utils.getStringValue(value));
        Call<Login> call = iLoginRF.postLoginRF(params);

        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Logger.d(response.body().toString());
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Logger.e(t.toString());
            }
        });
    }

    private void retrofitGetRepoRxJava(String user) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        Repository.IGithubRepoObservable service =
                retrofit.create(Repository.IGithubRepoObservable.class);
        service.getGithubRepo(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .flatMap(new Func1<List<Repo>, Observable<Repo>>() {
//                    @Override
//                    public Observable<Repo> call(List<Repo> repos) {
//                        return Observable.from(repos);
//                    }
//                })
                .subscribe(new Observer<List<Repo>>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(RetrofitActivity.this, "获取数据成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                    }

                    @Override
                    public void onNext(List<Repo> repos) {
                        Logger.d(repos);
                    }
                });
    }

}
