package com.example.retrofitdaggerexample;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofitdaggerexample.model.Post;
import com.example.retrofitdaggerexample.network.NewsApi;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";
    private TextView textView;


    @Inject Retrofit retrofit;
    @Inject NewsApi newsApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText("Hello");
        App.getAppComponent().injectMainActivity(this);
        newsApi.getPostWithID(1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();
                Log.d(TAG, "onResponse: " + post.getTitle());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }
}