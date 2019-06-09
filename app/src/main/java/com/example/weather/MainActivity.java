package com.example.weather;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends BaseActivity {
    private final String TAG = this.getClass().getSimpleName();

    private Button btnGetWeather;

    private CheckBox isRain;
    private CheckBox isFog;
    private CheckBox isWind;
    public Switch switchSunCloud;

    private String inputText;
    private int countSymbol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMessage(TAG, getString(R.string.str_toast_create));

        btnGetWeather = findViewById(R.id.btn_get_weather);
        isRain = findViewById(R.id.checkBoxRain);
        isFog = findViewById(R.id.checkBoxFog);
        isWind = findViewById(R.id.checkBoxWind);
        switchSunCloud = findViewById(R.id.switch_sun_cloud);


        EditText txt = findViewById(R.id.editText);
        countSymbol = getResources().getInteger(R.integer.count_symbol);
        txt.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() > countSymbol) {
                    showToast(getString(R.string.str_toast_more_symbol));
                }
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });

        btnGetWeather.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startNewIntentWeather = new Intent(MainActivity.this, GetWeatherActivity.class);
                EditText txt = findViewById(R.id.editText);


                inputText = txt.getText().toString();
                if (!inputText.equals("")) {
                    if (isRain.isChecked()) {
                        startNewIntentWeather.putExtra(getString(R.string.set_rain), getString(R.string.set_rain));
                    }
                    if (isFog.isChecked()) {
                        startNewIntentWeather.putExtra(getString(R.string.set_fog), getString(R.string.set_fog));
                    }
                    if (isWind.isChecked()) {
                        startNewIntentWeather.putExtra(getString(R.string.set_wind), getString(R.string.set_wind));
                    }
                    if (switchSunCloud.isChecked()) {
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
