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

public class LegumesFragment extends Fragment {

    public LegumesFragment() {}

    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    private List<Article> articleList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_legumes, container, false);

        recyclerView = view.findViewById(R.id.legumesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        articleList = new ArrayList<>();
        articleList.add(new Article(R.drawable.ic_poirot, "Condiments Verts", "Poirot, Haricots verts", 1, 4));
        articleList.add(new Article(R.drawable.ic_choux, "Choux Verts", "Legumes mange crus", 2, 5));
        adapter = new ArticleAdapter(getContext(), articleList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
