package com.logan.roombasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonInsert, buttonClear;
    WordViewModel wordViewModel;
    RecyclerView recyclerView;
    MyAdapter myAdapter1, myAdapter2;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        buttonInsert = findViewById(R.id.button_insert);
        buttonClear = findViewById(R.id.button_clear);
        aSwitch = findViewById(R.id.switch1);

        // Setup RecyclerView & Adapter
        recyclerView = findViewById(R.id.recyclerView);
        // 一維列表(線性) : LinearLayoutManager
        // 二維列表(行列) : GridLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter1 = new MyAdapter(false);
        myAdapter2 = new MyAdapter(true);
        recyclerView.setAdapter(myAdapter1);

        // switch listener
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    recyclerView.setAdapter(myAdapter2);
                } else {
                    recyclerView.setAdapter(myAdapter1);
                }
            }
        });

        //
        wordViewModel.getAllWordsLive().observe(MainActivity.this, new Observer<List<Word>>(){
            @Override
            public void onChanged(List<Word> words) {  // Invoke when data change
                myAdapter1.setAllWords(words);
                myAdapter1.notifyDataSetChanged(); // 通知刷新視圖
                myAdapter2.setAllWords(words);
                myAdapter2.notifyDataSetChanged(); // 通知刷新視圖
            }
        });

        // Insert Button
        buttonInsert.setOnClickListener(view -> {
            String[] english = {
                    "Hello",
                    "World",
                    "Integer"
            };
            String[] chinese = {
                    "你好",
                    "世界",
                    "整数类型"
            };
            for (int i = 0; i < english.length; i++) {
                wordViewModel.insertWords(new Word(english[i], chinese[i]));
            }
        });

        // Clear Button
        buttonClear.setOnClickListener(view -> {
            wordViewModel.deleteAllWords();
        });

    }
}