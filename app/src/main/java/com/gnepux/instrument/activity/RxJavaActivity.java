package com.gnepux.instrument.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gnepux.instrument.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action3;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxJavaActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "RxJavaActivity";

    private String[] strArrayOne = new String[]{"o", "n", "e"};
    private String[] strArrayTwo = new String[]{"t", "w", "o"};
    private String[] strArrayThree = new String[]{"t", "h", "r", "e", "e"};
    private ArrayList<String[]> mStrList = new ArrayList<>();
    {
        mStrList.add(strArrayOne);
        mStrList.add(strArrayTwo);
        mStrList.add(strArrayThree);
    }

    private ArrayMap<Integer, String> mBtnProp = new ArrayMap<Integer, String>(){
        {
            put(R.id.rxjava_1, "RxJava基本用法");
            put(R.id.rxjava_2, "RxJava传递多种类型的参数");
            put(R.id.rxjava_3, "RxJava使用ActionX函数订阅");
            put(R.id.rxjava_4, "RxJava的Scheduler和Map用法");
            put(R.id.rxjava_5, "RxJava的FlatMap用法");
            put(R.id.rxjava_6, "RxJava的lift用法");
            put(R.id.rxjava_7, "RxJava的compose用法");
            put(R.id.rxjava_8, "RxJava的doOnSubcribe()用法");
        }
    };

    private LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        Logger.init(TAG);

        mContainer = (LinearLayout) findViewById(R.id.ll_container);
        for (int i = 0; i < mBtnProp.size(); i++) {
            Button button = new Button(this);
            button.setText(mBtnProp.valueAt(i));
            button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            button.setOnClickListener(this);
            button.setId(mBtnProp.keyAt(i));
            mContainer.addView(button);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rxjava_1:
                RxJavaOne();
                break;
            case R.id.rxjava_2:
                RxJavaTwo();
                break;
            case R.id.rxjava_3:
                RxJavaThree();
                break;
            case R.id.rxjava_4:
                RxJavaFour();
                break;
            case R.id.rxjava_5:
                RxJavaFive();
                break;
            case R.id.rxjava_6:
                RxJavaSix();
                break;
            case R.id.rxjava_7:
                RxJavaSeven();
                break;
            case R.id.rxjava_8:
                RxJavaEight();
                break;
        }
    }

    private void RxJavaOne() {
        Observer<String> observer = new Observer<String>(){

            @Override
            public void onCompleted() {
                Logger.d("onCompleted: Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("onError: Error!");
            }

            @Override
            public void onNext(String s) {
                Logger.d("onNext: " + s);
            }
        };

        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onStart();
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });

        observable.subscribe(observer);

    }

    private void RxJavaTwo() {
        Observable observable = Observable.just("Hello", "Hi", "Aloha", 4, true);
        Action3<String, Integer, Boolean> action3 = new Action3<String, Integer, Boolean>() {
            @Override
            public void call(String s, Integer integer, Boolean aBoolean) {
                Log.d(TAG, "call: ");
            }
        };
        Subscriber observer = new Subscriber() {

            @Override
            public void onStart() {
                super.onStart();
                Log.d(TAG, "onStart: ");
            }

            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onNext(Object o) {
                Log.d(TAG, "onNext: " + o.toString());
            }
        };
        observable.subscribe(observer);
    }

    private void RxJavaThree() {
        Observable observable = Observable.just("Hello", "Hi", "Aloha");
        Action1<String> nextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "next: " + s);
            }
        };
        Action1<Throwable> errorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG, "error: ");
            }
        };
        Action0 completeAction = new Action0() {
            @Override
            public void call() {
                Log.d(TAG, "complete: ");
            }
        };
        observable.subscribe(nextAction, errorAction, completeAction);
    }

    private void RxJavaFour() {
        Observable.just(R.mipmap.ic_launcher)
                .map(new Func1<Integer, Bitmap>() {
                    @Override
                    public Bitmap call(Integer resId) {
                        return BitmapFactory.decodeResource(getResources(), resId);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bitmap>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
                        ImageView imageView = new ImageView(getBaseContext());
                        imageView.setImageBitmap(bitmap);
                        mContainer.addView(imageView);
                    }
                });
    }

    private void RxJavaFive() {
        Observable.just(0, 1, 2)
                .flatMap(new Func1<Integer, Observable<String>>() {
                    @Override
                    public Observable<String> call(Integer index) {
                        return Observable.from(mStrList.get(index));
                    }
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: " + s);
                    }
                });
    }

    private void RxJavaSix() {
        String[] strNums = new String[]{"1", "2", "3", "4"};
        Observable.from(strNums)
                .lift(new Observable.Operator<Integer, String>(){
                    @Override
                    public Subscriber<? super String> call(final Subscriber<? super Integer> subscriber) {
                        return new Subscriber<String>() {
                            @Override
                            public void onCompleted() {
                                subscriber.onCompleted();
                            }

                            @Override
                            public void onError(Throwable e) {
                                subscriber.onError(e);
                            }

                            @Override
                            public void onNext(String s) {
                                subscriber.onNext(Integer.parseInt(s));
                            }
                        };
                    }
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "onNext: " + integer * integer);
                    }
                });
    }

    private void RxJavaSeven() {
        class LiftAllTransformer implements Observable.Transformer<Integer, String> {

            @Override
            public Observable<String> call(Observable<Integer> observable) {
                return observable.map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        int result = integer.intValue() * integer.intValue() * integer.intValue();
                        Log.d(TAG, "call: result" + result);
                        return result;
                    }
                }).map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return String.valueOf(integer);
                    }
                });
            }
        }

        Observable.Transformer liftAll = new LiftAllTransformer();
        Integer[] ints = new Integer[]{1, 2, 3};
        Observable.from(ints)
                .compose(liftAll)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: " + s);
                    }
                });
    }

    private void RxJavaEight() {
        Observable.just("hi")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        Toast.makeText(RxJavaActivity.this, "ui", Toast.LENGTH_SHORT).show();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: " + s);
                    }
                });
    }

}
