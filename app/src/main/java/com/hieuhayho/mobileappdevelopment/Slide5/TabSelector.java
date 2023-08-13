package com.hieuhayho.mobileappdevelopment.Slide5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;

import com.hieuhayho.mobileappdevelopment.R;

public class TabSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_selector);

        TabHost tabs=(TabHost)findViewById(R.id.tabHost);
        tabs.setup();

        TabHost.TabSpec spec;
        spec =tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("1-Clock");
        tabs.addTab(spec);

        TabHost.TabSpec spec2;
        spec2=tabs.newTabSpec("tag2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("2-Login");
        tabs.addTab(spec2);

        tabs.setCurrentTab(0);

    }
}