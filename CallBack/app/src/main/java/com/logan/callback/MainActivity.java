package com.logan.callback;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.logan.callback.Import.ActionListenerCallback;
import com.logan.callback.Import.Worker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Worker worker = new Worker();
        Log.d("TEST","Finish creating worker obj");
        worker.setActionListener(new ActionListenerCallback() {

            @Override
            public void onActionSuccess(String successMessage) {
                Log.d("TEST","The event has been triggered successfully");
            }

        });

        Log.d("TEST","Wait");

//        Worker a = new Worker();
    }
}