package com.ragz.benchmarkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    private WebView webActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webActivity = (WebView) findViewById(R.id.activity_web);
        webActivity.getSettings().setJavaScriptEnabled(true);
        webActivity.loadUrl("https://www.felight.com/");
    }

}

