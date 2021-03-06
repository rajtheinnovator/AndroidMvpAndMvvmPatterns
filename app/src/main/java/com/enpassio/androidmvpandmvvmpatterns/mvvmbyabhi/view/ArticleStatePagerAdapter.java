package com.enpassio.androidmvpandmvvmpatterns.mvvmbyabhi.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.enpassio.androidmvpandmvvmpatterns.mvvmbyabhi.data.model.Article;

import java.util.ArrayList;

public class ArticleStatePagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Article> mArticleArrayList;

    ArticleStatePagerAdapter(FragmentManager fmg, ArrayList<Article> articleArrayList) {
        super(fmg);
        mArticleArrayList = articleArrayList;
    }

    @Override
    public int getCount() {
        return mArticleArrayList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return DetailsFragmentMvvmAbhi.newInstance(mArticleArrayList.get(position));
    }
}