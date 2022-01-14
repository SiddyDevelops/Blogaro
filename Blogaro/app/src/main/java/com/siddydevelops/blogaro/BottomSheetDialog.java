package com.siddydevelops.blogaro;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.siddydevelops.blogaro.RecyclerViewAdapters.FollRVAdapter;
import com.siddydevelops.blogaro.RecyclerViewAdapters.ProfileRVAdapter;

import java.util.Objects;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    TextView bottomSheetHeading;
    RecyclerView profile_rv;
    Context context;

    String[] titles = {"Big Data", "UX Design", "Big Data", "UX Design", "Big Data", "UX Design"};
    String[] subTitles = {"Why Big Data Needs Thick Data?", "Step Design sprint for UX beginner", "Why Big Data Needs Thick Data?", "Step Design sprint for UX beginner","Why Big Data Needs Thick Data?", "Step Design sprint for UX beginner"};
    String[] userID = {"@SiddyDevelops","@SiddyDevelops","@SiddyDevelops"};
    String[] userName = {"Siddharth Singh","Siddharth Singh","Siddharth Singh"};
    String[] userSpec = {"Android Developer","Android Developer","Android Developer"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_bottom_sheet,container,false);
        bottomSheetHeading = view.findViewById(R.id.bottomSheetHeading);
        profile_rv = view.findViewById(R.id.bottomSheetRV);
        profile_rv.setLayoutManager(new LinearLayoutManager(context));

        switch(Objects.requireNonNull(getTag())) {
            case "BottomSheetPost":
                bottomSheetHeading.setText(R.string.post);
                profile_rv.setAdapter(new ProfileRVAdapter(titles, subTitles));
                break;
            case "BottomSheetPostFollowing":
                bottomSheetHeading.setText(R.string.following);
                profile_rv.setAdapter(new FollRVAdapter(userID,userName,userSpec));
                break;
            case "BottomSheetFollowers":
                bottomSheetHeading.setText(R.string.followers);
                profile_rv.setAdapter(new FollRVAdapter(userID,userName,userSpec));
                break;
            default:
                bottomSheetHeading.setText(R.string.app_name);
        }
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        return dialog;
    }
}
