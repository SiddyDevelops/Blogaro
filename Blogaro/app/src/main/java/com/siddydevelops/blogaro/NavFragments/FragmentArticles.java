package com.siddydevelops.blogaro.NavFragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siddydevelops.blogaro.R;
import com.siddydevelops.blogaro.RecyclerViewAdapters.BlogRVAdapter;

public class FragmentArticles extends Fragment {

    Context context;

    RecyclerView blogRecyclerView;
    String[] heading = {"Heading","Heading","Heading"};
    String[] subHeading = {"SubHeading","SubHeading","SubHeading"};

    public FragmentArticles() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_articles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        blogRecyclerView = view.findViewById(R.id.blogRecyclerView);
        blogRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        blogRecyclerView.setAdapter(new BlogRVAdapter(heading,subHeading));
    }
}