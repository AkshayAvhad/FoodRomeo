package com.tiltedplay.foodromeo.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.tiltedplay.foodromeo.R;

/**
 * Created by Akshay1 on 28-Oct-15.
 */
public class SplashScreen extends AppCompatActivity {

    private static int Splash_timeout = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this,PaginationLayout.class);
                startActivity(i);

                finish();
            }
        }, Splash_timeout);
    }
}
