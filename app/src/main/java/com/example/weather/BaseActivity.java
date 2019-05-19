package com.example.weather;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    public void showMessage (@NonNull String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
}
