package com.mutasem4it.android.asynctaskexample;

import android.app.Dialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView counterTV;
    AsyncTask task = new AsyncTask<String, Integer, String>() {
        @Override
        protected String doInBackground(String[] objects) {

            for (int i = 1; i < 11; i++) {
                publishProgress(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Finished";
        }

        @Override
        protected void onProgressUpdate(Integer[] values) {
            Integer last = values[values.length - 1];
            counterTV.setText(last + "");
        }

        @Override
        protected void onPostExecute(String o) {
            Toast.makeText(MainActivity.this, o.toString(), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterTV = (TextView) findViewById(R.id.counterTV);

    }

    public void countClick(View view) {

        task.execute();
    }
}
