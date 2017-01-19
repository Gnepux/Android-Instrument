package com.gnepux.instrument.repository;

import com.gnepux.instrument.constant.Constant;
import com.gnepux.instrument.module.JsonBase;
import com.gnepux.instrument.module.Login;
import com.gnepux.instrument.module.Post;
import com.gnepux.instrument.module.Repo;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by xupeng on 17/1/18.
 */

public class Repository {

    /**
     * https://api.github.com/users/{user}/repos
     */
    public interface IGithubRepo {
        @GET("users/{user}/repos")
        Call<List<Repo>> getGithubRepo(@Path("user") String user);
    }

    /**
     * RxJava版本的接口
     */
    public interface IGithubRepoObservable {
        @GET("users/{user}/repos")
        Observable<List<Repo>> getGithubRepo(@Path("user") String user);
    }

    /**
     * http://localhost/php2/fanyin/?json=get_posts&page=1&count=3
     */
    public interface IGetPost {
        @GET("php2/fanyin")
        Call<Post> getPost(@Query("json") String json,
                     @Query("page") String page,
                     @Query("count") String count);
    }

    public interface ILoginRF {
        @POST(Constant.URL_LOGIN)
        @FormUrlEncoded
        Call<Login> postLoginRF(@FieldMap HashMap<String, String> values);
    }

}
