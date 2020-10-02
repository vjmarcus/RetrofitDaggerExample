package com.example.retrofitdaggerexample.di.modules;

import android.util.Log;

import com.example.retrofitdaggerexample.network.NewsApi;
import com.example.retrofitdaggerexample.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NewsApiModule {

    @Provides
    @Singleton
    Retrofit provideRetrofitInstance() {
        Log.d(Constants.TAG, "provideRetrofitInstance: created");
        return new Retrofit.Builder()
                .baseUrl(Constants.TEST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    NewsApi provideNewsApi(Retrofit retrofit) {
        Log.d(Constants.TAG, "provideNewsApi: created");
        return retrofit.create(NewsApi.class);
    }
}
