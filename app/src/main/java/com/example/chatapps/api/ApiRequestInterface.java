package com.example.chatapps.api;

import static com.example.chatapps.constant.AppConstant.API_KEY;

import com.example.chatapps.respons.MainRespons;
import com.example.chatapps.respons.TopMainArticleRespons;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequestInterface {

    @GET("top-headlines?country=us&category=business&apiKey="+API_KEY)
    Call<MainRespons> getTopHeadline();

    @GET("everything?domains=wsj.com&apiKey="+API_KEY)
    Call<TopMainArticleRespons> getTopArticle();

}
