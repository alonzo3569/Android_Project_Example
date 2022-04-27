package com.logan.bio;

import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.logan.bio.data.Bio;
import com.logan.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Bio bio = new Bio(); // final makes bio become global

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        bio.setName("Logan Zhang");
        binding.setBio(bio);
        binding.doneButton.setOnClickListener(view -> addHobbies(view));

    }

    public void addHobbies(View view) {
        bio.setHobbies(String.format("Hobbies: %s",
                binding.enterHobbies.getText().toString().trim()));
//        binding.hobbiesText.setText(String.format("Hobbies: %s",
//                                      binding.enterHobbies.getText().toString().trim()));
        binding.invalidateAll();
        binding.hobbiesText.setVisibility(VISIBLE);

        // Hide keyboard
        // Make the keyboard disappear once we press done
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}