package com.marketlogicchallenge.mvp;

import android.support.annotation.Nullable;

/**
 * Created by msalama on 3/10/17.
 */

public interface OnFinishedListener<T> {

    void onSuccess(@Nullable T data);
    void onFailure();

}
