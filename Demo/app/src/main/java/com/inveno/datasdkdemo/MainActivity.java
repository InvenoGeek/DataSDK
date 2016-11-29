package com.inveno.datasdkdemo;

import com.inveno.datasdk.constant.Scenario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewsListFragment fragment = (NewsListFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (fragment == null) {
            fragment = NewsListFragment.newInstance(Scenario.FORYOU);
            getSupportFragmentManager().beginTransaction().add(R.id.contentFrame, fragment).commit();
        }
    }
}
