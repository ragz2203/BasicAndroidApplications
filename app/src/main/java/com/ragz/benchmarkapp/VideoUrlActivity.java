package com.ragz.benchmarkapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoUrlActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_url);

        VideoView vid = (VideoView) findViewById(R.id.vvUrlPlayer);
        Uri vidUri = Uri.parse("https://youtube/AsV4GiuwEsg");
        vid.setVideoURI(vidUri);
        vid.setMediaController(new MediaController(this));
        vid.start();

    }
}
