/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.common.protocols;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.lexu.newsreaderapp.common.protocols.response.NetworkError;
import com.lexu.newsreaderapp.common.protocols.utils.ApiRoute;
import com.lexu.newsreaderapp.common.protocols.utils.NetworkErrorType;
import com.lexu.newsreaderapp.models.response.BaseResponse;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public abstract class BaseProtocol<Class extends BaseResponse> extends OkHttpClient implements IBaseProtocol, IBaseProtocolCallback {

    private ApiRoute route;
    private Class responseClass;

    public final void doGetRequest(@NonNull ApiRoute route, @Nullable Integer itemId, @NonNull Class responseClass) {
        this.responseClass = responseClass;
        this.route = route;
        this.newCall(buildRequest(route, itemId)).enqueue(this);
    }

    abstract Request buildRequest(@NonNull ApiRoute route, @Nullable Integer itemId);

    @Override
    public void onFailure(Call call, IOException e) {
        NetworkError error = new NetworkError(NetworkErrorType.NETWORK_UNREACHABLE.getValue(), e.getLocalizedMessage(), getClass());
        onFail(error);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        int code = response.code();
        NetworkErrorType responseType = NetworkErrorType.getNetworkType(code);

        switch (responseType) {
            case NETWORK_SUCCESS: {
                ResponseBody responseBody = response.body();
                if(responseBody == null || responseBody.string().length() == 0) {
                    onFail(new NetworkError(responseType.getValue(), "", NetworkError.getErrorCause(response), getClass()));
                    return;
                }
                parseResponse(responseBody.string(), route);
                break;
            }

            default: {
                NetworkError error = new NetworkError(responseType.getValue(), "", NetworkError.getErrorCause(response), getClass());
                onFail(error);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void parseResponse(@NonNull String json, @NonNull ApiRoute route) {
        Class responseData = (Class) new Gson().fromJson(json, responseClass.getClass());
        if(responseData != null) {
            updateCache(route, json);
            onSuccess(responseData, route);
        } else {
            NetworkError error = new NetworkError(NetworkErrorType.NETWORK_MALFORMED_JSON.getValue(), json, getClass());
            onFail(error);
        }
    }

    abstract void updateCache(@NonNull ApiRoute route, @NonNull String cacheResponse);
}
