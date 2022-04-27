package com.logan.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button showGuess;
    private EditText enterGuess;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showGuess = findViewById(R.id.guess_button);
        enterGuess = findViewById(R.id.guess_field);

        showGuess.setOnClickListener(view -> {
            String msg = enterGuess.getText().toString().trim();

            if (!msg.isEmpty()){
                Intent intent = new Intent(MainActivity.this, ShowGuess.class);
                intent.putExtra("guess", msg);
                intent.putExtra("name", "bond");
                intent.putExtra("age", 34);
                startActivityForResult(intent, REQUEST_CODE); // Wait for return code
                // startActivity(intent); // Not expecting anything back
            }else{
                Toast.makeText(MainActivity.this, "Plz enter guess", Toast.LENGTH_SHORT)
                        .show();
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String message = data.getStringExtra("message_back");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

//                Bundle extra = getIntent().getExtras();
//                Log.d("Return intent", "onCreate : " + extra.getString("age"));
            }
        }
    }
}

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        Log.d("Cycle", "onStart: ");
//        Toast.makeText(MainActivity.this, "onStart() Called",
//                Toast.LENGTH_SHORT)
//                .show();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d("Cycle", "onResume: ");
//        Toast.makeText(MainActivity.this, "onResume() Called",
//                Toast.LENGTH_SHORT)
//                .show();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d("Cycle", "onPause: ");
//        Toast.makeText(MainActivity.this, "onPause() Called",
//                Toast.LENGTH_SHORT)
//                .show();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d("Cycle", "onStop: ");
//        Toast.makeText(MainActivity.this, "onStop() Called",
//                Toast.LENGTH_SHORT)
//                .show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("Cycle", "onDestroy: ");
//        Toast.makeText(MainActivity.this, "onDestroy() Called",
//                Toast.LENGTH_SHORT)
//                .show();
//    }
//}