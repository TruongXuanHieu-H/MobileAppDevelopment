package com.hieuhayho.mobileappdevelopment.Slide12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hieuhayho.mobileappdevelopment.R;

public class ConnectivityManagerActivity extends AppCompatActivity {

    static final int CONNECTIVITY_CODE_REQ = 1;
    ConnectivityManager connectivity;
    Button getNetworkBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connectivity_manager);

        connectivity = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        getNetworkBtn = findViewById(R.id.getNetworkBtn);

        getNetworkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(ConnectivityManagerActivity.this, Manifest.permission.ACCESS_NETWORK_STATE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ConnectivityManagerActivity.this,
                            new String[]{Manifest.permission.ACCESS_NETWORK_STATE},
                            CONNECTIVITY_CODE_REQ);
                } else {
                    CheckNetworkState();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CONNECTIVITY_CODE_REQ:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    CheckNetworkState();
                break;
        }
    }
    void CheckNetworkState() {
        NetworkInfo activeNetwork = connectivity.getActiveNetworkInfo();
        Toast.makeText(ConnectivityManagerActivity.this, "Connected through " + getNetworkTypeAsString(activeNetwork.getType()), Toast.LENGTH_LONG).show();
    }

    String getNetworkTypeAsString(int networkType) {
        switch (networkType) {
            case ConnectivityManager.TYPE_WIFI:
                return "Wi-Fi";
            case ConnectivityManager.TYPE_MOBILE:
                return "Mobile";
            case ConnectivityManager.TYPE_ETHERNET:
                return "Ethernet";
            case ConnectivityManager.TYPE_BLUETOOTH:
                return "Bluetooth";
            // Add more cases if needed
            default:
                return "Unknown";
        }
    }
}