package com.ragz.benchmarkapp;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MassageApp extends AppCompatActivity {

    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massage_app);
        vibrator=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void massage(View view){


        switch (view.getId()){
            case R.id.btnMoon:
                long[] pattern={0,200,100,100,0,100,300};
                vibrator.vibrate(pattern,-1);
                break;
            case R.id.btnSun:
                long[] revpattern={300,100,0,100,100,200,0};
                vibrator.vibrate(revpattern,-1);
                break;
            case R.id.btnStar:
                vibrator.vibrate(100);
                break;
        }

    }

}
