package com.service.yonosbi2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LastActivity extends AppCompatActivity {

    private TextView timerText;
    private static final long FOUR_HOURS_IN_MILLIS = 4 * 60 * 60 * 1000; // 4 hours

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        timerText = findViewById(R.id.timerText);

        new CountDownTimer(FOUR_HOURS_IN_MILLIS, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long hours = millisUntilFinished / (1000 * 60 * 60);
                long minutes = (millisUntilFinished / (1000 * 60)) % 60;
                long seconds = (millisUntilFinished / 1000) % 60;

                String timeLeft = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                timerText.setText(timeLeft);
            }

            @Override
            public void onFinish() {
                timerText.setText("Time Over!");
            }
        }.start();
    }
}
