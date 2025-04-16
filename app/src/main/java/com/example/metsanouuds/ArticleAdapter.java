package com.example.metsanouuds;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ArticleAdapter extends ArrayAdapter<Article> {
    private Context context;
    private List<Article> articleList;

    public ArticleAdapter(Context context, List<Article> list) {
        super(context, 0, list);
        this.context = context;
        this.articleList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Article article = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.article_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.articleImage);
        TextView descriptionView = convertView.findViewById(R.id.articleDescription);
        TextView quantityView = convertView.findViewById(R.id.articleQuantity);
        TextView priceView = convertView.findViewById(R.id.articlePrice);

        imageView.setImageResource(article.getImageResId());
        descriptionView.setText(article.getDescription());
        quantityView.setText("Quantité: " + article.getQuantity());
        priceView.setText("Prix unitaire: " + article.getPrice() + "$");

        // Lorsque l'image est cliquée, on ouvre l'activité des détails
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ArticleDetailActivity.class);
            intent.putExtra("image", article.getImageResId());
            intent.putExtra("description", article.getDescription());
            intent.putExtra("quantity", article.getQuantity());
            intent.putExtra("price", article.getPrice());
            context.startActivity(intent);
        });

        return convertView;
    }
}
