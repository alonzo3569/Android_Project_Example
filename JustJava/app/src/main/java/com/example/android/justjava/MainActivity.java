package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //
    private Button plusButton;
    private Button minusButton;
    private TextView quantityTextView;
    private CheckBox checkBox;
    private CheckBox checkBoxChocolate;
    private EditText editText;

    public  int quantity = 3;
    public Boolean isChecked = false;
    public Boolean isChocolate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        quantityTextView = findViewById(R.id.quantity_text_view);
        checkBox = findViewById(R.id.checkBox);
        checkBoxChocolate = findViewById(R.id.chocolate_checkBox);
        editText = findViewById(R.id.editTextTextPersonName);


        //
        plusButton.setOnClickListener(view -> {
            increment();
            displayQuantity();
        });

        minusButton.setOnClickListener(view -> {
            decrement();
            displayQuantity();
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    isChecked = true;
                } else isChecked = false;
            }
        });

        checkBoxChocolate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    isChocolate = true;
                } else isChocolate = false;
            }
        });

    }

    private void displayQuantity() {
        quantityTextView.setText("" + quantity);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String msg = createOrderSummary();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava Order");
        intent.putExtra(Intent.EXTRA_TEXT, msg);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayMessage(String msg) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(msg);
    }

    private void increment(){
        quantity++;
    }

    private void decrement(){
        if (quantity <= 0) return;
        quantity--;
    }

    private String createOrderSummary(){
        String name = String.valueOf(editText.getText());
        int price = 5;

        if (isChecked){ price += 1; }

        if (isChocolate){ price += 2; }

        return getString(R.string.order_name) + name + "\n" +
                getString(R.string.order_whipped_cream) + isChecked + "\n" +
                getString(R.string.order_chocolate) + isChocolate + "\n" +
                getString(R.string.order_quantity) + quantity + "\n" +
                getString(R.string.order_total) + price * quantity + "\n" +
                getString(R.string.order_thank_you);

    }
}