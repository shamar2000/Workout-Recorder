package com.wpmdesignstudio.tabswithviewpagerandfragments;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class WorkoutRecorderActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_recorder);
        initXML();
        setupTabs();
    }

    private void setupTabs() {

    }

    private void initXML() {
        tabLayout = (TabLayout) findViewById(R.id.workout_recorder_activity_tabLayout);
        viewPager = (ViewPager) findViewById(R.id.workout_recorder_activity_viewpager);
        toolbar = (Toolbar) findViewById(R.id.workout_recorder_activity_toolbar);
        setSupportActionBar(toolbar);
        tabLayout.setupWithViewPager(viewPager);
    }
}