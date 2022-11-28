package com.example.todayclient.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.todayclient.vo.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class TodayDb extends RoomDatabase{
    private static TodayDb instance;

    public abstract NoteDao noteDao();

    public static synchronized TodayDb getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            TodayDb.class, "note_database")
                    .fallbackToDestructiveMigration()
                   // .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {
        private NoteDao noteDao;

        private PopulateDbAsyncTask(TodayDb db){
            noteDao=db.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("Title 1", "Description 1",1));
            noteDao.insert(new Note("Title 2", "Description 2",2));
            noteDao.insert(new Note("Title 3", "Description 3",3));
            return null;
        }
    }
}
