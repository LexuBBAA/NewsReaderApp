/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.common.presenters;

import android.support.annotation.Nullable;

import com.lexu.newsreaderapp.common.views.custom.IAbstractView;

import org.androidannotations.annotations.EBean;

@EBean
public abstract class AbstractPresenter<IView extends IAbstractView> implements IAbstractPresenter<IView> {

    @Nullable
    IView abstractView;

    @Nullable
    @Override
    public IView getView() {
        return abstractView;
    }

    @Override
    public void setView(@Nullable IView view) {
        this.abstractView = view;
    }
}
