/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.common.presenters;

import android.support.annotation.Nullable;

import com.lexu.newsreaderapp.common.views.custom.IAbstractView;

public interface IAbstractPresenter<T extends IAbstractView> {

    @Nullable
    T getView();

    void setView(@Nullable T view);

}
