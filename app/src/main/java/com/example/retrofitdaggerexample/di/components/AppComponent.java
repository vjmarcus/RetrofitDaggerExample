package com.example.retrofitdaggerexample.di.components;

import com.example.retrofitdaggerexample.MainActivity;
import com.example.retrofitdaggerexample.di.modules.NewsApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Component (modules = {NewsApiModule.class})
@Singleton
public interface AppComponent {
    void injectMainActivity(MainActivity mainActivity);
}

