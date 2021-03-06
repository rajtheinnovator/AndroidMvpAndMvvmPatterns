package com.enpassio.androidmvpandmvvmpatterns.mvvm_pattern.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.enpassio.androidmvpandmvvmpatterns.mvvm_pattern.NewsRepository;
import com.enpassio.androidmvpandmvvmpatterns.mvvm_pattern.data.model.Article;

/**
 * Created by Greta Grigutė on 2018-11-09.
 */
public class NewsViewModel extends AndroidViewModel {
    //variable to hold the reference to Repository.
    private NewsRepository mRepository;

    private String searchPhrase;

    // public constructor that gets a reference to the repository and gets the list of news from
    // the repository.
    public NewsViewModel(@NonNull Application application) {
        super(application);
        mRepository = new NewsRepository(application);

    }

    // a "getter" method for all the news. This completely hides the implementation from the UI.
    public LiveData<PagedList<Article>> getAllNews(String searchPhrase) {
        return mRepository.getAllNews(searchPhrase);
    }

    //a wrapper insert() method that calls the Repository's insert() method. In this way, the
    // implementation of insert() is completely hidden from the UI.
    public void insert(Article article) {
        mRepository.insert(article);
    }
}
