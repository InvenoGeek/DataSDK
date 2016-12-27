package com.inveno.datasdkdemo;

import java.util.Map;

import com.inveno.datasdk.XZDataAgent;
import com.inveno.datasdk.XZReportAgent;
import com.inveno.datasdk.XZSDKManager;
import com.inveno.datasdk.callback.GetNewsListCallback;
import com.inveno.datasdk.constant.AppLanguage;
import com.inveno.datasdk.constant.OpenType;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 包装DataSDK.
 */

public class DataSDKWrapper {

    public static void init(Context applicationContext) {
        // @formatter:off
        XZSDKManager.init(
                applicationContext,
                BuildConfig.PRODUCT_ID,
                BuildConfig.PROMOTION,
                BuildConfig.VERSION_NAME,
                AppLanguage.ENGLISH,
                BuildConfig.COUNTRY_CODE,
                BuildConfig.APP_KEY,
                BuildConfig.APP_SECRET);
        // @formatter:on
    }

    /**
     * 下拉刷新获取资讯列表
     *
     * @param context 上下文
     * @param scenario 场景，联系英威诺获取收支持的场景
     * @param count 数量
     * @param callback 回调
     */
    public static void listRefresh(@NonNull Context context, @NonNull String scenario, int count,
                                   @NonNull GetNewsListCallback callback) {
        XZDataAgent.listRefresh(context, scenario, count, callback);
    }

    /**
     * 上拉加载更多资讯列表
     *
     * @param context 上下文
     * @param scenario 场景，联系英威诺获取收支持的场景
     * @param count 数量
     * @param callback 回调
     */
    public static void listLoadMore(@NonNull Context context, @NonNull String scenario, int count,
                                    @NonNull GetNewsListCallback callback) {
        XZDataAgent.listLoadMore(context, scenario, count, callback);
    }

    /**
     * 列表进入，与{@link #onListExit(Context, String)}配对使用，产生列表时长事件
     *
     * @param scenario 页面场景，16进制整数，如0x010101
     */
    public static void onListEnter(@NonNull Context context, @NonNull String scenario) {
        XZReportAgent.onListEnter(context, scenario);
    }

    /**
     * 列表进入，与{@link #onListExit(Context, String)}配对使用，产生列表时长事件
     *
     * @param scenario 页面场景，16进制整数，如0x010101
     * @param extra 额外数据
     */
    public static void onListEnter(@NonNull Context context, @NonNull String scenario, @Nullable Map<String, String> extra) {
        XZReportAgent.onListEnter(context, scenario, extra);
    }

    /**
     * 列表退出，与{@link #onListEnter(Context, String)}配对使用，产生列表时长事件
     *
     * @param scenario 页面场景，16进制整数，如0x010101
     */
    public static void onListExit(@NonNull Context context, @NonNull String scenario) {
        XZReportAgent.onListExit(context, scenario);
    }

    /**
     * 产生内容条目展现事件，需要去重
     *
     * @param scenario 页面场景，16进制整数，如0x010101
     * @param contentId 资讯id
     * @param cpack 服务端下发的自定义内容信息
     * @param serverTime 服务端下发内容时的服务端时间戳
     * @param fromContentId 来源资讯id，没有则传null
     * @param fromContentType 来源资讯类型，没有则传null
     * @see #onItemShow(Context, String, String, String, long, String, String, Map, boolean)
     */
    public static void onItemShow(@NonNull Context context, @NonNull String scenario, @NonNull String contentId,
                                  @NonNull String cpack, long serverTime, @Nullable String fromContentId,
                                  @Nullable String fromContentType) {
        XZReportAgent.onItemShow(context, scenario, contentId, cpack, serverTime, fromContentId, fromContentType);
    }

