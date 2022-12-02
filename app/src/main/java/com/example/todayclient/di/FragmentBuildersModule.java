package com.example.todayclient.di;

import com.example.todayclient.ui.note.NoteFragment;
import com.example.todayclient.ui.user.UserFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract NoteFragment contributeRepoFragment();

    @ContributesAndroidInjector
    abstract UserFragment contributeUserFragment();

//    @ContributesAndroidInjector
//    abstract SearchFragment contributeSearchFragment();
}
