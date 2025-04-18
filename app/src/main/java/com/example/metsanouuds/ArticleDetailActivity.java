package com.example.metsanouuds;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ArticleDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        ImageView image = findViewById(R.id.detailImage);
        TextView desc = findViewById(R.id.detailDescription);
        TextView qty = findViewById(R.id.detailQuantity);
        TextView price = findViewById(R.id.detailPrice);
        TextView total = findViewById(R.id.detailTotal);

        Intent intent = getIntent();
        int imgRes = intent.getIntExtra("image", 0);
        String description = intent.getStringExtra("description");
        int quantity = intent.getIntExtra("quantity", 0);
        int priceUnit = intent.getIntExtra("price", 0);

        image.setImageResource(imgRes);
        desc.setText(description);
        qty.setText("Quantité: " + quantity);
        price.setText("Prix unitaire: " + priceUnit + "$");
        total.setText("Prix total: " + (quantity * priceUnit) + "$");
    }
}
