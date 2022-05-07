package com.logan.roombasic;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Word.class}, version = 3, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {

    private  static WordDatabase INSTANCE;

    static synchronized WordDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                    , WordDatabase.class
                    , "word_database")
//                    .fallbackToDestructiveMigration()
                    .addMigrations(MIGRATION_2_3)
                    .build();
        }
        return INSTANCE;
    }

    public abstract  WordDao getWordDao();

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE word ADD COLUMN bar_data INTEGER");
        }
    };


    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL(
                    "CREATE TABLE word_temp (id INTEGER PRIMARY KEY NOT NULL," +
                    "english_word TEXT," +
                    "chinese_meaning TEXT)");
            database.execSQL(
                    "INSERT INTO word_temp (id, english_word, chinese_meaning)" +
                    "SELECT id, english_word, chinese_meaning FROM word");                           // insert data from old table
            database.execSQL("DROP TABLE word");                                                     // delete old table
            database.execSQL("ALTER TABLE word_temp RENAME to word");                                // rename new table
        }
    };
}
