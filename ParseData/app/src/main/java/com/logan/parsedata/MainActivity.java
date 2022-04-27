package com.logan.parsedata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    // queue = Volley.newRequestQueue(this);
    RequestQueue queue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();
    String url = "https://www.google.com";
    String apiUrl = "https://jsonplaceholder.typicode.com/todos";
    String objUrl = "https://jsonplaceholder.typicode.com/todos/1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getString();

        getJsonArrayRequest();

        TextView textView = findViewById(R.id.textView);

        getJsonObj(textView);
    }

    private void getJsonObj(TextView textView) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, objUrl, null,
                response -> {
                    try {
                        textView.setText(response.getString("title"));
                        Log.d("JSONOBJ", "onCreate: " + response.getString("title"));
                        Log.d("JSONOBJ", "onCreate: " + response.getInt("id"));
                        Log.d("JSONOBJ", "onCreate: " + response.getBoolean("completed"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> Log.d("JSONOBJ", "onCreate: Failed"));
        queue.add(jsonObjectRequest);
    }

    private void getJsonArrayRequest() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, apiUrl, null,
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = response.getJSONObject(i);
                            Log.d("JSON", "onCreate: " + jsonObject.getString("title"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                error -> Log.d("Json", "onCreate: Failed")); // Don't forget this ";" !

        queue.add(jsonArrayRequest);
    }

    private void getString() {
        // listen for error while fetching data from internet
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    // display the contents of our url, 500 characters
                    Log.d("Main", "onCreate: " + response.substring(0, 500));
                }, error -> Log.d("Main", "Failed to get info!"));

        // add the request to the RequestQueue
        queue.add(stringRequest);
    }
}