/*
 * Copyright (c) Bogdan Andrei Alexandru - 2017.
 */

package com.lexu.newsreaderapp.common.protocols;

import android.support.annotation.NonNull;

import com.lexu.newsreaderapp.common.protocols.response.BaseError;
import com.lexu.newsreaderapp.common.protocols.utils.ApiRoute;
import com.lexu.newsreaderapp.models.response.BaseResponse;

public interface IBaseProtocolCallback<IView> {

    void onSuccess(BaseResponse response, ApiRoute route);

    void onFail(@NonNull BaseError responseError);

}
