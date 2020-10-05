package com.example.retrofitdaggerexample;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofitdaggerexample.model.Post;
import com.example.retrofitdaggerexample.model.Story;
import com.example.retrofitdaggerexample.model.StoryResponse;
import com.example.retrofitdaggerexample.network.NewsApi;
import com.example.retrofitdaggerexample.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
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
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        App.getAppComponent().injectMainActivity(this);
        textView = findViewById(R.id.textView);
        textView.setText("Hello");

        Observable<StoryResponse> observable = newsApi.getPostsByDate(Constants.KEY, Constants.getCurrentDate(),
                Constants.getCurrentDate(), 20, "en", Constants.API_KEY);
        observable
                .subscribeOn(Schedulers.io())
                .flatMapIterable(new Function<StoryResponse, Iterable<Story>>() {
                    @Override
                    public Iterable<Story> apply(StoryResponse storyResponse) throws Exception {
                        return storyResponse.getArticles();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Story>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Story story) {
                        Log.d(TAG, "onNext: " + story.getAuthor());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });




    }
}