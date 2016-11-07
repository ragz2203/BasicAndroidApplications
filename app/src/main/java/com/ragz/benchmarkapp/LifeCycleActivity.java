package com.ragz.benchmarkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class LifeCycleActivity extends AppCompatActivity {

    private static final String TAG = BenchMarkActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Toast.makeText(getBaseContext(),"onCreate",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"This is onCreate method");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getBaseContext(),"start",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"This is onStart method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getBaseContext(),"resume",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"This is onResume method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getBaseContext(),"pause",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"This is onPause method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getBaseContext(),"stop",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"This is onStop method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getBaseContext(),"destroy",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"This is onDestroy method");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getBaseContext(),"restart",Toast.LENGTH_SHORT).show();
        Log.i(TAG,"This is onRestart method");
    }

}
