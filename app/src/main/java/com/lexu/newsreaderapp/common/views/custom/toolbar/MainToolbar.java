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
import com.lexu.newsreaderapp.common.views.custom.toolbar.callbacks.IMainToolbarCallback;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.toolbar_main)
public class MainToolbar extends BaseToolbar {

    @ViewById
    RelativeLayout toolbar;

    @ViewById
    ImageView menuButton;

    @ViewById
    TextView title;

    @ViewById
    ImageView refreshButton;

    @ViewById
    View blockingView;

    @ViewById
    ProgressBar loadingBar;

    public MainToolbar(Context context) {
        super(context);
    }

    @Override
    public void onAllowUserInteraction() {
        super.onAllowUserInteraction();
        blockingView.setVisibility(GONE);
    }

    @Override
    public void onBlockUserInteraction() {
        super.onBlockUserInteraction();
        blockingView.setVisibility(VISIBLE);
    }

    public MainToolbar shouldShowRefresh(boolean show) {
        refreshButton.setVisibility(show ? VISIBLE: GONE);
        return this;
    }

    @Click(R.id.menuButton)
    protected void onMenuButtonClicked() {
        if(callback != null && callback instanceof IMainToolbarCallback) {
            ((IMainToolbarCallback) callback).onMenuClicked();
        }
    }

    @Click(R.id.refreshButton)
    protected void onRefreshButtonClicked() {
        onBlockUserInteraction();
        if(callback != null && callback instanceof IMainToolbarCallback) {
            ((IMainToolbarCallback) callback).onRefreshClicked();
        }
    }

    @Override
    public MainToolbar setTitle(@Nullable Integer stringRes) {
        if(stringRes != null) {
            title.setText(getResources().getString(stringRes));
        }
        return this;
    }

    @Override
    public void onNetworkFail() {
        //TODO: generate toolbar message
    }

    @NonNull
    @Override
    public View getView() {
        return toolbar;
    }
}
