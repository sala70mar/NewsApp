package com.example.chatapps.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chatapps.R;
import com.example.chatapps.models.Article;
import com.example.chatapps.models.TopArticle;
import com.makeramen.roundedimageview.RoundedImageView;

public class DetailsActivity2 extends AppCompatActivity {

    Article article = null;
    TopArticle article2 = null;
    TextView title, desc, author, content, publishAt;
    RoundedImageView detImage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);

        detImage = findViewById(R.id.det_img);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.dec);
        author = findViewById(R.id.authr);
        content = findViewById(R.id.content);
        publishAt = findViewById(R.id.publish_at);


        final  Object object = getIntent().getSerializableExtra("newsData");
        final  Object object2 = getIntent().getSerializableExtra("articleData");

        if (object instanceof Article){
            article = (Article) object;

        }

        if (object2 instanceof TopArticle){
            article2 = (TopArticle) object2;

        }



        if (article != null){
            Glide.with(getApplicationContext()).load(article.getUrlToImage()).into(detImage);
            title.setText(article.getTitle());
            desc.setText(article.getDescription());
            author.setText(article.getSource().getName());
            content.setText(article.getContent());
            publishAt.setText(article.getPublishedAt());
        }
        if (article2 != null){
            Glide.with(getApplicationContext()).load(article2.getUrlToImage()).into(detImage);
            title.setText(article2.getTitle());
            desc.setText(article2.getDescription());
            author.setText(article2.getSource().getName());
            content.setText(article2.getContent());
            publishAt.setText(article2.getPublishedAt());
        }


//        final  Object object2 = getIntent().getSerializableExtra("articleData");
////
//        if (object2 instanceof Article){
//            article2 = (Article) object2;
//
//        }
//
//        if (article2 != null){
//            Glide.with(getApplicationContext()).load(article2.getUrlToImage()).into(detImage);
//            title.setText(article2.getTitle());
//            desc.setText(article2.getDescription());
//            author.setText(article2.getSource().getName());
//            content.setText(article2.getContent());
//            publishAt.setText(article2.getPublishedAt());
//        }


    }
}