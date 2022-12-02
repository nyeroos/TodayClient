package com.example.todayclient.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.todayclient.api.TodayService;
import com.example.todayclient.db.NoteDao;
import com.example.todayclient.db.TodayDb;
import com.example.todayclient.db.UserDao;
import com.example.todayclient.util.LiveDataCallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
class AppModule {
    @Singleton @Provides
    TodayService provideGithubService() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(TodayService.class);
    }

    @Singleton @Provides
    TodayDb provideDb(Application app) {
        return Room.databaseBuilder(app, TodayDb.class,"today.db").build();
    }

    @Singleton @Provides
    UserDao provideUserDao(TodayDb db) {
        return db.userDao();
    }

    @Singleton @Provides
    NoteDao provideRepoDao(TodayDb db) {
        return db.noteDao();
    }
}
