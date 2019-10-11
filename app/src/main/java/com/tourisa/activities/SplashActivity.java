package com.tourisa.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tourisa.R;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        try {
            new Thread() {
                public void run() {
                    try {
                        sleep(SPLASH_TIME_OUT);
                        Intent i;
                        i = new Intent(getBaseContext(), WelcomeActivity.class);
                        startActivity(i);
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
