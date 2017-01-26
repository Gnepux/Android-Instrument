#Instrumnent
这个工程是Android框架和架构的Demo工程。

##2017.1.17
###1.引入RxJava
```
compile 'io.reactivex:rxjava:1.2.5'
compile 'io.reactivex:rxandroid:1.2.1'
```
###2.引入Dagger2
```
compile 'com.google.dagger:dagger:2.8'
annotationProcessor 'com.google.dagger:dagger-compiler:2.8'
```

##2017.1.18
###1.引入OkHttp3
```
// 依赖okio, 会自动导入okio。
compile 'com.squareup.okhttp3:okhttp:3.5.0'
compile 'com.squareup.okio:okio:1.11.0'
compile 'com.squareup.okhttp3:logging-interceptor:3.5.0'
```
###2.引入Logger
```
compile 'com.orhanobut:logger:1.15'
```
###3.引入Retrofit2
```
// 依赖okhttp, 会自动导入okhttp。
compile 'com.squareup.retrofit2:retrofit:2.1.0'
// 使用Gson转换引入
compile 'com.squareup.retrofit2:converter-gson:2.1.0'
// 使用RxJava需要引入
compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
```
###4.引入Gson
```
compile 'com.google.code.gson:gson:2.8.0'
```

##2017.1.20
###开启DataBinding
build.gradle中加入
```
android {
    ....
    dataBinding {
        enabled = true
    }
}
```

##2017.1.26
###1. 加入Loader(AsyncTaskLoader)相关的例子