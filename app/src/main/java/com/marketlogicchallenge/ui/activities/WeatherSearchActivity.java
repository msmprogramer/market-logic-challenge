package com.marketlogicchallenge.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.marketlogicchallenge.R;

/**
 * Created by msalama on 3/10/17.
 */

public class WeatherSearchActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weather_search);

        final EditText edtSearchCityName = (EditText) findViewById(R.id.edtSearchCityName);

        Button btnSearchName = (Button) findViewById(R.id.btnSearch);

        btnSearchName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(WeatherSearchActivity.this, WeatherActivityList.class);

                intent.putExtra(WeatherActivityList.EXTRA_CITY_NAME, edtSearchCityName.getText().toString());

                startActivity(intent);
            }
        });

    }
}
