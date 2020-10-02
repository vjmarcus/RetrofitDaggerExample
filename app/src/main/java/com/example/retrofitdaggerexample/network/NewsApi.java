package com.example.retrofitdaggerexample.network;

import com.example.retrofitdaggerexample.model.Post;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("/posts/{id}")
    public Call<Post> getPostWithID(@Path("id") int id);


//    @GET("everything")
//    Observable<StoryResponse> getPostsByDate(@Query("q") String key,
//                                             @Query("from") String fromDate,
//                                             @Query("to") String toDate,
//                                             @Query("pageSize") int pageSize,
//                                             @Query("language") String language,
//                                             @Query("apiKey") String apiKey);
}
