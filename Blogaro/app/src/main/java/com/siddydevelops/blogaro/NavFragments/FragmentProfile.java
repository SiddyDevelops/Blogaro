package com.siddydevelops.blogaro.NavFragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siddydevelops.blogaro.BottomSheetDialog;
import com.siddydevelops.blogaro.R;

public class FragmentProfile extends Fragment {

    CardView postBTN;
    CardView followingBTN;
    CardView followersBTN;

//    RecyclerView programingList = findViewById(R.id.programingList);
//
//        programingList.setLayoutManager(new LinearLayoutManager(this));
//    String[] languages = {"Java","JavaScript","C#","PHP","C","C++","Python","Java","JavaScript","C#","PHP","C","C++","Python"};
//        programingList.setAdapter(new RecyclerviewAdapter(languages));

    public FragmentProfile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        postBTN = view.findViewById(R.id.postBTN);
        followingBTN = view.findViewById(R.id.followingBTN);
        followersBTN = view.findViewById(R.id.followersBTN);
        postBTN.setBackgroundColor(getResources().getColor(R.color.blue_off));

        postBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postBTN.setBackgroundColor(getResources().getColor(R.color.blue_on));
                followingBTN.setBackgroundColor(getResources().getColor(R.color.blue_off));
                followersBTN.setBackgroundColor(getResources().getColor(R.color.blue_off));
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog();
                bottomSheetDialog.show(getActivity().getSupportFragmentManager(), "BottomSheetPost");
            }
        });

        followingBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postBTN.setBackgroundColor(getResources().getColor(R.color.blue_off));
                followingBTN.setBackgroundColor(getResources().getColor(R.color.blue_on));
                followersBTN.setBackgroundColor(getResources().getColor(R.color.blue_off));
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog();
                bottomSheetDialog.show(getActivity().getSupportFragmentManager(), "BottomSheetPostFollowing");
            }
        });

        followersBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postBTN.setBackgroundColor(getResources().getColor(R.color.blue_off));
                followingBTN.setBackgroundColor(getResources().getColor(R.color.blue_off));
                followersBTN.setBackgroundColor(getResources().getColor(R.color.blue_on));
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog();
                bottomSheetDialog.show(getActivity().getSupportFragmentManager(), "BottomSheetFollowers");
            }
        });

    }

    public void openBottomSheet()
    {

    }

}