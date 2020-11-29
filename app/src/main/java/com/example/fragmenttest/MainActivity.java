package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        WorkoutDetailFragment frag = (WorkoutDetailFragment)getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        frag.setWorkout(0);
    }
}