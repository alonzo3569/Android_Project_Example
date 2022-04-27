package com.logan.trivia.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    public static final String HIGHEST_SCORE = "highest_score";
    public static final String TRIVIA_STATE = "trivia_state";
    private SharedPreferences preferences;

    public Prefs(Activity context){
        this.preferences = context.getPreferences(Context.MODE_PRIVATE);
    }

    public int saveHighestScore(int score){
        int currentScore = score;
        int lastScore = preferences.getInt(HIGHEST_SCORE, 0);
        if(currentScore > lastScore){
            preferences.edit().putInt(HIGHEST_SCORE, currentScore).apply();
        }
        return 0;
    }

    public int getHighestScore(){
        return preferences.getInt(HIGHEST_SCORE, 0);
    }

    public void saveState(int index){
        preferences.edit().putInt(TRIVIA_STATE, index).apply();
    }

    public int getState(){
        return preferences.getInt(TRIVIA_STATE, 0);
    }
}
