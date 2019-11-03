package com.approck.paycam.modules.Splash;

import android.os.Bundle;
import android.os.Handler;

import com.approck.paycam.R;
import com.approck.paycam.common.GoToHelper;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                GoToHelper.goLogin(Splash.this);
                finish();

            }

        }, SPLASH_DISPLAY_LENGTH);

    }



}