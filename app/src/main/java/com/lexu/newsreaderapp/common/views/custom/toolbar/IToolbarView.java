/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.common.views.custom.toolbar;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.lexu.newsreaderapp.common.views.custom.IAbstractView;

public interface IToolbarView extends IAbstractView {

    BaseToolbar setTitle(@Nullable Integer stringRes);

    @NonNull
    View getView();

}
