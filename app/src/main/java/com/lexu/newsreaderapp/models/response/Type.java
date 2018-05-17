/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.models.response;

import android.support.annotation.Nullable;

public enum Type {
    STORY("story"), JOB("job"), COMMENT("comment"), POLL("poll"), POLLOPT("pollopt");

    private String value;

    Type(String value) {
        this.value = value;
    }

    @Nullable
    public Type get(@Nullable String value) {
        if(value != null) {
            for(Type type: values()) {
                if(type.getValue().equals(value)) {
                    return type;
                }
            }
        }

        return null;
    }

    public String getValue() {
        return value;
    }
}
