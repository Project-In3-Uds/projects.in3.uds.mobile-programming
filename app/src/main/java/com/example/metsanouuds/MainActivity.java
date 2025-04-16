package com.example.metsanouuds;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Article> articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        articleList = new ArrayList<>();

        articleList.add(new Article(R.drawable.banane, "Bananes fraîches", 3, 15));

        ArticleAdapter adapter = new ArticleAdapter(this, articleList);
        listView.setAdapter(adapter);
    }
}
