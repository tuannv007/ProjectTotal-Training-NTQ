package com.example.admin.project1final;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by admin on 7/24/2016.
 */
public abstract class MyActivity extends AppCompatActivity {
    void changeFragment(Fragment myFragment, String Tag){
        getSupportFragmentManager().beginTransaction().replace(R.id.main,myFragment,Tag).addToBackStack(null).commit();
    }
}
