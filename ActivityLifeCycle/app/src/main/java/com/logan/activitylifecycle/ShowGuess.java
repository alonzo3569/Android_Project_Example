package com.logan.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ShowGuess extends AppCompatActivity {
    private TextView showGuessTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);

        showGuessTextView = findViewById(R.id.recieved_textview);
        Bundle extra = getIntent().getExtras();

        if(extra != null ){
            // showGuessTextView.setText(getIntent().getStringExtra("guess"));
            showGuessTextView.setText(extra.getString("guess"));
        }

        showGuessTextView.setOnClickListener(view -> {
            Intent intent = getIntent();
            intent.putExtra("message_back", "From Second Activity");
            setResult(RESULT_OK, intent);
            finish(); // Clear(End) current activity
        });

    }
}
