/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.common.protocols;

import com.lexu.newsreaderapp.common.protocols.utils.ApiRoute;

import org.androidannotations.annotations.EBean;

import java.util.HashMap;
import java.util.Map;

@EBean(scope = EBean.Scope.Singleton)
public class NetworkCache {

    Map<String, String> cachedData = new HashMap<String, String>();

    Map<String, Boolean> queuedRequests = new HashMap<String, Boolean>();

    final boolean isExecuting(ApiRoute route) {
        if(!queuedRequests.containsKey(route.getValue())) {
            return false;
        }

        return queuedRequests.get(route.getValue());
    }

}
