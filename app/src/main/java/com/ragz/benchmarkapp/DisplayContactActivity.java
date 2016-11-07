package com.ragz.benchmarkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class DisplayContactActivity extends AppCompatActivity {

    private TextView tvContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        tvContact = (TextView) findViewById(R.id.tvContact);
    }

    public void getContact(View view) {
        tvContact.setText("lets get a contact displayed here soon");
    }


}
