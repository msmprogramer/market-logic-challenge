package com.marketlogicchallenge.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.marketlogicchallenge.R;

/**
 * Created by msalama on 3/10/17.
 */

public class WeatherActivityList extends AppCompatActivity {


    public static final String EXTRA_CITY_NAME = "extraCityname";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

    }
}