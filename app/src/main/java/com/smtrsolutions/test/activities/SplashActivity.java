package com.smtrsolutions.test.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.smtrsolutions.test.R;
import com.smtrsolutions.test.activities.baseActivities.BaseActivity;
import com.smtrsolutions.test.util.Util;

/**
 * Created by Edwin alvarado on 9/20/17.
 * Copyright © 2017 Edwin Alvarado. All rights reserved.
 */

public class SplashActivity extends BaseActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;
    private Activity activity;

    private final int interval = 5000; // 2 Second
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Util.setActivity(this);

        handler.postAtTime(runnable, System.currentTimeMillis()+interval);
        handler.postDelayed(runnable, interval);
    }

    private Runnable runnable = new Runnable(){
        public void run() {
            Util.goToActivityFade(
                    Util.getActivity(),
                    MainActivity.class,
                    Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK
            );
        }
    };
}
