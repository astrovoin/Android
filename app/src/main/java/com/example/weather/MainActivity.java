package com.example.weather;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends BaseActivity {
    private Button btnGetWeather;
    private CheckBox rain;
    private CheckBox fog;
    private CheckBox wind;
    private Switch swch;
    private final String TAG = this.getClass().getSimpleName();

    private String in_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMessage(TAG, getString(R.string.str_toast_create));

        btnGetWeather = findViewById(R.id.btn_get_weather);
        rain = findViewById(R.id.checkBoxRain);
        fog = findViewById(R.id.checkBoxFog);
        wind = findViewById(R.id.checkBoxWind);
        swch = findViewById(R.id.switch1);

        btnGetWeather.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startNewIntentWeather = new Intent(MainActivity.this, GetWeather.class);
                EditText txt = findViewById(R.id.editText);

                in_txt = txt.getText().toString();

                if (!in_txt.equals("")) {
                    if (rain.isChecked()) {
                        startNewIntentWeather.putExtra(getString(R.string.set_rain), getString(R.string.set_rain));
                    }
                    if (fog.isChecked()) {
                        startNewIntentWeather.putExtra(getString(R.string.set_fog), getString(R.string.set_fog));
                    }
                    if (wind.isChecked()) {
                        startNewIntentWeather.putExtra(getString(R.string.set_wind), getString(R.string.set_wind));
                    }
                    if (swch.isChecked()) {
                        startNewIntentWeather.putExtra(getString(R.string.set_switch), getString(R.string.set_switch_cloud));
                    } else {
                        startNewIntentWeather.putExtra(getString(R.string.set_switch), getString(R.string.set_switch_sun));
                    }
                    startNewIntentWeather.putExtra(getString(R.string.str_message_not_null), txt.getText().toString());
                    startActivity(startNewIntentWeather);
                } else showToast(getString(R.string.str_message_not_null));
            }
        });
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
