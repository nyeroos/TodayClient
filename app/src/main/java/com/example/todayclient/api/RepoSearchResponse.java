package com.example.todayclient.api;

import com.example.todayclient.vo.Note;
import com.google.gson.annotations.SerializedName;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO to hold repo search responses. This is different from the Entity in the database because
 * we are keeping a search result in 1 row and denormalizing list of results into a single column.
 */
public class RepoSearchResponse {
    @SerializedName("total_count")
    private int total;
    @SerializedName("items")
    private List<Note> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Note> getItems() {
        return items;
    }

    public void setItems(List<Note> items) {
        this.items = items;
    }

    @NonNull
    public List<Integer> getNoteIds() {
        List<Integer> noteIds = new ArrayList<>();
        for (Note note : items) {
            noteIds.add(note.id);
        }
        return noteIds;
    }
}
