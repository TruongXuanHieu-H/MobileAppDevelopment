package com.hieuhayho.mobileappdevelopment.Slide9.ItemSaver;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hieuhayho.mobileappdevelopment.R;

public abstract class ItemSaver extends AppCompatActivity {
    protected EditText variableName;
    protected EditText editValue;
    protected TextView savedValue;
    protected Button saveValueButton;
    protected Button getValueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_saver);

        variableName = findViewById(R.id.variableName);
        editValue = findViewById(R.id.editValue);
        savedValue = findViewById(R.id.savedValue);
        saveValueButton = findViewById(R.id.saveButton);
        getValueButton = findViewById(R.id.getButton);

        saveValueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedValue.setText("");
                OnSaveButtonClicked();
            }
        });

        getValueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editValue.setText("");
                OnGetButtonClicked();
            }
        });
    }

    protected abstract void OnSaveButtonClicked();
    protected abstract void OnGetButtonClicked();
}
