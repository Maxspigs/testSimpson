package com.example.pigeo.testsimpson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
        implements ListFragment.ListFramentInterface{

    private static final String TAG = "MainActivity";
    private ImageFragment imgFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgFrag = (ImageFragment)getSupportFragmentManager().findFragmentById(R.id.image);
    }

    @Override
    public void onItemSelected(int id) {
        Log.d(TAG, "onItemSelected");
        imgFrag.setImage(id);
    }
}
