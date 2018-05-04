package com.wpmdesignstudio.tabswithviewpagerandfragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class TrackTabFragment extends Fragment {

     ListView listView;
     FloatingActionButton fab;
     EditText weightEditText;
     EditText repsEditText;
     private int setNumber = 1;
     private int counter = 0;

     Button saveBtn;
     Button deleteBtn;
     ArrayList<WorkoutInformation> workoutInformationArrayList;


    public TrackTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_track_layout, container, false);

        /*
         * Initialise XML attributes
         */
        weightEditText = (EditText) view.findViewById(R.id.weight_editText);
        repsEditText = (EditText) view.findViewById(R.id.reps_editTEXT);
        listView = (ListView) view.findViewById(R.id.list_of_workouts_listView);
        saveBtn = (Button) view.findViewById(R.id.save_workout_button);
        deleteBtn = (Button) view.findViewById(R.id.delete_workout_button);
        fab = (FloatingActionButton) view.findViewById(R.id.fab_TrackTabFragment);
        workoutInformationArrayList = new ArrayList<>();


        listView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // Display checkboxes for user to select workout(s) to delete
                return false;
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveWorkout();
                TrackTabFragmentListAdapter trackTabFragmentListAdapter = new TrackTabFragmentListAdapter
                        (getActivity(), R.layout.track_tab_fragment_list_view, workoutInformationArrayList);
                listView.setAdapter(trackTabFragmentListAdapter);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (workoutInformationArrayList.isEmpty()) {
                    Toast.makeText(getContext(), "List is empty", Toast.LENGTH_SHORT).show();
                } else {
                    workoutInformationArrayList.remove(0);
                    TrackTabFragmentListAdapter trackTabFragmentListAdapter = new TrackTabFragmentListAdapter
                            (getActivity(), R.layout.track_tab_fragment_list_view, workoutInformationArrayList);
                    listView.setAdapter(trackTabFragmentListAdapter);
                }

            }
        });


        fab.setOnClickListener(new onClickListener());

        listView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getActivity(), "It works", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void saveWorkout() {
        String weightNumber = weightEditText.getText().toString();
        String repsNumber = repsEditText.getText().toString();

        if(weightNumber.isEmpty() || repsNumber.isEmpty()) {
            Toast.makeText(getContext(), "Weight or Reps cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        int weight = Integer.parseInt(weightNumber);
        int reps = Integer.parseInt(repsNumber);

        WorkoutInformation workoutInformation = new WorkoutInformation(setNumber++, weight, reps);
        workoutInformationArrayList.add(workoutInformation);
    }

    // OnClick Listener for FAB
    public class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            PassWorkoutInformation();
        }
    }

    public void PassWorkoutInformation() {
        Intent workoutInformation = new Intent(getContext(), MainActivity.class);
        workoutInformation.putExtra("WorkoutArrayList", workoutInformationArrayList);
        startActivity(workoutInformation);
    }
}
