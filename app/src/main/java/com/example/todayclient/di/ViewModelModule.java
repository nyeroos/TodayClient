package com.example.todayclient.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.todayclient.ui.note.NoteViewModel;
import com.example.todayclient.ui.user.UserViewModel;
import com.example.todayclient.viewmodel.TodayViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindUserViewModel(UserViewModel userViewModel);

//    @Binds
//    @IntoMap
//    @ViewModelKey(SearchViewModel.class)
//    abstract ViewModel bindSearchViewModel(SearchViewModel searchViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NoteViewModel.class)
    abstract ViewModel bindRepoViewModel(NoteViewModel repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(TodayViewModelFactory factory);
}
