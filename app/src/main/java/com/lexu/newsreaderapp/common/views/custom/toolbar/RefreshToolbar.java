/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.common.views.custom.toolbar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lexu.newsreaderapp.R;
import com.lexu.newsreaderapp.common.views.custom.toolbar.callbacks.IRefreshToolbarCallback;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.toolbar_main)
public class RefreshToolbar extends BaseToolbar {

    @ViewById
    RelativeLayout toolbar;

    @ViewById
    ImageView menuButton;

    @ViewById
    TextView title;

    @ViewById
    ImageView refreshButton;

    @ViewById
    ProgressBar loadingBar;

    public RefreshToolbar(Context context) {
        super(context);
    }

    @AfterViews
    protected void init() {
        menuButton.setVisibility(INVISIBLE);
    }

    @Override
    public BaseToolbar setTitle(@Nullable Integer stringRes) {
        if(stringRes != null) {
            title.setText(getResources().getString(stringRes));
        }
        return this;
    }

    @NonNull
    @Override
    public View getView() {
        return toolbar;
    }

    @Override
    public void onNetworkFail() {
        //TODO: generate toolbar message
    }

    @Override
    public void onAllowUserInteraction() {
        super.onAllowUserInteraction();
    }

    @Override
    public void onBlockUserInteraction() {
        super.onBlockUserInteraction();
    }

    @Click(R.id.refreshButton)
    protected void onRefreshButtonClicked() {
        onBlockUserInteraction();
        if(userInteractionListener != null && userInteractionListener instanceof IRefreshToolbarCallback) {
            ((IRefreshToolbarCallback) userInteractionListener).onRefreshClicked();
        }
    }
}
