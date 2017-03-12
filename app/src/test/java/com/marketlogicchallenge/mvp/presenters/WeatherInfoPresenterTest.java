package com.marketlogicchallenge.mvp.presenters;

import com.google.common.collect.Lists;
import com.marketlogicchallenge.model.Weather;
import com.marketlogicchallenge.model.WeatherResponse;
import com.marketlogicchallenge.mvp.OnFinishedListener;
import com.marketlogicchallenge.mvp.fetchers.WeatherInfoFetcher;
import com.marketlogicchallenge.mvp.views.WeatherInfoContract;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by mohammed.salama on 3/12/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class WeatherInfoPresenterTest {

    private static WeatherResponse weatherResponse = new WeatherResponse();

    @Mock
    private WeatherInfoContract.View view;

    @Mock
    private WeatherInfoFetcher weatherInfoFetcher;

    private WeatherInfoPresenter weatherInfoPresenter;

    @Captor
    private ArgumentCaptor<OnFinishedListener<WeatherResponse>> callBack;



    private String cityName = "egypt";

    @Before
    public void setUp() throws Exception {
        weatherInfoPresenter = new WeatherInfoPresenter(view, weatherInfoFetcher);
        weatherInfoPresenter.loadWeatherInfo(cityName);

        weatherResponse.setWeather(Lists.newArrayList(new Weather()));
    }



    @Test
    public void loadWeatherInfo() throws Exception {
        verify(view).showProgress();

        verify(weatherInfoFetcher).fetchWeatherInfo(anyString(), callBack.capture());

        callBack.getValue().onSuccess(weatherResponse);

        verify(view).hideProgress();

        verify(view).showWeatherList(weatherResponse.getWeather());
    }

    @Test
    public void loadWeatherInfoAndShowFailureMessage() {

        verify(view).showProgress();

        verify(weatherInfoFetcher).fetchWeatherInfo(anyString(), callBack.capture());

        callBack.getValue().onFailure();

        verify(view).hideProgress();

        verify(view).showFailureMessage();
    }


    @Test
    public void stopPresenter() throws Exception {

    }

}