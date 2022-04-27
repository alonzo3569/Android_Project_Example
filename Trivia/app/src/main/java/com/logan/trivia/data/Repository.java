package com.logan.trivia.data;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.logan.trivia.controller.AppController;
import com.logan.trivia.model.Question;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    ArrayList<Question> questionArrayList = new ArrayList<>();
    String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";

    public void getQuestions(final AnswerListAsyncResponse callBack) { // List >> ArrayList, ArrayList is one of List

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {

                    for (int i = 0; i < response.length(); i++) {
                        try {
                            Question question = new Question(response.getJSONArray(i).get(0).toString(),
                                    response.getJSONArray(i).getBoolean(1));

                            // Add question to arrayList
                            questionArrayList.add(question);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    if (null != callBack) callBack.processFinished(questionArrayList);

                }, error -> {
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}
