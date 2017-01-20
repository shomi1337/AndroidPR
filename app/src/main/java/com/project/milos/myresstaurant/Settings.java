package com.project.milos.myresstaurant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.project.milos.myresstaurant.R;

/**
 * Created by Miloš on 1/11/2017.
 */

public class Settings extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }

}
