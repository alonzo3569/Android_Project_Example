package com.example.android.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button threePointButton;
    Button twoPointButton;
    Button freeThrowButton;
    TextView scoreView;
    Button threePointButtonB;
    Button twoPointButtonB;
    Button freeThrowButtonB;
    Button resetButton;
    TextView scoreViewB;
    int scoreA = 0;
    int scoreB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        threePointButton = findViewById(R.id.three_point_button);
        twoPointButton = findViewById(R.id.two_point_button);
        freeThrowButton = findViewById(R.id.free_throw_button);
        threePointButtonB = findViewById(R.id.three_point_button_b);
        twoPointButtonB = findViewById(R.id.two_point_button_b);
        freeThrowButtonB = findViewById(R.id.free_throw_button_b);
        resetButton = findViewById(R.id.reset_button);

        threePointButton.setOnClickListener(view -> {
            scoreA+=3;
            displayForTeamA(scoreA);
        });

        twoPointButton.setOnClickListener(view -> {
            scoreA+=2;
            displayForTeamA(scoreA);
        });

        freeThrowButton.setOnClickListener(view -> {
            scoreA+=1;
            displayForTeamA(scoreA);
        });

        threePointButtonB.setOnClickListener(view -> {
            scoreB+=3;
            displayForTeamB(scoreB);
        });

        twoPointButtonB.setOnClickListener(view -> {
            scoreB+=2;
            displayForTeamB(scoreB);
        });

        freeThrowButtonB.setOnClickListener(view -> {
            scoreB+=1;
            displayForTeamB(scoreB);
        });

        resetButton.setOnClickListener(view -> {
            scoreA = 0;
            scoreB = 0;
            displayForTeamA(scoreA);
            displayForTeamB(scoreB);
        });
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
        scoreViewB.setText(String.valueOf(score));
    }
}