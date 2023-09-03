package com.example.chatapps.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.chatapps.repostory.ArticleRepo;
import com.example.chatapps.respons.MainRespons;
import com.example.chatapps.respons.TopMainArticleRespons;

public class MainViewModel extends AndroidViewModel {

    private ArticleRepo articleRepo;
    private LiveData<MainRespons> mainResponsLiveData;
    private LiveData<TopMainArticleRespons> topMainArticleRespons;

    public MainViewModel(@NonNull Application application) {
        super(application);

        articleRepo = new ArticleRepo();
        this.mainResponsLiveData= articleRepo.getTopHeadlineUs();
        this.topMainArticleRespons= articleRepo.getTopArticle();

    }
    public LiveData<MainRespons> getHomeScreenData(){
        return mainResponsLiveData;
    }
    public LiveData<TopMainArticleRespons> getTopMainArticleRespons(){
        return topMainArticleRespons;
    }
}
