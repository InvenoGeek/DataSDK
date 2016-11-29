package com.inveno.datasdkdemo;

import com.inveno.datasdk.XZSDKManager;
import com.inveno.datasdk.constant.AppLanguage;

import android.app.Application;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化DataSDK
        initDataSDK();
    }

    private void initDataSDK() {
        // @formatter:off
        XZSDKManager.init(
                this,
                BuildConfig.PRODUCT_ID,
                BuildConfig.PROMOTION,
                BuildConfig.VERSION_NAME,
                AppLanguage.UNKNOWN,
                BuildConfig.COUNTRY_CODE,
                BuildConfig.APP_KEY,
                BuildConfig.APP_SECRET);
        // @formatter:on
    }
}
