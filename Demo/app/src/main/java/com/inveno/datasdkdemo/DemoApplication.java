package com.inveno.datasdkdemo;

import android.app.Application;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 一般而言，应在Application中初始化SDK，但也可延迟到调用第一次请求数据之前
        // 初始化DataSDK
        // DataSDKWrapper.init(this);
    }
}
