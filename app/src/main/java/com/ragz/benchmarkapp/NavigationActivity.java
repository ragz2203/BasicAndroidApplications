package com.ragz.benchmarkapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.wifi.WifiManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class NavigationActivity extends AppCompatActivity {

    final Context context = this;
    private Intent intent;
    private WifiManager wifiManager;
    private ToggleButton tbtnwifi;
    private Button btnNotify;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_icons);
    }

    @Override
    protected void onStart() {
        super.onStart();

        wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);

        tbtnwifi = (ToggleButton) findViewById(R.id.tbtnWifi);
        tbtnwifi.setChecked(wifiManager.isWifiEnabled());
        tbtnwifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                wifiManager.setWifiEnabled(isChecked);
            }

        });
        btnNotify = (Button) findViewById(R.id.btnNotify);
    }

    public void notificationMessage(View view){
        PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(),0,new Intent(getBaseContext(),NavigationActivity.class),0);
        Resources res= getResources();
        Notification notification = new NotificationCompat.Builder(this)
                .setTicker("Welcome")
                .setSmallIcon(R.drawable.felight_icon)
                .setContentTitle("Welcome Notification")
                .setContentText("This is notification message")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,notification);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getBaseContext(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
        return true;
    }

    public void gotoApp(View view) {

        switch (view.getId()) {
            case R.id.ivMessage:
                startActivity(new Intent(context, MessageActivity.class));
                break;
            case R.id.ivMassage:
                startActivity(new Intent(context, MassageApp.class));
                break;
            case R.id.ivToast:
                startActivity(new Intent(context, ToastActivity.class));
                break;
            case R.id.ivBench:
                startActivity(new Intent(context, BenchMarkActivity.class));
                break;
            case R.id.ivWebView:
                startActivity(new Intent(context, WebActivity.class));
                break;
            case R.id.ivGoogle:
                intent = new Intent(context, ResultActivity.class);
                intent.putExtra("message", "GOOGLE NEWS");
                startActivity(intent);
                break;
            case R.id.ivFelight:
                intent = new Intent(context, ResultActivity.class);
                intent.putExtra("message", "FELIGHT NEWS");
                startActivity(intent);
                break;
            case R.id.ivLife:
                intent = new Intent(context, LifeCycleActivity.class);
                startActivity(intent);
                break;
            case R.id.ivAnimation:
                intent = new Intent(context, AnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.btnBenchMarkAct:
                startActivity(new Intent(context, BenchMarkActivity.class));
                break;
            case R.id.btnWebAct:
                startActivity(new Intent(context, WebActivity.class));
                break;
            case R.id.btnToastAct:
                startActivity(new Intent(context, ToastActivity.class));
                break;
            case R.id.btnMessageAct:
                startActivity(new Intent(context, MessageActivity.class));
                break;
            case R.id.btnMassagingAct:
                startActivity(new Intent(context, MassageApp.class));
                break;
            case R.id.btnGoogleFeed:
                intent = new Intent(context, ResultActivity.class);
                intent.putExtra("message", "GOOGLE NEWS");
                startActivity(intent);
                break;
            case R.id.btnFelightNews:
                intent = new Intent(context, ResultActivity.class);
                intent.putExtra("message", "FELIGHT NEWS");
                startActivity(intent);
                break;
            case R.id.btnLifeAct:
                intent = new Intent(context, LifeCycleActivity.class);
                startActivity(intent);
                break;
            case R.id.btnAnimation:
                intent = new Intent(context, AnimationActivity.class);
                startActivity(intent);
                break;
        }

    }

}
