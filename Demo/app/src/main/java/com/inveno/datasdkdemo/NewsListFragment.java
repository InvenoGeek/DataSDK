package com.inveno.datasdkdemo;

import java.util.List;

import com.inveno.datasdk.XZSDKManager;
import com.inveno.datasdk.callback.GetNewsListCallback;
import com.inveno.datasdk.callback.GetUidCallback;
import com.inveno.datasdk.model.News;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class NewsListFragment extends Fragment {

    private static final String SCENARIO = "SCENARIO";

    private String scenario;

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView       newsRV;
    private NewsListAdapter    newsListAdapter;

    public static NewsListFragment newInstance(String scenario) {
        Bundle args = new Bundle();
        args.putString(SCENARIO, scenario);
        NewsListFragment fragment = new NewsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scenario = getArguments().getString(SCENARIO);
        newsListAdapter = new NewsListAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_list_fragment, container, false);

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout);
        newsRV = (RecyclerView) view.findViewById(R.id.newsRV);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        newsRV.setLayoutManager(layoutManager);

        newsRV.setAdapter(newsListAdapter);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                refresh();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // 列表进入
        DataSDKWrapper.onListEnter(getContext().getApplicationContext(), scenario);
    }

    @Override
    public void onPause() {
        super.onPause();
        // 列表退出. 上报列表时长
        DataSDKWrapper.onListExit(getContext().getApplicationContext(), scenario);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 初始化DataSDK
        DataSDKWrapper.init(getContext().getApplicationContext());

        XZSDKManager.addGetUidListener(new GetUidCallback() {

            @Override
            public void onReady(@NonNull String uid) {
                refresh();
            }
        });
    }

    private void refresh() {
        setRefreshing(true);

        DataSDKWrapper.listRefresh(getContext().getApplicationContext(), scenario, 3, new GetNewsListCallback() {

            @Override
            public void onSuccess(List<News> list) {
                if (!isAdded()) {
                    return;
                }

                setRefreshing(false);

                if (list.size() == 0) {
                    Toast.makeText(getContext(), "No more data", Toast.LENGTH_SHORT).show();
                } else {
                    newsListAdapter.replaceData(list);
                }
            }

            @Override
            public void onFailed(String s) {
                if (!isAdded()) {
                    return;
                }

                setRefreshing(false);
            }
        });
    }

    public void setRefreshing(final boolean refreshing) {
        refreshLayout.post(new Runnable() {

            @Override
            public void run() {
                refreshLayout.setRefreshing(refreshing);
            }
        });
    }
}
