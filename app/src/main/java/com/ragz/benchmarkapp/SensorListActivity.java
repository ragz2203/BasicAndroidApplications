package com.ragz.benchmarkapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorListActivity extends AppCompatActivity {

    private TextView tvResult;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        tvResult = (TextView) findViewById(R.id.tvResult);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        StringBuilder sensorInfo = new StringBuilder();
        for (Sensor sensor : deviceSensors)
            sensorInfo.append("\n" + sensor.getName() + " " + sensor.getType() + " " + sensor.getVendor() + "\n");

        tvResult.setText(sensorInfo.toString());
    }
}
