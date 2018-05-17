/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.common.protocols.response;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class BaseError {

    @NonNull
    private Integer errorCode;

    @NonNull
    private String errorMessage;

    @Nullable
    private String errorCause;

    public BaseError(@NonNull Integer code, @NonNull String error, @Nullable String cause) {
        errorCode = code;
        errorMessage = error;
        errorCause = cause;
    }

    public BaseError(@NonNull Integer code, @NonNull String error) {
        errorCode = code;
        errorMessage = error;
        errorCause = null;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @NonNull
    public String getMessage() {
        return errorMessage;
    }

    @Nullable
    public String getCause() {
        if(errorCause == null) {
            return "UNKNOWN_ERROR";
        }

        return errorCause;
    }
}
