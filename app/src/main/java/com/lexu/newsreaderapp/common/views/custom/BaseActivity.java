/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.common.views.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.lexu.newsreaderapp.common.views.custom.toolbar.BackButtonToolbar_;
import com.lexu.newsreaderapp.common.views.custom.toolbar.BaseToolbar;
import com.lexu.newsreaderapp.common.views.custom.toolbar.MainToolbar;
import com.lexu.newsreaderapp.common.views.custom.toolbar.MainToolbar_;
import com.lexu.newsreaderapp.common.views.custom.toolbar.RefreshToolbar_;
import com.lexu.newsreaderapp.common.views.custom.toolbar.callbacks.IBaseToolbarCallback;
import com.lexu.newsreaderapp.common.views.interfaces.IUserInteraction;
import com.lexu.newsreaderapp.models.enums.ToolbarType;

import org.androidannotations.annotations.EActivity;

@EActivity
public abstract class BaseActivity<Toolbar extends BaseToolbar, ToolbarCallback extends IBaseToolbarCallback> extends AppCompatActivity implements IUserInteraction {

    @Nullable
    protected Toolbar toolbar;

    @SuppressWarnings("unchecked")
    protected void setToolbar(@NonNull ToolbarType type, @NonNull Integer titleResId, @Nullable ToolbarCallback callback) {
        switch (type) {
            case MAIN_TOOLBAR: {
                toolbar = (Toolbar) MainToolbar_.build(this);
                ((MainToolbar) toolbar)
                        .shouldShowRefresh(true)
                        .setTitle(titleResId)
                        .setUserInteractionListener(this);
                toolbar.setCallback(callback);
                setToolbar(toolbar);
                break;
            }

            case BACK_BUTTON_TOOLBAR: {
                toolbar = (Toolbar) BackButtonToolbar_.build(this);
                toolbar.setTitle(titleResId)
                        .setCallback(callback)
                        .setUserInteractionListener(this);
                setToolbar(toolbar);
                break;
            }

            case REFRESH_ONLY_TOOLBAR: {
                toolbar = (Toolbar) RefreshToolbar_.build(this);
                toolbar.setTitle(titleResId)
                        .setCallback(callback)
                        .setUserInteractionListener(this);
                setToolbar(toolbar);
                break;
            }

            case NONE:
            default:
        }
    }

    private void setToolbar(View view) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setCustomView(view);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
        }
    }

    @Nullable
    protected Toolbar getToolbar()  {
        return toolbar;
    }

    public void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public View getView() {
        return findViewById(android.R.id.content);
    }

    @Override
    public void onAllowUserInteraction() {
        //  Auto-generated method stub
    }

    @Override
    public void onBlockUserInteraction() {
        hideKeyboard();
    }
}