package com.siddydevelops.blogaro;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    TextView tittleTV;
    TextView taglineTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Blogaro_splash);
        setContentView(R.layout.activity_splash_screen);

        taglineTV = findViewById(R.id.taglineTextView);
        tittleTV = findViewById(R.id.titleTextView);

        CountDownTimer countDownTimer = new CountDownTimer(2000,100) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

                tittleTV.animate().y(30f).setDuration(1000);
                taglineTV.setVisibility(View.GONE);

                BottomSheetDialogSplash bottomSheetDialogSplash = new BottomSheetDialogSplash();
                bottomSheetDialogSplash.setCancelable(false);
                bottomSheetDialogSplash.show(getSupportFragmentManager(),"BottomSheetDialogSplash");

            }
        }.start();

    }
}