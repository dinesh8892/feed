package com.example.feed;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public class BloggerApi {

    private static final String Api_Key = "AIzaSyDnqNoUqO8S8xNK7ZD5t4RpK1Ol5qIlj4c";
    private static final String URL = "https://www.googleapis.com/blogger/v3/blogs/2236704694650395481/posts/";

    public static PostService postService = null;

    public static PostService getService(){

        if (postService == null){
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
                        .build();

                postService = retrofit.create(PostService.class);

        }
        return postService;
    }

    public interface PostService{

        @GET("?key=" + Api_Key)
        Call<PostList> getPostList();

        //@GET("(postId)/?key=" + Api_Key)
        //Call<Item> getPostbyId(@Path("postId") String id);
    }
}