    /**
     * 产生内容条目展现事件，需要去重
     *
     * @param scenario 页面场景，16进制整数，如0x010101
     * @param contentId 资讯id
     * @param cpack 服务端下发的自定义内容信息
     * @param serverTime 服务端下发内容时的服务端时间戳
     * @param fromContentId 来源资讯id，没有则传null
     * @param fromContentType 来源资讯类型，没有则传null
     * @param extra 额外数据
     * @see #onItemShow(Context, String, String, String, long, String, String, Map, boolean)
     */
    public static void onItemShow(@NonNull Context context, @NonNull String scenario, @NonNull String contentId,
                                  @NonNull String cpack, long serverTime, @Nullable String fromContentId,
                                  @Nullable String fromContentType, @Nullable Map<String, String> extra) {
        XZReportAgent.onItemShow(context, scenario, contentId, cpack, serverTime, fromContentId, fromContentType, extra);
    }

    /**
     * 产生内容条目展现事件
     *
     * @param scenario 页面场景，16进制整数，如0x010101
     * @param contentId 资讯id
     * @param cpack 服务端下发的自定义内容信息
     * @param serverTime 服务端下发内容时的服务端时间戳
     * @param fromContentId 来源资讯id，没有则传null
     * @param fromContentType 来源资讯类型，没有则传null
     * @param extra 额外数据
     * @param deDuplicate 是否去重
     */
    public static void onItemShow(@NonNull Context context, @NonNull String scenario, @NonNull String contentId,
                                  @NonNull String cpack, long serverTime, @Nullable String fromContentId,
                                  @Nullable String fromContentType, @Nullable Map<String, String> extra, boolean deDuplicate) {
        XZReportAgent.onItemShow(context, scenario, contentId, cpack, serverTime, fromContentId, fromContentType, extra,
                                 deDuplicate);
    }

    /**
     * 产生内容条目点击事件，需要去重
     *
     * @param scenario 页面场景，16进制整数，如0x010101
     * @param contentId 资讯id
     * @param cpack 服务端下发的自定义内容信息
     * @param openType 跳转类型
     * @param fromContentId 来源资讯id，没有则传null
     * @param fromContentType 来源资讯类型，没有则传null
     * @see #onItemClick(Context, String, String, String, String, String, String, Map, boolean)
     */
    public static void onItemClick(@NonNull Context context, @NonNull String scenario, @NonNull String contentId,
                                   @NonNull String cpack, @OpenType String openType, @Nullable String fromContentId,
                                   @Nullable String fromContentType) {
        XZReportAgent.onItemClick(context, scenario, contentId, cpack, openType, fromContentId, fromContentType);
    }

    /**
     * 产生内容条目点击事件，需要去重
     *
     * @param scenario 页面场景，16进制整数，如0x010101
     * @param contentId 资讯id
     * @param cpack 服务端下发的自定义内容信息
     * @param openType 跳转类型
     * @param fromContentId 来源资讯id，没有则传null
     * @param fromContentType 来源资讯类型，没有则传null
     * @param extra 额外数据
     * @see #onItemClick(Context, String, String, String, String, String, String, Map, boolean)
     */
    public static void onItemClick(@NonNull Context context, @NonNull String scenario, @NonNull String contentId,
                                   @NonNull String cpack, @OpenType String openType, @Nullable String fromContentId,
                                   @Nullable String fromContentType, @Nullable Map<String, String> extra) {
        XZReportAgent.onItemClick(context, scenario, contentId, cpack, openType, fromContentId, fromContentType, extra);
    }

    /**
     * 产生内容条目点击事件
     *
     * @param scenario 页面场景，16进制整数，如0x010101
     * @param contentId 资讯id
     * @param cpack 服务端下发的自定义内容信息
     * @param openType 跳转类型
     * @param fromContentId 来源资讯id，没有则传null
     * @param fromContentType 来源资讯类型，没有则传null
     * @param extra 额外数据
     * @param deDuplicate 是否去重
     */
    public static void onItemClick(@NonNull Context context, @NonNull String scenario, @NonNull String contentId,
                                   @NonNull String cpack, @OpenType String openType, @Nullable String fromContentId,
                                   @Nullable String fromContentType, @Nullable Map<String, String> extra, boolean deDuplicate) {
        XZReportAgent.onItemClick(context, scenario, contentId, cpack, openType, fromContentId, fromContentType, extra,
                                  deDuplicate);
    }
}
