package com.example.smartlinechart;

import android.app.Application;
import android.content.Context;

import com.example.linechartlibrary.MyApp;

public class MyApplication extends Application {

    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this.getApplicationContext();
        MyApp.setInstance(applicationContext);
    }

    public static Context getInstance(){
        return applicationContext;
    }
}
