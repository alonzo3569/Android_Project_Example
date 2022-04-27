package com.logan.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.android.material.snackbar.Snackbar;
import com.logan.trivia.controller.AppController;
import com.logan.trivia.data.AnswerListAsyncResponse;
import com.logan.trivia.data.Repository;
import com.logan.trivia.databinding.ActivityMainBinding;
import com.logan.trivia.model.Question;
import com.logan.trivia.model.Score;
import com.logan.trivia.util.Prefs;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";
    private ActivityMainBinding binding;
    private int currentQuestionIndex = 0;
    List<Question> questions;
    private int scoreCounter = 0;
    private Score score;
    private Prefs prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        score = new Score();
        prefs = new Prefs(MainActivity.this);
        currentQuestionIndex = prefs.getState();

        binding.currentScoreTextview.setText(String.format("Current Score : %d", score.getScore()));
        binding.highScoreTextview.setText(String.format("High Score : %d", prefs.getHighestScore()));

        Repository repo = new Repository();
        repo.getQuestions(new AnswerListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Question> questionArrayList) {
                questions = questionArrayList;
                binding.questionTextView.setText(questions.get(currentQuestionIndex).getAnswer()
                        .toString());
                updateCounter();
            }
        });

        binding.buttonNext.setOnClickListener(view -> {
            getNextQuestion();
        });

        binding.buttonTrue.setOnClickListener(view -> {
            checkAnswer(true);
        });

        binding.buttonFalse.setOnClickListener(view -> {
            checkAnswer(false);

        });

    }

    private void getNextQuestion() {
        currentQuestionIndex = (currentQuestionIndex + 1) % questions.size();
        updateCounter();
        binding.questionTextView.setText(questions.get(currentQuestionIndex).getAnswer().
                toString());
    }

    private void checkAnswer(boolean userChoseCorrect) {
        boolean answer = questions.get(currentQuestionIndex).isAnswerTrue();
        int snackMessageId = 0;
        if(userChoseCorrect == answer){
            snackMessageId = R.string.correct_answer;
            fadeAnimation();
            addPoints();
        }else{
            snackMessageId = R.string.incorrect_answer;
            shakeAnimation();
            deductPoints();
        }
        Snackbar.make(binding.cardView, snackMessageId, Snackbar.LENGTH_SHORT).show();
    }

    private void updateCounter() {
        binding.textViewOutOf.setText(String.format(getString(R.string.text_formatted), currentQuestionIndex,
                questions.size()));
    }

    private void shakeAnimation(){
        Animation shake = AnimationUtils.loadAnimation(MainActivity.this,
                R.anim.shake_animation);
        binding.cardView.startAnimation(shake);

        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
//                binding.questionTextView.setBackgroundColor(Color.RED);
                binding.questionTextView.setTextColor(Color.RED);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                binding.questionTextView.setTextColor(Color.WHITE);
                getNextQuestion();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void fadeAnimation(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setRepeatMode(Animation.REVERSE); // go back to original state

        binding.cardView.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                binding.questionTextView.setTextColor(Color.GREEN);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                binding.questionTextView.setTextColor(Color.WHITE);
                getNextQuestion();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void addPoints(){
        scoreCounter += 100;
        score.setScore(scoreCounter);
        binding.currentScoreTextview.setText(String.format("Current Score : %d", score.getScore()));
    }

    private void deductPoints(){
        scoreCounter -= 100;
        if (scoreCounter < 0) scoreCounter = 0;
        score.setScore(scoreCounter);
        binding.currentScoreTextview.setText(String.format("Current Score : %d", score.getScore()));
    }

    @Override
    protected void onPause() {
        prefs.saveHighestScore(scoreCounter);
        prefs.saveState(currentQuestionIndex);

        super.onPause();
    }
}