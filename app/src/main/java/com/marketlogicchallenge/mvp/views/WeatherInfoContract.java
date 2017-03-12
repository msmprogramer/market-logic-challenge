package com.marketlogicchallenge.mvp.views;

import com.marketlogicchallenge.model.Weather;

import java.util.List;

/**
 * Created by msalama on 3/10/17.
 */

public interface WeatherInfoContract {

    interface View {

        void showProgress();

        void showWeatherList(List<Weather> items);

        void showCityName(String cityName);

        void showTodayDate(String todayDate);

        void showTemperature(String temperature);

        void showPressure(String pressure);

        void showFailureMessage();

        void hideProgress();
    }

    interface UserActionsListener {

        void loadWeatherInfo(String cityName);

        void stopPresenter();
    }

}
