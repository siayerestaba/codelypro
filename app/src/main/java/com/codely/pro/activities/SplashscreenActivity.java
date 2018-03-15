package com.codely.pro.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codely.pro.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashscreenActivity extends AppCompatActivity {

    private long splashDelay = 3000; // 3 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        configureTimer();
    }

    private void configureTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                closeActivity();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, splashDelay);
    }

    private void closeActivity() {
        Intent mainIntent = new Intent(SplashscreenActivity.this, RecyclerActivity.class);
        startActivity(mainIntent);
        overridePendingTransition(0, 0);
        finish();
    }
}
