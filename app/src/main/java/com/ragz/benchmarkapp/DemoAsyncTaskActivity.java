package com.ragz.benchmarkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DemoAsyncTaskActivity extends AppCompatActivity {


    public void doSomething(View view) {
        SleepThread sleepThread = new SleepThread(this);
        sleepThread.execute(1000,2000,5000,2000,1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_async_task);
    }
}
