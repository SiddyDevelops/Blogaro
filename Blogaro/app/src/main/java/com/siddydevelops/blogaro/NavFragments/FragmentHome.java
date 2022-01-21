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

import com.mig35.carousellayoutmanager.CarouselLayoutManager;
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.mig35.carousellayoutmanager.CenterScrollListener;
import com.siddydevelops.blogaro.R;
import com.siddydevelops.blogaro.RecyclerViewAdapters.BlogRVAdapter;
import com.siddydevelops.blogaro.RecyclerViewAdapters.TopicRVAdapter;

public class FragmentHome extends Fragment {

    RecyclerView topicRecyclerView;
    String[] topicText = {"Technology","Technology","Technology"};
    Context context;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        topicRecyclerView = view.findViewById(R.id.topicRecyclerView);

        final CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        topicRecyclerView.setLayoutManager(layoutManager);
        topicRecyclerView.setHasFixedSize(true);
        topicRecyclerView.setAdapter(new TopicRVAdapter(topicText));
        topicRecyclerView.addOnScrollListener(new CenterScrollListener());

//        topicRecyclerView.setLayoutManager(new LinearLayoutManager(context));
//        topicRecyclerView.setAdapter(new TopicRVAdapter(topicText));

    }
}