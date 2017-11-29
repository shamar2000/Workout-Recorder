package com.wpmdesignstudio.tabswithviewpagerandfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectExerciseListFragment extends ListFragment {

    /**
     * List of Exercises
     */
    public final String[] exercises = {
            "DEADLIFT",
            "BENCH PRESS",
            "SQUAT",
            "CABLE CURLS",
            "LEG PRESS",
            "PREACHER CURLS",
            "CONCENTRATION CURLS",
            "CALF RAISES",
            "SMITH MACHINE CALF RAISES",
            "MILITARY PRESS",
            "SEATED MILITARY PRESS",
            "SEATED DUMBBELL MILITARY PRESS"
    };

    ListView listView;
    ArrayList<String> listOfExercises = new ArrayList<>(Arrays.asList(exercises));


    public SelectExerciseListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_exercise, container, false);
        listView = (ListView) view.findViewById(android.R.id.list);
        return view;
    }

    /**
     * Bind data source to ArrayAdapter<String> and add ArrayAdapter to listView.
     *
     */

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,
                                    listOfExercises);
        listView.setAdapter(arrayAdapter);
        initOnListItemSelected();
    }

    /**
     * Set Listeners for items in listView (android.R.id.list)
     */

    public void initOnListItemSelected() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //TODO: Launch WorkoutRecorder Activity
                startActivity(new Intent(getContext(), WorkoutRecorderActivity.class));
            }
        });
    }
}
