package com.ragz.benchmarkapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AudioPlayerActivity extends AppCompatActivity {

    private static final String TAG = AudioPlayerActivity.class.getName();
    private MediaPlayer rawAudioPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);

        rawAudioPlayer = MediaPlayer.create(getBaseContext(),R.raw.sirikkadhey_ringtone);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void startMusic(View view) {
        try {
            rawAudioPlayer.start();
        } catch (Exception e) {
            Log.i(TAG,"Can't start the Music");
        }

    }

    public void pauseMusic(View view) {
        try {
            rawAudioPlayer.pause();
        } catch (Exception e ) {
            Log.i(TAG,"Can't pause");
        }

    }

    public void stopMusic(View view) {
        try {
            rawAudioPlayer.release();
        } catch (Exception e) {
            Log.i(TAG,"Cant Stop");
        }

    }

    @Override
    protected void onDestroy() {
        rawAudioPlayer.stop();
        super.onDestroy();
    }
}
