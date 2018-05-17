/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.common.protocols.utils;

import android.support.annotation.NonNull;

public enum NetworkErrorType {

    NETWORK_UNREACHABLE(-100),
    NETWORK_ERROR_UNKNOWN(-101),
    NETWORK_MALFORMED_JSON(-102),
    NETWORK_SUCCESS(200),
    NETWORK_NOT_FOUND(404);

    @NonNull
    Integer value;

    NetworkErrorType(@NonNull Integer value) {
        this.value = value;
    }

    @NonNull
    public Integer getValue() {
        return value;
    }

    @NonNull
    public static NetworkErrorType getNetworkType(int value) {
        for(NetworkErrorType type: values()) {
            if(type.getValue() == value) {
                return type;
            }
        }

        return NETWORK_ERROR_UNKNOWN;
    }
}
