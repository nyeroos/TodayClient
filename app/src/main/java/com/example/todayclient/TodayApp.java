package com.example.todayclient;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;


public class TodayApp extends Application implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> androidDispatchingInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent();
    }

    private void initializeComponent() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

//    @Override
//    public DispatchingAndroidInjector<Activity> activityInjector() {
//        return dispatchingAndroidInjector;
//    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidDispatchingInjector;
    }
}
