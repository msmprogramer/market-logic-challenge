package com.marketlogicchallenge.mvp.fetchers;

import com.google.common.annotations.VisibleForTesting;
import com.marketlogicchallenge.model.WeatherResponse;
import com.marketlogicchallenge.mvp.OnFinishedListener;

/**
 * Created by mohammed.salama on 3/12/2017.
 */

public class FakeWeatherInfoFetcherImpl implements WeatherInfoFetcher {

    private static WeatherResponse WEATHER_RESPONSE;
    private static boolean IS_SUCCESS_RESPONSE;

    public static FakeWeatherInfoFetcherImpl newInstance() {
        return new FakeWeatherInfoFetcherImpl();
    }

    @Override
    public void fetchWeatherInfo(String cityName, OnFinishedListener<WeatherResponse> listener) {
        if (IS_SUCCESS_RESPONSE) {
            listener.onSuccess(WEATHER_RESPONSE);
        } else {
            listener.onFailure();
        }

    }

    @VisibleForTesting
    public static void setWeatherResponse(WeatherResponse weatherResponse) {
        WEATHER_RESPONSE= weatherResponse;
    }

    @VisibleForTesting
    public static void setIsSuccessResponse(boolean isSuccessResponse) {
        IS_SUCCESS_RESPONSE= isSuccessResponse;
    }

}
