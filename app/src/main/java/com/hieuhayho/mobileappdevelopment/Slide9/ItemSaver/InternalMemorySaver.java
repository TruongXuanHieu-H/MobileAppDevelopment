package com.hieuhayho.mobileappdevelopment.Slide9.ItemSaver;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class InternalMemorySaver extends ItemSaver {
    @Override
    protected void OnSaveButtonClicked() {
        String FILENAME = variableName.getText().toString();
        String DATA = editValue.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(DATA.getBytes());
            fos.close();
        } catch (Exception e) {
            Toast.makeText(InternalMemorySaver.this, "No file names " + variableName.getText().toString() , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void OnGetButtonClicked() {
        try {
            FileInputStream fis = this.openFileInput(variableName.getText().toString());
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            savedValue.setText(sb.toString());
            fis.close();
        } catch (Exception e) {
            Toast.makeText(InternalMemorySaver.this, "No file names " + variableName.getText().toString() , Toast.LENGTH_SHORT).show();
        }

    }
}
