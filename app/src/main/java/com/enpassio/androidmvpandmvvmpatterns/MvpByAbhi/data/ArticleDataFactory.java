package com.enpassio.androidmvpandmvvmpatterns.MvpByAbhi.data;


import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.support.annotation.NonNull;

import com.enpassio.androidmvpandmvvmpatterns.MvpByAbhi.data.network.NewsApiService;
import com.enpassio.androidmvpandmvvmpatterns.MvpByAbhi.presenter.mainscreen.ListContract;

public class ArticleDataFactory extends DataSource.Factory {
    private MutableLiveData<ArticleDataSource> mutableLiveData;
    private NewsApiService mNewsApiService;
    private String mSearchQuery;
    private ListContract.RecyclerView mView;

    public ArticleDataFactory(NewsApiService newsApiService,
                              String searchQuery, ListContract.RecyclerView view) {
        this.mNewsApiService = newsApiService;
        this.mSearchQuery = searchQuery;
        this.mutableLiveData = new MutableLiveData<ArticleDataSource>();
        this.mView = view;
    }

    @NonNull
    @Override
    public DataSource create() {
        ArticleDataSource articleDataSource = new ArticleDataSource(mNewsApiService,
                mSearchQuery, mView);
        mutableLiveData.postValue(articleDataSource);
        return articleDataSource;
    }

    MutableLiveData<ArticleDataSource> getMutableLiveData() {
        return mutableLiveData;
    }
}
