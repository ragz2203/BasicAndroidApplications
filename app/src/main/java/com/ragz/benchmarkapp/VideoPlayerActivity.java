package com.ragz.benchmarkapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoPlayerActivity extends AppCompatActivity {

    private VideoView vvPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        vvPlayer = (VideoView) findViewById(R.id.vvPlayer);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.mini_bike;
        vvPlayer.setVideoURI(Uri.parse(path));
        vvPlayer.start();
    }
}
