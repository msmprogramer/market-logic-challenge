package com.marketlogicchallenge.mvp.fetchers;

import com.marketlogicchallenge.model.WeatherResponse;
import com.marketlogicchallenge.mvp.OnFinishedListener;

/**
 * Created by mohammed.salama on 3/12/2017.
 */

public interface WeatherInfoFetcher {

    void fetchWeatherInfo(String cityName, final OnFinishedListener<WeatherResponse> listener);

}
