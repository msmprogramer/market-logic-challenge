package com.marketlogicchallenge.data;

/**
 * Created by msalama on 3/10/17.
 */

import android.support.annotation.Nullable;

import com.marketlogicchallenge.data.api.ApiRest;
import com.marketlogicchallenge.utils.Constants;

import retrofit.RestAdapter;

public class RestClient {

    private ApiRest apiRest;

    private static RestClient instance;

    public static RestClient getInstance() {
        if (instance == null) {
            instance = new RestClient();
        }
        return instance;
    }

    public RestClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.API_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        apiRest = restAdapter.create(ApiRest.class);
    }

    @Nullable
    public ApiRest getService() {
        return apiRest;
    }
}
