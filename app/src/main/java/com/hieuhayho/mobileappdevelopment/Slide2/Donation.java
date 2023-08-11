package com.hieuhayho.mobileappdevelopment.Slide2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.ProgressBar;

import com.hieuhayho.mobileappdevelopment.R;

public class Donation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        NumberPicker numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(2000);
        numberPicker.setValue(1000);

        numberPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
            // Handle value change here
        });

        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(20);
    }
}