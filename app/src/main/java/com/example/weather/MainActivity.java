package com.example.weather;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import static android.provider.Telephony.Mms.Part.TEXT;

public class MainActivity extends BaseActivity {
    private Button btnGetWeather;
    private CheckBox rain;
    private CheckBox fog;
    private CheckBox wind;
    private Switch swch;
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMessage(getString(R.string.str_toast_create));
        Log.i(TAG, getString(R.string.str_toast_create));

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


                String strrain = getString(R.string.set_rain);
                String strfog = getString(R.string.set_fog);
                String strwind = getString(R.string.set_wind);
                String strswchsun = getString(R.string.set_switch_sun);
                String strswchcloud = getString(R.string.set_switch_cloud);
                String in_txt = txt.getText().toString();
                //Parcel parcel = new Parcel();

                if (!in_txt.equals("")) {
                    if (rain.isChecked()) {
                        startNewIntentWeather.putExtra(strrain, strrain);
                    }
                    if (fog.isChecked()) {
                        startNewIntentWeather.putExtra(strfog, strfog);
                    }
                    if (wind.isChecked()) {
                        startNewIntentWeather.putExtra(strwind, strwind);
                    }

                    if (swch.isChecked()) {
                        startNewIntentWeather.putExtra(strswchsun, strswchcloud);
                    } else {
                        startNewIntentWeather.putExtra(strswchsun, strswchsun);
                    }
                    startNewIntentWeather.putExtra(TEXT, txt.getText().toString());
                    startActivity(startNewIntentWeather);
                } else showMessage(getString(R.string.str_message_not_null));
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
