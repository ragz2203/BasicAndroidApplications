package com.ragz.benchmarkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tvResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    @Override
    protected void onStart() {
        super.onStart();
        tvResultView=(TextView)findViewById(R.id.tvResultView);
        tvResultView.setText(getIntent().getStringExtra("message"));
    }


}
