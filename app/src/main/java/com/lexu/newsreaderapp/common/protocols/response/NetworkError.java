/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.common.protocols.response;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import okhttp3.Response;

public class NetworkError extends BaseError {

    @NonNull
    private Class errorSource;

    public NetworkError(@NonNull Integer code, @NonNull String error, @Nullable String cause, @NonNull Class source) {
        super(code, error, cause);
        errorSource = source;
    }

    public NetworkError(@NonNull Integer code, @NonNull String error, @NonNull Class source) {
        super(code, error);
        errorSource = source;
    }

    @NonNull
    public Class getErrorSource() {
        return errorSource;
    }

    @NonNull
    public static String getErrorCause(@NonNull Response response) {
        //TODO: implement method
        return "";
    }
}
