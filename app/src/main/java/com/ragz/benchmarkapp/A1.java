package com.ragz.benchmarkapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class A1 extends AppCompatActivity {

    public void getUserName(View view){
        Intent intent = new Intent(getBaseContext(),A2.class);
        startActivityForResult(intent,100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode == 100 && resultCode == RESULT_OK){
            Log.i("vinay","onActivityresult called "+ requestCode + " " + resultCode + " " + intent.getStringExtra("username"));

            Toast.makeText(getBaseContext(),intent.getStringExtra("username"),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);
    }
}
