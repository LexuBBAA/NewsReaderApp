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
import com.lexu.newsreaderapp.common.views.custom.toolbar.callbacks.IBackButtonToolbarCallback;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.toolbar_back_button)
public class BackButtonToolbar extends BaseToolbar {

    @ViewById
    RelativeLayout toolbar;

    @ViewById
    ImageView menuButton;

    @ViewById
    TextView title;

    @ViewById
    View blockingView;

    @ViewById
    ProgressBar loadingBar;

    public BackButtonToolbar(Context context) {
        super(context);
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
        blockingView.setVisibility(GONE);
    }

    @Override
    public void onBlockUserInteraction() {
        super.onBlockUserInteraction();
        blockingView.setVisibility(VISIBLE);
    }

    @Click(R.id.menuButton)
    protected void onMenuButtonClicked() {
        if(callback != null && callback instanceof IBackButtonToolbarCallback) {
            ((IBackButtonToolbarCallback) callback).onBackPressed();
        }
    }
}
