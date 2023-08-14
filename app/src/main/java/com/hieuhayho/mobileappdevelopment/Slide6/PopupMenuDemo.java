package com.hieuhayho.mobileappdevelopment.Slide6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.hieuhayho.mobileappdevelopment.R;

public class PopupMenuDemo extends AppCompatActivity {

    Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu_demo);
        btn1 = findViewById(R.id.checkmebtn);
        btn2 = findViewById(R.id.anchorbtn);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                button1Clicked();
            }
        });
    }

    protected  void button1Clicked() {
        PopupMenu popupMenu = new PopupMenu(this, this.btn2);
        popupMenu.inflate(R.menu.popup_menu);

        Menu menu = popupMenu.getMenu();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.context_item1)
                    Toast.makeText(PopupMenuDemo.this, "This is a message 1", Toast.LENGTH_LONG).show();
                else if (id == R.id.context_item2)
                    Toast.makeText(PopupMenuDemo.this, "This is a message 2", Toast.LENGTH_LONG).show();
                else
                    return false;
                return true;
            }
        });

        popupMenu.show();
    }
}