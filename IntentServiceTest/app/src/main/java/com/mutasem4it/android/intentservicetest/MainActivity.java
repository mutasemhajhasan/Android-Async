package com.mutasem4it.android.intentservicetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver downloadReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(MyIntentService.ACTION_DOWNLOAD_COMPLETED))
                Toast.makeText(MainActivity.this, "Completed", Toast.LENGTH_LONG).show();
            else if (intent.getAction().equals(MyIntentService.ACTION_DOWNLOAD_FAILED))
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(downloadReceiver, new IntentFilter(MyIntentService.ACTION_DOWNLOAD_COMPLETED));
        registerReceiver(downloadReceiver, new IntentFilter(MyIntentService.ACTION_DOWNLOAD_FAILED));

    }

    public void btnClick(View view) {
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }
}
