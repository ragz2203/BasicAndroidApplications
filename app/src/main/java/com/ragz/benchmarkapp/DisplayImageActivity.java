package com.ragz.benchmarkapp;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DisplayImageActivity extends AppCompatActivity {

    private ImageView ivDisplayImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intentDisplay = getIntent();
        ivDisplayImage = (ImageView) findViewById(R.id.ivDisplayImage);
        Uri uriDisplay = intentDisplay.getParcelableExtra(Intent.EXTRA_STREAM);
        if (uriDisplay != null) {
            ivDisplayImage.setImageURI(uriDisplay);
        }

    }

}
