package com.hieuhayho.mobileappdevelopment.Slide12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hieuhayho.mobileappdevelopment.R;
import com.hieuhayho.mobileappdevelopment.Slide10.ContentResolverActivity;

public class AcceleroMeter extends AppCompatActivity {

    static final int BODY_SENSOR_CODE_REQ = 1;
    TextView sensorPosition;
    Button listenSensorBtn;

    boolean isListening = false;

    SensorManager sensorManager;
    Sensor accelerometer;
    SensorEventListener accelerometerListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            sensorPosition.setText("(" + x + "; " + y + ": " + z + ")");
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // Handle accuracy changes if needed
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelero_meter);

        sensorPosition = findViewById(R.id.sensorPosition);
        listenSensorBtn = findViewById(R.id.listenSensorBtn);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        listenSensorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (accelerometer == null) {
                    Toast.makeText(AcceleroMeter.this, "No accelerometer sensor.", Toast.LENGTH_LONG).show();
                    return;
                }

                if (ContextCompat.checkSelfPermission(AcceleroMeter.this, Manifest.permission.BODY_SENSORS)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(AcceleroMeter.this,
                            new String[]{Manifest.permission.BODY_SENSORS},
                            BODY_SENSOR_CODE_REQ);
                } else {
                    HandleSensor();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case BODY_SENSOR_CODE_REQ:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    HandleSensor();
                break;
        }
    }

    void HandleSensor() {
        if (!isListening) {
            RegisterSensor();
        } else {
            UnRegisterSensor();
        }
    }
    void RegisterSensor() {
        isListening = true;
        listenSensorBtn.setText("UNLINK FROM ACCELEROMETER SENSOR");
        sensorManager.registerListener(accelerometerListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    void UnRegisterSensor() {
        isListening = false;
        listenSensorBtn.setText("LINK TO ACCELEROMETER SENSOR");
        sensorManager.unregisterListener(accelerometerListener);
    }
}