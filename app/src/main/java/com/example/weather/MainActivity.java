package com.example.weather;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {
    private Button btnGetWeather;
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMessage(getString(R.string.str_toast_create));
        Log.i(TAG, getString(R.string.str_toast_create));

        btnGetWeather = findViewById(R.id.btn_get_weather);
        btnGetWeather.setOnClickListener(new View.OnClickListener() {
            Intent startNewIntentWeather = new Intent(MainActivity.this, GetWeather.class);

            @Override
            public void onClick(View v) {
                startActivity(startNewIntentWeather);
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
