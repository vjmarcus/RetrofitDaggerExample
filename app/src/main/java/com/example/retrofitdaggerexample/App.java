package com.example.retrofitdaggerexample;

import android.app.Application;
import android.util.Log;

import com.example.retrofitdaggerexample.di.components.AppComponent;
import com.example.retrofitdaggerexample.di.components.DaggerAppComponent;
import com.example.retrofitdaggerexample.utils.Constants;


public class App extends Application {

    static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constants.TAG, "onCreate: App ");
        appComponent = DaggerAppComponent.builder()
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
