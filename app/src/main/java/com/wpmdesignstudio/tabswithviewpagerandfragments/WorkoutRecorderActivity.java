package com.wpmdesignstudio.tabswithviewpagerandfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WorkoutRecorderActivity extends AppCompatActivity {

    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_recorder);
        title = "Name";
        ((WorkoutRecorderActivity)this).getSupportActionBar().setTitle(title);
    }
}