package com.siddydevelops.blogaro;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialogSplash extends BottomSheetDialogFragment {

    AppCompatButton loginButton;
    TextView loginText;
    TextView signupText;
    TextView headingTV;
    TextView subHeadingTV;
    TextView confirmPassTV;
    EditText confirmPassET;
    TextView forgetPassTV;
    TextView or_signupTV;
    TextView tcTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_bottom_sheet,container,false);

        loginButton = (AppCompatButton) view.findViewById(R.id.loginButton);
        loginText = view.findViewById(R.id.loginTV);
        signupText = view.findViewById(R.id.sigupTV);
        headingTV = view.findViewById(R.id.headingTV);
        subHeadingTV = view.findViewById(R.id.subHeadingTV);
        confirmPassTV = view.findViewById(R.id.confirmPassTV);
        confirmPassET = view.findViewById(R.id.confirmPassET);
        forgetPassTV = view.findViewById(R.id.forgetPassTV);
        or_signupTV = view.findViewById(R.id.or_signupTV);
        tcTV = view.findViewById(R.id.tcTV);

        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginButton.setText(R.string.login);
                loginText.setAlpha(1f);
                signupText.setAlpha(0.5f);
                headingTV.setText(R.string.welcome_back);
                subHeadingTV.setText(R.string.sign_in_with_your_account);
                confirmPassTV.setVisibility(View.GONE);
                confirmPassET.setVisibility(View.GONE);
                forgetPassTV.setVisibility(View.VISIBLE);
                or_signupTV.setText(R.string.sign_in_with);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(0,220,0,100);
                params.gravity = Gravity.CENTER;
                tcTV.setLayoutParams(params);
            }
        });

        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginButton.setText("Register");
                loginText.setAlpha(0.5f);
                signupText.setAlpha(1f);
                headingTV.setText("Welcome Aboard");
                subHeadingTV.setText("Create a new account");
                confirmPassTV.setVisibility(View.VISIBLE);
                confirmPassET.setVisibility(View.VISIBLE);
                forgetPassTV.setVisibility(View.GONE);
                or_signupTV.setText("OR SIGN UP WITH");
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(0,50,0,50);
                params.gravity = Gravity.CENTER;
                tcTV.setLayoutParams(params);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainDashboard.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        return dialog;
    }
}
