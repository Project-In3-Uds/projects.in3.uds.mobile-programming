package com.example.metsanouuds;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    private List<Article> articleList;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.homeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        articleList = new ArrayList<>();
        articleList.add(new Article(R.drawable.banane, "Bananes fraîches", "Fruits jaunes", 1, 4));
        articleList.add(new Article(R.drawable.pomme, "Pommes rouges", "Fruits croquants", 2, 5));
        articleList.add(new Article(R.drawable.jrr_tolkien, "Seigneur des Anneaux", "Roman épique", 1, 10));
        articleList.add(new Article(R.drawable.ic_poirot, "Condiments Verts", "Poirot, Haricots verts", 1, 4));
        articleList.add(new Article(R.drawable.ic_choux, "Choux Verts", "Legumes mange crus", 2, 5));
        articleList.add(new Article(R.drawable.andrezj_sacopski, "The Witcher", "Roman fantastique", 5, 100));

        adapter = new ArticleAdapter(getContext(), articleList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
