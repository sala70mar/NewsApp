package com.example.chatapps.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chatapps.R;
import com.example.chatapps.models.TopArticle;
import com.example.chatapps.ui.DetailsActivity2;

import java.util.List;

public class TopArticleAdapter extends RecyclerView.Adapter<TopArticleAdapter.ViewHolder> {

    List<TopArticle> list;
    Context context;

    public TopArticleAdapter(List<TopArticle> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.latest_news_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context)
                .load(list.get(position).getUrlToImage()).into(holder.imageView);

        holder.title.setText(list.get(position).getTitle());
        holder.publishAt.setText(list.get(position).getPublishedAt());
        holder.description.setText(list.get(position).getDescription());
        holder.name.setText(list.get(position).getSource().getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity2.class);
                intent.putExtra("articleData",list.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, publishAt, description, name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            publishAt = itemView.findViewById(R.id.publish_date);
            description = itemView.findViewById(R.id.des);
            name = itemView.findViewById(R.id.name);

        }
    }
}
