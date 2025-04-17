package com.example.metsanouuds;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView1 = findViewById(R.id.articleRecyclerView);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        //ajouter les articles dans la liste
        List<Article> articleList = new ArrayList<>();
        articleList.add(new Article(R.drawable.banane, "Banane Fraiche", "Description 1", 1, 4));
        articleList.add(new Article(R.drawable.pomme, "Pomme de France", "Description 2", 3, 7));
        articleList.add(new Article(R.drawable.jrr_tolkien, "Le Seigneur des Anneaux", "Description 2", 3, 7));


        ArticleAdapter adapter = new ArticleAdapter(this, articleList);
        recyclerView1.setAdapter(adapter);
    }
}
