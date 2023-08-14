package com.hieuhayho.mobileappdevelopment.Slide6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.hieuhayho.mobileappdevelopment.R;

public class OptionMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1)
            Toast.makeText(OptionMenu.this, "This is a message 1", Toast.LENGTH_LONG).show();
        else if (id == R.id.item2)
            Toast.makeText(OptionMenu.this, "This is a message 2", Toast.LENGTH_LONG).show();
        else if (id == R.id.item3)
            Toast.makeText(OptionMenu.this, "This is a message 3", Toast.LENGTH_LONG).show();
        else if (id == R.id.item4)
            Toast.makeText(OptionMenu.this, "This is a message 4", Toast.LENGTH_LONG).show();
        else if (id == R.id.Item4_1)
            Toast.makeText(OptionMenu.this, "This is a message 4.1", Toast.LENGTH_LONG).show();
        else if (id == R.id.Item4_2)
            Toast.makeText(OptionMenu.this, "This is a message 4.2", Toast.LENGTH_LONG).show();
        else
            return super.onOptionsItemSelected(item);
        return true;
    }
}