package com.siddydevelops.blogaro.NavFragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.siddydevelops.blogaro.MainDashboard;
import com.siddydevelops.blogaro.R;
import com.siddydevelops.blogaro.RecyclerViewAdapters.BlogRVAdapter;

public class FragmentArticles extends Fragment {

    Context context;
    ImageView backIV;
    RecyclerView blogRecyclerView;
    String[] heading = {"Android Cold Start and Buffer Screen","Android Cold Start and Buffer Screen","Android Cold Start and Buffer Screen"};
    String[] subHeading = {"Create an efficient splash screen","Create an efficient splash screen","Create an efficient splash screen"};

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
        backIV = view.findViewById(R.id.backIV);

        blogRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        blogRecyclerView.setAdapter(new BlogRVAdapter(heading,subHeading));

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainDashboard.class);
                startActivity(intent);
            }
        });
    }
}