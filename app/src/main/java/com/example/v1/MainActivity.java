package com.example.v1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.v1.controller.activity.LoginRegisterActivity;


public class MainActivity extends AppCompatActivity {
    private CountDownTimer countTimer;
    private LottieAnimationView lottieAnimationView,humanAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        lottieAnimationView = findViewById(R.id.imageAnimation);
  /*      humanAnimation = findViewById(R.id.humanAnimation);*/
        countTimer = new CountDownTimer(9000, 9000) {
            @Override
            public void onTick(long millisUntilFinished) {}
            @Override
            public void onFinish() {
                lottieAnimationView.cancelAnimation();
                humanAnimation.cancelAnimation();
                threadKiller();
            }
        }.start();
    }

    private void threadKiller() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(getApplicationContext(), LoginRegisterActivity.class);
                startActivity(login);
                finish();
            }
        }).start();
    }
}



