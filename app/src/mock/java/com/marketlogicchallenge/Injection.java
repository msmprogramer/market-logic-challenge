package com.marketlogicchallenge;

import com.marketlogicchallenge.mvp.fetchers.FakeWeatherInfoFetcherImpl;
import com.marketlogicchallenge.mvp.fetchers.WeatherInfoFetcher;

/**
 * Created by mohammed.salama on 3/12/2017.
 */

public class Injection {

    private Injection() {
        // no instance
    }

    public synchronized static WeatherInfoFetcher getWeatherFetcherInstance() {
        return FakeWeatherInfoFetcherImpl.newInstance();
    }

}
