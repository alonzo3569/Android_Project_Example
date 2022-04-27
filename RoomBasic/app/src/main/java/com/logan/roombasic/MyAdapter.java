package com.logan.roombasic;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> { // custom viewHolder

    List<Word> allWords = new ArrayList<>();
    boolean useCardView;

    // Constructor
    public MyAdapter(boolean useCardView) {
        this.useCardView = useCardView;
    }

    // Setter for main
    public void setAllWords(List<Word> allWords) {
        this.allWords = allWords;
    }

    @NonNull
    @Override // 創Holder時呼叫
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View itemView;
        if (useCardView){
            itemView = layoutInflater.inflate(R.layout.cell_card, parent, false);
        }else{
            itemView = layoutInflater.inflate(R.layout.cell_normal, parent, false);
        }

        return new MyViewHolder(itemView);
    }

    @Override // 綁定Holder和Recycler時呼叫
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // system provide position,  starts from 0

        // TextView與數據綁定
        Word word = allWords.get(position); // use position as index in List
        holder.textViewNumber.setText(String.valueOf(position + 1));
        holder.textViewEnglish.setText(word.getWord());
        holder.textViewChinese.setText(word.getChineseMeaning());

        // Click ViewHolder時搜尋文字
        holder.itemView.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://m.youdao.com/dict?le=eng&q="
                    + holder.textViewEnglish.getText());

            // Create new activity using intent
            Intent intent = new Intent(Intent.ACTION_VIEW); // Search website屬於ACTION_VIEW類別
            intent.setData(uri);
            holder.itemView.getContext().startActivity(intent);

        });
    }

    @Override // 返回列表數據個數
    public int getItemCount() {
        return allWords.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNumber, textViewEnglish, textViewChinese;

        // Alt + Ent -> Create constructor matching super
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNumber = itemView.findViewById(R.id.textViewNumber);
            textViewEnglish = itemView.findViewById(R.id.textViewEnglish);
            textViewChinese = itemView.findViewById(R.id.textViewChinese);
        }



    }
}

