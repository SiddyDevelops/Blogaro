package com.siddydevelops.blogaro;

import android.app.Dialog;
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

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    TextView bottomSheetHeading;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_bottom_sheet,container,false);
        bottomSheetHeading = view.findViewById(R.id.bottomSheetHeading);

        switch(Objects.requireNonNull(getTag())) {
            case "BottomSheetPost":
                bottomSheetHeading.setText(R.string.post);
                break;
            case "BottomSheetPostFollowing":
                bottomSheetHeading.setText(R.string.following);
                break;
            case "BottomSheetFollowers":
                bottomSheetHeading.setText(R.string.followers);
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
