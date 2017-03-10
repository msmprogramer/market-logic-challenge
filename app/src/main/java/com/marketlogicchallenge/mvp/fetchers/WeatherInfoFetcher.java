package com.marketlogicchallenge.mvp.fetchers;

import com.marketlogicchallenge.data.RestClient;
import com.marketlogicchallenge.model.WeatherResponse;
import com.marketlogicchallenge.mvp.OnFinishedListener;
import com.marketlogicchallenge.utils.Constants;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by msalama on 3/10/17.
 */

public class WeatherInfoFetcher {

    public static WeatherInfoFetcher newInstance() {

        return new WeatherInfoFetcher();
    }


    public void fetchWeatherInfo(String cityName, final OnFinishedListener<WeatherResponse> listener) {

        RestClient.
                getInstance().
                getService().
                listWeatherInfo(cityName, Constants.API_ID, new Callback<WeatherResponse>() {
            @Override
            public void success(WeatherResponse weatherResponse, Response response) {

                listener.onSuccess(weatherResponse);

            }

            @Override
            public void failure(RetrofitError error) {

                listener.onFailure();
            }
        });
    }
}
