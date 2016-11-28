DataSDK
=====

[ ![Download](https://api.bintray.com/packages/invenogeek/maven/data-sdk/images/download.svg?version=1.0.0) ](https://bintray.com/invenogeek/maven/data-sdk/1.0.0/link)

依赖
--------
Gradle：

```gradle
repositories {
  jcenter() 
}

dependencies {
  compile 'com.github.bumptech.glide:glide:3.7.0'
  compile 'com.android.support:support-v4:19.1.0'
}
```

Maven：

```xml
<dependency>
  <groupId>com.inveno</groupId>
  <artifactId>datasdk</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

接入步骤
--------
1. 申请product_id、scenario列表、APP_KEY、APP_SECRET
2. 初始化SDK
3. （可选）更改host或app_lan
3. 调用下发接口请求数据
4. 调用上报接口上报事件

申请product_id、scenario列表、APP_KEY、APP_SECRET
--------
向英威诺申请

初始化SDK
--------
* SDK初始化应在调用任何下发或上报数据接口之前
* 典型的，SDK初始化应在Application的onCreate方法中 
* 参见Javadoc中*XZSDKManager*

调用下发接口请求数据
-------
参见Javadoc中*XZDataAgent*

调用上报接口上报事件
--------
参见Javadoc中*XZReportAgent*




