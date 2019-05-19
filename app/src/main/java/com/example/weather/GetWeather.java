package com.example.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GetWeather extends BaseActivity {
    private Button clickWeather;
    private int gradus;
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        showMessage(getString(R.string.str_toast_create_get_weather));

        clickWeather = findViewById(R.id.button);
        clickWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                TextView textView = findViewById(R.id.weatherView);
                gradus = rand.nextInt(30);
                textView.setText(gradus + " " + getString(R.string.circle) + getString(R.string.str_degree));
                // Как в этом случае использовать строку ресурсов с заполнителями?
            }
        });
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
