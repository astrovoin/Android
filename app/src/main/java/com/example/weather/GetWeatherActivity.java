package com.example.weather;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static com.example.weather.CoatOfArmsFragment.CITY;
import static com.example.weather.CoatOfArmsFragment.CONDITION;
import static com.example.weather.CoatOfArmsFragment.PARCEL;


public class GetWeatherActivity extends BaseActivity {
    private final String TAG = this.getClass().getSimpleName();

    private int gradus;

    private String text;
    private String textFromEdTx;
    private String strRain;
    private String strFog;
    private String strWind;
    private String str_switchFromEdTx;
    private String str_switch;

    private TextView city;
    private TextView rain;
    private TextView fog;
    private TextView wind;
    private TextView sunCloud;
    private TextView degree;
    private TextView pressure;

    private ImageView btnHistoryWeather;

    public static Intent start(@NonNull Context context, @NonNull CityIndex parcel) {
        Intent intent = new Intent(context, GetWeatherActivity.class);
        intent.putExtra(PARCEL, parcel);
        intent.putExtra(CITY, parcel.getCityName());
        intent.putExtra(CONDITION, parcel.getCondition());

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {

            finish();
            return;
        }
        setContentView(R.layout.activity_weather);

        showMessage(TAG, getString(R.string.str_toast_create_get_weather));

        if (getIntent().getExtras() == null) {
            return;
        }

        Random randTemp = new Random();
        text = getIntent().getExtras().getString(CITY);
        textFromEdTx = getIntent().getExtras().getString(getString(R.string.str_message_not_null));
        strRain = getIntent().getExtras().getString(getString(R.string.set_rain));
        strFog = getIntent().getExtras().getString(getString(R.string.set_fog));
        strWind = getIntent().getExtras().getString(getString(R.string.set_wind));
        str_switchFromEdTx = getIntent().getExtras().getString(getString(R.string.set_switch));
        str_switch = getIntent().getExtras().getString(CONDITION);
        btnHistoryWeather = findViewById(R.id.history_weather);

        city = findViewById(R.id.tv_chosen_city);
        rain = findViewById(R.id.rain);
        fog = findViewById(R.id.fog);
        wind = findViewById(R.id.wind);
        sunCloud = findViewById(R.id.sun_cloud);
        degree = findViewById(R.id.weatherView);
        pressure = findViewById(R.id.weatherViewPressure);

        if (text == null) {
            city.setText(textFromEdTx);
        } else city.setText(text);

        rain.setText(strRain);
        fog.setText(strFog);
        wind.setText(strWind);
        if (str_switch == null) {
            sunCloud.setText(str_switchFromEdTx);
        } else sunCloud.setText(str_switch);

        gradus = randTemp.nextInt(30);
        String strGradus = String.valueOf(gradus);
        StringBuilder endView = new StringBuilder(strGradus);
        endView.append(getString(R.string.empty_string)).append(getString(R.string.circle)).append(getString(R.string.str_degree));
        degree.setText(endView);

        String strPressure = getString(R.string.str_pressure);
        StringBuilder strPressureFull = new StringBuilder(strPressure);
        strPressureFull.append(getString(R.string.empty_string)).append(getString(R.string.str_mm_of_mercury));
        pressure.setText(strPressureFull);

        btnHistoryWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startNewIntentHistoryWeather = new Intent(GetWeatherActivity.this, HistoryWeatherActivity.class);
                startActivity(startNewIntentHistoryWeather);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onResume() {
        super.onResume();
        showMessage(TAG, getString(R.string.str_toast_resume));
    }

    @Override
    protected void onStart() {
        super.onStart();
        showMessage(TAG, getString(R.string.str_toast_start));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showMessage(TAG, getString(R.string.str_toast_restart));
    }

    @Override
    protected void onPause() {
        super.onPause();
        showMessage(TAG, getString(R.string.str_toast_pause));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showMessage(TAG, getString(R.string.str_toast_destroy));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showMessage(TAG, getString(R.string.str_toast_back_pressed));
    }
}
