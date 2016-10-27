package com.ragz.benchmarkapp;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class AudioUrlActivity extends AppCompatActivity {

    private MediaPlayer audioUrlPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_url);
        audioUrlPlayer = new MediaPlayer();
    }

    @Override
    protected void onStart() {
        super.onStart();
        audioUrlPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String url = "http://programmerguru.com/android-tutorial/wp-content/uploads/2013/04/hosannatelugu.mp3";
        try {
            audioUrlPlayer.setDataSource(url);
            audioUrlPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        audioUrlPlayer.start();
    }

    @Override
    protected void onDestroy() {
        audioUrlPlayer.stop();
        super.onDestroy();

    }
}
