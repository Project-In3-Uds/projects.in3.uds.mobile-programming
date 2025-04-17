package com.example.metsanouuds;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

 public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
     private Context context;
     private List<Article> articleList;

     public ArticleAdapter(Context context, List<Article> articleList) {
         this.context = context;
         this.articleList = articleList;
     }

     @NonNull
     @Override
     public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.article_item, parent, false);
         return new ArticleViewHolder(view);
     }

     @Override
     public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
         Article article = articleList.get(position);
         holder.imageView.setImageResource(article.getImageResId());
         holder.textViewName.setText(article.getName());
         holder.textViewDescription.setText(article.getDescription());
         holder.textViewQuantity.setText("Quantité : " + article.getQuantity());
         holder.textViewPrice.setText("Prix unitaire : " + article.getPrice() + "$");

         holder.buttonAdd.setOnClickListener(v -> {
             article.setQuantity(article.getQuantity() + 1);
             holder.textViewQuantity.setText("Quantité : " + article.getQuantity());
         });

         holder.buttonRemove.setOnClickListener(v -> {
             if (article.getQuantity() > 0) {
                 article.setQuantity(article.getQuantity() - 1);
                 holder.textViewQuantity.setText("Quantité : " + article.getQuantity());
             }
         });

         // Gestion du clic sur l'article
         holder.itemView.setOnClickListener(v -> {
             Intent intent = new Intent(context, ArticleDetailActivity.class);
             intent.putExtra("image", article.getImageResId());
             intent.putExtra("description", article.getDescription());
             intent.putExtra("quantity", article.getQuantity());
             intent.putExtra("price", article.getPrice());
             context.startActivity(intent);
         });

     }

     @Override
     public int getItemCount() {
         return articleList.size();
     }

     public static class ArticleViewHolder extends RecyclerView.ViewHolder {
         public ImageView imageView;
         public TextView textViewName;
         public TextView textViewDescription;
         public TextView textViewQuantity;
         public TextView textViewPrice;
         Button buttonAdd, buttonRemove;

         public ArticleViewHolder(@NonNull View itemView){
             super(itemView);

             imageView = itemView.findViewById(R.id.articleImage);
             textViewName = itemView.findViewById(R.id.articleName);
             textViewDescription = itemView.findViewById(R.id.articleDescription);
             textViewQuantity = itemView.findViewById(R.id.articleQuantity);
             textViewPrice = itemView.findViewById(R.id.textViewPrice);
             buttonAdd = itemView.findViewById(R.id.buttonAdd);
             buttonRemove = itemView.findViewById(R.id.buttonRemove);
         }
     }

 }