package com.example.weather;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import java.util.Random;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static com.example.weather.CoatOfArmsFragment.PARCEL;


public class GetWeather extends BaseActivity {
    private int gradus;
    private final String TAG = this.getClass().getSimpleName();

    private String text;
    private String str_rain;
    private String str_fog;
    private String str_wind;
    private String str_switch;

    private TextView city;
    private TextView rain;
    private TextView fog;
    private TextView wind;
    private TextView suncloud;
    private TextView degree;


    public static Intent start(@NonNull Context context, @NonNull CityIndex parcel) {
        Intent intent = new Intent(context, GetWeather.class);
        intent.putExtra(PARCEL, parcel);

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

        Random rand = new Random();
        text = getIntent().getExtras().getString(getString(R.string.str_message_not_null));
        str_rain = getIntent().getExtras().getString(getString(R.string.set_rain));
        str_fog = getIntent().getExtras().getString(getString(R.string.set_fog));
        str_wind = getIntent().getExtras().getString(getString(R.string.set_wind));
        str_switch = getIntent().getExtras().getString(getString(R.string.set_switch));

        city = findViewById(R.id.tv_chosen_city);
        rain = findViewById(R.id.rain);
        fog = findViewById(R.id.fog);
        wind = findViewById(R.id.wind);
        suncloud = findViewById(R.id.sun_cloud);
        degree = findViewById(R.id.weatherView);

        city.setText(text);
        rain.setText(str_rain);
        fog.setText(str_fog);
        wind.setText(str_wind);
        suncloud.setText(str_switch);

        gradus = rand.nextInt(30);
        StringBuilder endview = new StringBuilder(gradus + " ");
        endview.append(getString(R.string.circle)).append(getString(R.string.str_degree));
        degree.setText(endview);
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
