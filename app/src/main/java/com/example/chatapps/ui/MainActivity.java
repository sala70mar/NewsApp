package com.example.chatapps.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.chatapps.R;
import com.example.chatapps.adapter.TopArticleAdapter;
import com.example.chatapps.adapter.TopHeadlineAdapter;
import com.example.chatapps.models.Article;
import com.example.chatapps.models.TopArticle;
import com.example.chatapps.viewModel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView,recyclerView2;
    List<Article> articleList;
    List<TopArticle> topArticlesList;
    MainViewModel mainViewModel;
    TopHeadlineAdapter adapter;
    TopArticleAdapter adapter2;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.spin_kit);


        initialize();

        getNews();

        getTopArticlenews();
    }

    private void getTopArticlenews() {

        mainViewModel.getTopMainArticleRespons().observe(this,mainRespons -> {
            if (mainRespons!= null && mainRespons.getArticles()!= null &&
                    ! mainRespons.getArticles().isEmpty()){

                List<TopArticle> TopArticle = mainRespons.getArticles();
                topArticlesList.addAll(TopArticle);
                adapter2.notifyDataSetChanged();
            }
        });


    }

    private void getNews() {
        mainViewModel.getHomeScreenData().observe(this,mainRespons -> {
            if (mainRespons!= null && mainRespons.getArticles()!= null &&
            ! mainRespons.getArticles().isEmpty()){

                List<Article> articles = mainRespons.getArticles();
                articleList.addAll(articles);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
        });

    }

    private void initialize() {
        recyclerView=findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);

        recyclerView2=findViewById(R.id.rec2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView2.setHasFixedSize(true);

        articleList = new ArrayList<>();
        adapter = new TopHeadlineAdapter(articleList,this);
        recyclerView.setAdapter(adapter);

        topArticlesList = new ArrayList<>();
        adapter2 = new TopArticleAdapter(topArticlesList,this);
        recyclerView2.setAdapter(adapter2);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }
}