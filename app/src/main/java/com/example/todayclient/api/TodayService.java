package com.example.todayclient.api;

import com.example.todayclient.vo.Contributor;
import com.example.todayclient.vo.Note;
import com.example.todayclient.vo.User;

import android.arch.lifecycle.LiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * REST API access points
 */
public interface TodayService {
    @GET("users/{login}")
    LiveData<ApiResponse<User>> getUser(@Path("login") String login);

    @GET("users/{login}/repos")
    LiveData<ApiResponse<List<Note>>> getNotes(@Path("login") String login);

    @GET("repos/{owner}/{name}")
    LiveData<ApiResponse<Note>> getNote(@Path("owner") String owner, @Path("name") String name);

    @GET("repos/{owner}/{name}/contributors")
    LiveData<ApiResponse<List<Contributor>>> getContributors(@Path("owner") String owner, @Path("name") String name);

    @GET("search/repositories")
    LiveData<ApiResponse<RepoSearchResponse>> searchNotes(@Query("q") String query);

    @GET("search/repositories")
    Call<RepoSearchResponse> searchNotes(@Query("q") String query, @Query("page") int page);
}
