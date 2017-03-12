package com.marketlogicchallenge.ui.activities;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.marketlogicchallenge.R;
import com.marketlogicchallenge.model.WeatherResponse;
import com.marketlogicchallenge.mvp.fetchers.FakeWeatherInfoFetcherImpl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.marketlogicchallenge.ui.activities.WeatherActivityList.EXTRA_CITY_NAME;

/**
 * Created by mohammed.salama on 3/12/2017.
 */

@RunWith(AndroidJUnit4.class)
public class WeatherActivityListTest {

    private static final String CITY_NAME = "berlin";
    @Rule
    public ActivityTestRule<WeatherActivityList> activityActivityTestRule =
            new ActivityTestRule<>(WeatherActivityList.class, true, false);


    @Test
    public void showCityNameAfterLoadingWeatherInfo() {
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setName(CITY_NAME);

        FakeWeatherInfoFetcherImpl.newInstance();

        FakeWeatherInfoFetcherImpl.setWeatherResponse(weatherResponse);

        FakeWeatherInfoFetcherImpl.setIsSuccessResponse(true);

        launchActivity();

        onView(withId(R.id.txtCityName)).check(matches(withText(String.format("City Name: %s", CITY_NAME))));

    }

    private void launchActivity() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_CITY_NAME, CITY_NAME);
        activityActivityTestRule.launchActivity(intent);
    }

}