package com.sahan.csd71app.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sahan.csd71app.R;
import com.sahan.csd71app.adapter.MoviesRecyclerViewAdapter;
import com.sahan.csd71app.dao.MoviesAsyncTask;
import com.sahan.csd71app.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class MoviesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.moviesRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration divider = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);

        MoviesAsyncTask moviesAsyncTask = new MoviesAsyncTask();
        List<Movie> movieList = new ArrayList<>();
        try {
           movieList = moviesAsyncTask.execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        MoviesRecyclerViewAdapter adapter = new MoviesRecyclerViewAdapter(getContext(), movieList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}