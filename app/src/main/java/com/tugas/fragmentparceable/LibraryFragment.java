package com.tugas.fragmentparceable;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment{
    private RecyclerView recyclerViewManga;
    private MangaRecyclerAdapter adapter;
    private final List<MangaModel> models = new ArrayList<>();

    public static Fragment newInstance() {
        LibraryFragment fragment = new LibraryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_library, container, false);

        adapter = new MangaRecyclerAdapter(models);
        recyclerViewManga = view.findViewById(R.id.rv_manga);
        models.addAll(MangaDatabase.getListData());

        adapter.setOnItemClickCallback(new MangaRecyclerAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(MangaModel data) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("MANGA_DETAIL", data);
                startActivity(intent);
            }
        });

        recyclerViewManga.setHasFixedSize(true);
        recyclerViewManga.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewManga.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
