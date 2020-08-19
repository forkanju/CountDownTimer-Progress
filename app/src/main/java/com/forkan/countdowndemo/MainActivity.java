package com.forkan.countdowndemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;

public class MainActivity extends AppCompatActivity {

    CircularView circularViewWithTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        circularViewWithTimer = findViewById(R.id.circular_view);
        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(10)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {

                                // Will be called if times up of countdown timer
                                Toast.makeText(MainActivity.this, "CircularCallback: Timer Finished ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onTimerCancelled() {

                                // Will be called if stopTimer is called
                                Toast.makeText(MainActivity.this, "CircularCallback: Timer Cancelled ", Toast.LENGTH_SHORT).show();
                            }
                        });

        circularViewWithTimer.setOptions(builderWithTimer);

    }

    public void startTimer(View view) {
        circularViewWithTimer.startTimer();


    }

    public void stopTimer(View view) {
        circularViewWithTimer.stopTimer();
    }

    public void pauseTimer(View view) {
        circularViewWithTimer.pauseTimer();

    }

    public void resumeTimer(View view) {
        circularViewWithTimer.resumeTimer();
    }
}