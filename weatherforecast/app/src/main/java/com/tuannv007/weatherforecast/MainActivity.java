package com.tuannv007.weatherforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import location.CityLocation;
import location.MyDefaultLocation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.main,new MyDefaultLocation(),NameFragment.myLocation).commit();
    }
}
