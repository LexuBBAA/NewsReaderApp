/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.common.views.custom.toolbar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;

import com.lexu.newsreaderapp.common.views.custom.toolbar.callbacks.IBaseToolbarCallback;
import com.lexu.newsreaderapp.common.views.interfaces.IUserInteraction;

import org.androidannotations.annotations.EViewGroup;

@EViewGroup
public abstract class BaseToolbar<T extends IBaseToolbarCallback> extends RelativeLayout implements IUserInteraction, IToolbarView {

    @Nullable
    protected T callback;

    @Nullable
    protected IUserInteraction userInteractionListener;

    public BaseToolbar(Context context) {
        super(context);
    }

    @NonNull
    public BaseToolbar setCallback(@Nullable T callback) {
        this.callback = callback;
        return this;
    }

    @NonNull
    public BaseToolbar setUserInteractionListener(@Nullable IUserInteraction listener) {
        userInteractionListener = listener;
        return this;
    }

    @Override
    public void onAllowUserInteraction() {
        if(userInteractionListener != null) {
            userInteractionListener.onAllowUserInteraction();
        }
    }

    @Override
    public void onBlockUserInteraction() {
        if(userInteractionListener != null) {
            userInteractionListener.onBlockUserInteraction();
        }
    }
}
