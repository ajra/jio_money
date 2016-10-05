package com.jiomoney.snapbizz.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.ui.home.HomeActivity;

public class Splash extends AppCompatActivity {
    Handler mSplashHandler = new Handler();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSplashHandler.postDelayed(new Runnable() {
            public void run() {
                    Intent intent = new Intent(Splash.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
            }
        }, 3000);
    }
}
