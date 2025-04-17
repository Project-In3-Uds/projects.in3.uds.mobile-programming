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

public class AutresFragment extends Fragment {

    public AutresFragment() {}

    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    private List<Article> articleList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_autres, container, false);

        recyclerView = view.findViewById(R.id.autresRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        articleList = new ArrayList<>();
        articleList.add(new Article(R.drawable.jrr_tolkien, "Seigneur des Anneaux", "Roman épique", 1, 2000));
        articleList.add(new Article(R.drawable.andrezj_sacopski, "The Witcher", "Roman fantastique", 5, 100));

        adapter = new ArticleAdapter(getContext(), articleList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
