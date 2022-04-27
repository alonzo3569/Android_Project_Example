package com.logan.roombasic;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {

    // singleton obj INSTANCE
    private  static WordDatabase INSTANCE;

    // Method for creating WordDatabase obj
    // singleton concept : if null, create one, otherwise, use the old one
    static synchronized WordDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                    , WordDatabase.class
                    , "word_database")
//                    .allowMainThreadQueries() // 新增AsyncTack後, 可以移除這行
                    .build();
        }
        return INSTANCE;
    }

    public abstract  WordDao getWordDao();
}
