package com.hieuhayho.mobileappdevelopment.Slide6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hieuhayho.mobileappdevelopment.R;

public class ContextMenuDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        View myView = findViewById(R.id.button);
        registerForContextMenu(myView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.context_item1)
            Toast.makeText(ContextMenuDemo.this, "This is a message 1", Toast.LENGTH_LONG).show();
        else if (id == R.id.context_item2)
            Toast.makeText(ContextMenuDemo.this, "This is a message 2", Toast.LENGTH_LONG).show();
        else
            return super.onOptionsItemSelected(item);
        return true;
    }
}