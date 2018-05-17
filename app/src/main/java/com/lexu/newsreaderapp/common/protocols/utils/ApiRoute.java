/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.common.protocols.utils;

import android.support.annotation.NonNull;

public enum ApiRoute {
    HOT_NEWS("newstories.json"),
    BEST_NEWS("beststories.json"),
    TOP_NEWS("topstories.json"),
    JOB_STORIES("jobstories.json"),
    COMMENT("item/%d.json"),
    ITEM("item/%d.json");

    @NonNull
    private String value;

    ApiRoute(@NonNull String value) {
        this.value = value;
    }

    @NonNull
    public ApiRoute get(@NonNull String path) {
        for(ApiRoute route: values()) {
            if(route.getValue().equals(path)) {
                return route;
            }
        }

        return HOT_NEWS;
    }

    @NonNull
    public String getValue() {
        return value;
    }
}
