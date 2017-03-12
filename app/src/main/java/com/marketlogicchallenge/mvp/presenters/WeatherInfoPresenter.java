package com.marketlogicchallenge.mvp.presenters;

import android.support.annotation.Nullable;

import com.marketlogicchallenge.model.WeatherResponse;
import com.marketlogicchallenge.mvp.OnFinishedListener;
import com.marketlogicchallenge.mvp.fetchers.WeatherInfoFetcher;
import com.marketlogicchallenge.mvp.views.WeatherInfoContract;
import com.marketlogicchallenge.utils.Utils;

/**
 * Created by msalama on 3/10/17.
 */

public class WeatherInfoPresenter implements WeatherInfoContract.UserActionsListener {

    private WeatherInfoContract.View view;
    private WeatherInfoFetcher weatherInfoFetcher;

    public WeatherInfoPresenter(WeatherInfoContract.View view, WeatherInfoFetcher weatherInfoFetcher) {
        this.view = view;
        this.weatherInfoFetcher = weatherInfoFetcher;
    }

    @Override
    public void loadWeatherInfo(String cityName) {

        view.showProgress();

        weatherInfoFetcher.fetchWeatherInfo(cityName, new OnFinishedListener<WeatherResponse>() {
            @Override
            public void onSuccess(@Nullable WeatherResponse data) {

                if (view == null) {
                    return;
                }

                if (data == null) {
                    return;
                }

                view.hideProgress();

                if (data.getWeather() != null) {
                    view.showWeatherList(data.getWeather());
                }

                if (data.getName() != null) {
                    view.showCityName(data.getName());
                }

                if (data.getDt() != null) {

                    String todayDate = Utils.getTodayDate();

                    view.showTodayDate(todayDate);
                }

                if (data.getMain() != null) {

                    if (data.getMain().getTemp() != null) {

                        view.showTemperature(
                                String.valueOf(data.getMain().getTemp())
                        );

                    }

                    if (data.getMain().getPressure() != null) {

                        view.showPressure(
                                String.valueOf(data.getMain().getPressure())
                        );

                    }
                }

            }

            @Override
            public void onFailure() {

                if (view == null) {
                    return;
                }

                view.hideProgress();

                view.showFailureMessage();
            }
        });
    }

    @Override
    public void stopPresenter() {
        view = null;
    }
}
