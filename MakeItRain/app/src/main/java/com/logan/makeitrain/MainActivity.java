package com.logan.makeitrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private Button makeItRain;      // Declare Object
    private Button showInfo;        // Has nothing to do with
    private TextView moneyValue;    // Params that declare in res/ or gui
    private TextView congratsMsg;
    private int moneyCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeItRain = findViewById(R.id.buttonMakeItRain); // connect Palette id to Object
        moneyValue = findViewById(R.id.moneyValue);
        congratsMsg = findViewById(R.id.congratsMsg);

        moneyValue.setText(R.string.test); // test is a name of a string
                                           // R represents res folder, everything
                                           // starts with R means it is define
                                           // through gui or res/ file

    }

    public void showMoney(View view) {  // After chosing "Create in MinaActivity", this will show up
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(); // Add dollar sign
        moneyCounter += 1000;
        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter))); // setText only takes string
                                                                               // Thus, use valueof to
                                                                               // convert int to string

        Log.d("MIR", "onClick: " + moneyCounter);  // Log.d : msg that shows in debug terminal
                                                            // tag : user define
        if (moneyCounter >= 20000){

            moneyValue.setTextColor(Color.rgb(255, 255, 255));

            moneyValue.setTextColor(ContextCompat.getColor(
                                    MainActivity.this,
                                    R.color.white));

            congratsMsg.setText("Congrats!!!!");
        }
    }

    public void showInfo(View view) {
//        Toast.makeText(MainActivity.this,
//                        R.string.app_info,
//                        Toast.LENGTH_SHORT)
//                        .show();

        Snackbar.make(view, R.string.app_info, Snackbar.LENGTH_LONG)
                .setAction("More", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("Snack", "showInfo: Snackbar");
                    }
                })
                .show();
    }
}