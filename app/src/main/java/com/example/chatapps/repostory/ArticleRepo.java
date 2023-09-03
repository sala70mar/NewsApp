package com.example.chatapps.repostory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.chatapps.api.ApiRequestInterface;
import com.example.chatapps.api.RetrofitClient;
import com.example.chatapps.respons.MainRespons;
import com.example.chatapps.respons.TopMainArticleRespons;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepo {

    private final ApiRequestInterface apiRequestInterface;

    public ArticleRepo() {
        apiRequestInterface = RetrofitClient.getRetrofit().create(ApiRequestInterface.class);
    }
    public LiveData<MainRespons> getTopHeadlineUs(){
        final MutableLiveData<MainRespons> data = new MutableLiveData<>();
        apiRequestInterface.getTopHeadline().enqueue(new Callback<MainRespons>() {
            @Override
            public void onResponse(Call<MainRespons> call, Response<MainRespons> response) {

                if (response.body() != null){
                    data.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<MainRespons> call, Throwable t) {

                data.setValue(null);

            }
        });

        return data;
    }
    public LiveData<TopMainArticleRespons> getTopArticle(){
        final MutableLiveData<TopMainArticleRespons> data = new MutableLiveData<>();
        apiRequestInterface.getTopArticle().enqueue(new Callback<TopMainArticleRespons>() {
            @Override
            public void onResponse(Call<TopMainArticleRespons> call, Response<TopMainArticleRespons> response) {

                if (response.body() != null){
                    data.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<TopMainArticleRespons> call, Throwable t) {

                data.setValue(null);

            }
        });

        return data;
    }
}
