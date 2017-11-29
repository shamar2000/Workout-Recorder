package com.wpmdesignstudio.tabswithviewpagerandfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WorkoutRecorderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityTitle("NEW TITLE");
        setContentView(R.layout.activity_workout_recorder);
    }

    public void setActivityTitle(String activityTitle) {
        getActivity().setActivityTitle(activityTitle);
    }

    private WorkoutRecorderActivity getActivity() {
        return this;
    }
}
