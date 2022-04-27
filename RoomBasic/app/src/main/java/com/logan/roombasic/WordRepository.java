package com.logan.roombasic;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    private WordDatabase wordDatabase;
    private WordDao wordDao;
    private LiveData<List<Word>> allWordsLive;


    public WordRepository(Context context){

        // Create database using singleton
        wordDatabase = WordDatabase.getDatabase(context.getApplicationContext());

        // Connect database to Dao
        wordDao = wordDatabase.getWordDao();

        // Get LiveData in database
        allWordsLive = wordDao.getAllWordsLive();
    }

    public LiveData<List<Word>> getAllWordsLive() { // getter
        return allWordsLive;
    }

    void insertWords(Word... words){
        new InsertAsyncTask(wordDao).execute(words);
    }
    void updateWords(Word... words){
        new UpdateAsyncTask(wordDao).execute(words);
    }
    void deleteWords(Word... words){
        new DeleteAsyncTask(wordDao).execute(words);
    }
    void deleteAllWords(Word... words){
        new DeleteAllAsyncTask(wordDao).execute();
    }

    static class InsertAsyncTask extends AsyncTask<Word, Void, Void> { // 報告進度, 報告結果
        private WordDao wordDao;

        // Constructor
        public InsertAsyncTask(WordDao wordDao){
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words){
            wordDao.insertWords(words);
            return null;
        }

        //@Override
        //protected void onPostExecute(Void unused) {}       // 任務完成時呼叫,將資料帶回主線程
        //protected void onProgressUpdate(Void... values) {} // 回報進度,做進度條用
        //protected void onPreExecute() {}                   // 執行前呼叫
    }

    static class UpdateAsyncTask extends AsyncTask<Word, Void, Void>{
        private WordDao wordDao;

        // Constructor
        public UpdateAsyncTask(WordDao wordDao){
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words){
            wordDao.updateWords(words);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Word, Void, Void>{
        private WordDao wordDao;

        // Constructor
        public DeleteAsyncTask(WordDao wordDao){
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words){
            wordDao.deleteWords(words);
            return null;
        }
    }

    static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void>{ // 不須輸入參數,改成void
        private WordDao wordDao;

        // Constructor
        public DeleteAllAsyncTask(WordDao wordDao){
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids){
            wordDao.deleteAllWords();
            return null;
        }
    }
}
