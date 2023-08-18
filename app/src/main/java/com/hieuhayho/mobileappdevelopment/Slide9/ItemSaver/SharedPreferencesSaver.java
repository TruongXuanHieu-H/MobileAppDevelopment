package com.hieuhayho.mobileappdevelopment.Slide9.ItemSaver;

import android.content.SharedPreferences;
import android.widget.Toast;


public class SharedPreferencesSaver extends ItemSaver {
    public static final String PREFS_NAME = "PlayerPref";
    @Override
    protected void OnSaveButtonClicked() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(variableName.getText().toString(), editValue.getText().toString());
        editor.commit();
    }

    @Override
    protected void OnGetButtonClicked() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if (!settings.contains(variableName.getText().toString())) {
            Toast.makeText(SharedPreferencesSaver.this, "No saved variable names " + variableName.getText().toString() , Toast.LENGTH_SHORT).show();
            savedValue.setText("Value not found");
        } else {
            savedValue.setText(settings.getString(variableName.getText().toString(), "Value not found"));
        }
    }
}
