package com.example.weather;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

import static android.provider.Telephony.Mms.Part.TEXT;

public class GetWeather extends BaseActivity {
    private int gradus;
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        showMessage(getString(R.string.str_toast_create_get_weather));

        Random rand = new Random();
        String text = getIntent().getExtras().getString(TEXT);
        String strrain = getIntent().getExtras().getString(getString(R.string.set_rain));
        String strfog = getIntent().getExtras().getString(getString(R.string.set_fog));
        String strwind = getIntent().getExtras().getString(getString(R.string.set_wind));
        String strswchsuncloud = getIntent().getExtras().getString(getString(R.string.set_switch_sun));

        TextView city = findViewById(R.id.city);
        TextView rine = findViewById(R.id.rain);
        TextView fog = findViewById(R.id.fog);
        TextView wind = findViewById(R.id.wind);
        TextView suncloud = findViewById(R.id.sun_cloud);
        TextView degree = findViewById(R.id.weatherView);

        city.setText(text);
        rine.setText(strrain);
        fog.setText(strfog);
        wind.setText(strwind);
        suncloud.setText(strswchsuncloud);


        gradus = rand.nextInt(30);
        String endview = gradus + " " + getString(R.string.circle) + getString(R.string.str_degree);
        degree.setText(endview);


    }

    @Override
    protected void onResume() {
        super.onResume();
        showMessage(getString(R.string.str_toast_resume));
        Log.i(TAG, getString(R.string.str_toast_resume));
    }

    @Override
    protected void onStart() {
        super.onStart();
        showMessage(getString(R.string.str_toast_start));
        Log.i(TAG, getString(R.string.str_toast_start));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showMessage(getString(R.string.str_toast_restart));
        Log.i(TAG, getString(R.string.str_toast_restart));
    }

    @Override
    protected void onPause() {
        super.onPause();
        showMessage(getString(R.string.str_toast_pause));
        Log.i(TAG, getString(R.string.str_toast_pause));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showMessage(getString(R.string.str_toast_destroy));
        Log.i(TAG, getString(R.string.str_toast_destroy));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showMessage(getString(R.string.str_toast_back_pressed));
        Log.i(TAG, getString(R.string.str_toast_back_pressed));
    }
}
