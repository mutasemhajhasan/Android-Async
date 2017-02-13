package com.mutasem4it.android.intentservicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


public class MyIntentService extends IntentService {

    public static final String ACTION_DOWNLOAD_COMPLETED = "com.mutasem4it.android.intentserviceexample.action.DOWNLOAD_COMPLETED";
    public static final String ACTION_DOWNLOAD_FAILED = "com.mutasem4it.android.intentserviceexample.action.DOWNLOAD_FAILED";


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Intent i = new Intent();
        if (downloadFile()) {
            i.setAction(ACTION_DOWNLOAD_COMPLETED);
            sendBroadcast(i);
        } else {
            i.setAction(ACTION_DOWNLOAD_FAILED);
            sendBroadcast(i);
        }
    }

    private boolean downloadFile() {
        //ToDO file downloading here
        //Pseudo Code
        for (int i = 0; i < 20; i++)
            try {
                Log.d("index ",i+"");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }

        return true;
    }
}
