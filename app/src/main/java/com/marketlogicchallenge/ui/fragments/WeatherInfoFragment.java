package com.marketlogicchallenge.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.marketlogicchallenge.Injection;
import com.marketlogicchallenge.R;
import com.marketlogicchallenge.adapter.WeatherInfoAdapter;
import com.marketlogicchallenge.model.Weather;
import com.marketlogicchallenge.mvp.presenters.WeatherInfoPresenter;
import com.marketlogicchallenge.mvp.views.WeatherInfoContract;
import com.marketlogicchallenge.ui.activities.WeatherActivityList;

import java.util.Collections;
import java.util.List;

/**
 * Created by msalama on 3/10/17.
 */

public class WeatherInfoFragment extends Fragment implements WeatherInfoContract.View {

    private static final String TAG = "WeatherInfoFragment";

    private static final int NUM_GRID_COLUMNS = 2;

    private ProgressBar progressBarLoading;
    private WeatherInfoPresenter presenter;
    private WeatherInfoAdapter weatherListAdapter;

    private TextView txtCityName;
    private TextView txtTemp;
    private TextView txtPressure;
    private TextView txtTodayDate;

    private String cityName;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cityName = getActivity().getIntent().getStringExtra(WeatherActivityList.EXTRA_CITY_NAME);

        weatherListAdapter = new WeatherInfoAdapter(
                getActivity(),
                Collections.<Weather>emptyList()
        );

        presenter = new WeatherInfoPresenter(
                this,
                Injection.getWeatherFetcherInstance()
        );


    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_weather_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtCityName = (TextView) view.findViewById(R.id.txtCityName);
        txtTemp = (TextView) view.findViewById(R.id.txtTemp);
        txtPressure = (TextView) view.findViewById(R.id.txtPressure);
        txtTodayDate = (TextView) view.findViewById(R.id.txtTodayDate);

        //init recycle view

        RecyclerView weatherList =
                (RecyclerView) view.findViewById(R.id.weatherInfoList);


        weatherList.setHasFixedSize(true);
        weatherList.setLayoutManager(new GridLayoutManager(getActivity(), NUM_GRID_COLUMNS));

        weatherList.setAdapter(weatherListAdapter);

        progressBarLoading = (ProgressBar) view.findViewById(R.id.progress_bar_loading);

    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadWeatherInfo(cityName);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.stopPresenter();
    }

    @Override
    public void showProgress() {
        progressBarLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void showWeatherList(List<Weather> items) {
        weatherListAdapter.replaceData(items);
    }

    @Override
    public void showCityName(String cityName) {
        txtCityName.setText(String.format(getString(R.string.city_name), cityName));
    }

    @Override
    public void showTodayDate(String todayDate) {
        txtTodayDate.setText(String.format(getString(R.string.today_date), todayDate));
    }

    @Override
    public void showTemperature(String temperature) {
        txtTemp.setText(String.format(getString(R.string.temperature), temperature));
    }

    @Override
    public void showPressure(String pressure) {
        txtPressure.setText(String.format(getString(R.string.pressure), pressure));
    }

    @Override
    public void showFailureMessage() {
        Snackbar.make(
                getView(),
                getString(R.string.error_failed_load_message),
                Snackbar.LENGTH_SHORT
        ).show();
    }

    @Override
    public void hideProgress() {
        progressBarLoading.setVisibility(View.GONE);
    }

}
