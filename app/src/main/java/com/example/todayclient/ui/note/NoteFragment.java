package com.example.todayclient.ui.note;

import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.Fragment;

public class NoteFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.article_view, container, false);
    }
}
