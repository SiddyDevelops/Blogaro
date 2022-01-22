package com.siddydevelops.blogaro.NavFragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siddydevelops.blogaro.R;
import com.siddydevelops.blogaro.RecyclerViewAdapters.TopicRVAdapter;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

public class FragmentHome extends Fragment {

    RecyclerView topicRecyclerView;
    String[] topicText = {"Technology","Science","Medicine","Education","Entertainment","Sports"};
    Context context;
    DiscreteScrollView scrollView;

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

        //topicRecyclerView = view.findViewById(R.id.topicRecyclerView);
        scrollView = view.findViewById(R.id.discreteSV);

        scrollView.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.0f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                .build());

        scrollView.setAdapter(new TopicRVAdapter(topicText));
    }
}