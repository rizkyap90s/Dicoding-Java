package com.example.servicesederhana;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

public class DicodingIntentService extends IntentService {
    public static String EXTRA_DURATION = "extra_duration";
    public static final String TAG = DicodingIntentService.class.getSimpleName();

    public DicodingIntentService() {
        super("DicodingIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            int duration = intent.getIntExtra(EXTRA_DURATION, 0);
            try {
                Thread.sleep(duration);
                Log.d(TAG, "onHandleIntent: Selesai.....");
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

}
