package com.example.todayclient.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import androidx.lifecycle.LiveData;

import com.example.todayclient.AppExecutors;
import com.example.todayclient.api.ApiResponse;
import com.example.todayclient.api.TodayService;
import com.example.todayclient.db.NoteDao;
import com.example.todayclient.vo.Note;
import com.example.todayclient.vo.Resource;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class NoteRepository {
    private final NoteDao noteDao;
    private final TodayService todayService;
    private final AppExecutors appExecutors;

    @Inject
    NoteRepository(AppExecutors appExecutors, NoteDao noteDao, TodayService todayService) {
        this.noteDao = noteDao;
        this.todayService = todayService;
        this.appExecutors = appExecutors;
    }

    public LiveData<Resource<Note>> loadNote(String id) {
        return new NetworkBoundResource<Note,Note>(appExecutors) {
            @Override
            protected void saveCallResult(@NonNull Note item) {
                noteDao.insert(item);
            }

            @Override
            protected boolean shouldFetch(@Nullable Note data) {
                return data == null;
            }

            @NonNull
            @Override
            protected LiveData<Note> loadFromDb() {
                return noteDao.findById(id);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<Note>> createCall() {
                return todayService.getNote(id);
            }
        }.asLiveData();
    }
}
