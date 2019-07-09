package com.example.linechartlibrary;

import android.app.Application;
import android.content.Context;

public class MyApp {
    private static Context applicationContext;
    public static void setInstance(Context context){
        applicationContext = context;
    }

    public static Context getInstance(){
        return applicationContext;
    }
}
