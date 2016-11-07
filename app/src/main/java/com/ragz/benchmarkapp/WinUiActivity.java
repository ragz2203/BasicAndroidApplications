package com.ragz.benchmarkapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WinUiActivity extends AppCompatActivity {

    final Context context = this;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_ui);
    }

    public void gotoActivity(View view) {

        switch (view.getId()) {
            case R.id.LL_1:
                startActivity(new Intent(context, ToastActivity.class));
                break;
            case R.id.LL_2:
                startActivity(new Intent(context, MessageActivity.class));
                break;
            case R.id.LL_3:
                startActivity(new Intent(context, MassageApp.class));
                break;
            case R.id.LL_4:
                startActivity(new Intent(context, AnimationActivity.class));
                break;
            case R.id.LL_5:
                startActivity(new Intent(context, LifeCycleActivity.class));
                break;
            case R.id.LL_6:
                intent = new Intent(context, ResultActivity.class);
                intent.putExtra("message", "GOOGLE NEWS");
                startActivity(intent);
                break;
            case R.id.LL_7:
                startActivity(new Intent(context, WebActivity.class));
                break;
            case R.id.LL_8:
                startActivity(new Intent(context, SensorListActivity.class));
                break;
            case R.id.LL_9:
                openApp(this, "com.ragz.myregistration");
                break;
            case R.id.LL_10:
                openApp(this, "com.google.android.apps.maps");
                break;
            case R.id.LL_11:
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                break;
            case R.id.LL_12:
                openApp(this, "com.facebook.katana");
                break;
            case R.id.LL_13:
                startActivity(new Intent(context, ImageEditorActivity.class));
                break;
            case R.id.LL_14:
                openApp(this, "com.ragz.musicplayer");
                break;
            case R.id.LL_15:
                startActivity(new Intent(context, SensorValuesActivity.class));
                break;
            case R.id.LL_16:
                startActivity(new Intent(context, A1.class));
                break;
        }

    }

    public static boolean openApp(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        Intent i = manager.getLaunchIntentForPackage(packageName);
        if (i == null) {
            return false;
        }
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        context.startActivity(i);
        return true;
    }

}
