package com.ragz.benchmarkapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by Ragz on 03-Nov-16.
 */

public class SleepThread extends AsyncTask<Integer, String, String> {

    private Activity activity;
    private TextView tvStatus;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvStatus = (TextView) activity.findViewById(R.id.tvStatus);
    }

    public SleepThread(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Integer... array) {
        int var = 0;
        for (Integer num : array) {
            try {
                Thread.sleep(num);
                publishProgress(var + " % completed ");
                var += 20;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Task completed";
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        tvStatus.setText(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        tvStatus.setText(result);
    }
}
