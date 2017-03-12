package com.marketlogicchallenge;

import com.marketlogicchallenge.mvp.fetchers.WeatherInfoFetcher;
import com.marketlogicchallenge.mvp.fetchers.WeatherInfoFetcherImpl;

/**
 * Created by mohammed.salama on 3/12/2017.
 */

public class Injection {

    private Injection() {
        // no instance
    }

    public synchronized static WeatherInfoFetcher getWeatherFetcherInstance() {
        return WeatherInfoFetcherImpl.newInstance();
    }

}
