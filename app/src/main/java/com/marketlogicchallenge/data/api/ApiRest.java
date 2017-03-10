package com.marketlogicchallenge.data.api;


import com.marketlogicchallenge.model.WeatherResponse;


import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by msalama on 3/10/17.
 */

public interface ApiRest {

    @GET("/data/2.5/weather")
    void listWeatherInfo(@Query("q") String cityName,
                     @Query("appid") String appId,
                     Callback<WeatherResponse> callback);
}
