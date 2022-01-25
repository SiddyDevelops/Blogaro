package com.siddydevelops.blogaro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    TextView tittleTV;
    TextView taglineTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        taglineTV = findViewById(R.id.taglineTextView);
        tittleTV = findViewById(R.id.titleTextView);

        CountDownTimer countDownTimer = new CountDownTimer(2000,100) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
//                Intent intent = new Intent(getApplicationContext(), MainDashboard.class);
//                startActivity(intent);
//                finish();

                tittleTV.animate().y(30f).setDuration(2000);
                taglineTV.setVisibility(View.GONE);

                BottomSheetDialogSplash bottomSheetDialogSplash = new BottomSheetDialogSplash();
                bottomSheetDialogSplash.show(getSupportFragmentManager(),"BottomSheetDialogSplash");

            }
        }.start();

    }
}