package com.wpmdesignstudio.tabswithviewpagerandfragments;


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

public class TrackTabFragment extends Fragment implements Serializable {

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
        weightEditText = (EditText) view.findViewById(R.id.weight_editText);
        repsEditText = (EditText) view.findViewById(R.id.reps_editTEXT);
        final ListView listView = (ListView) view.findViewById(R.id.list_of_workouts_listView);
        saveBtn = (Button) view.findViewById(R.id.save_workout_button);
        deleteBtn = (Button) view.findViewById(R.id.delete_workout_button);
        fab = (FloatingActionButton) view.findViewById(R.id.fab_TrackTabFragment);
        workoutInformationArrayList = new ArrayList<>();

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

        /**
         * Let this method call the method that gets the workout information from the ArrayList and
         * passes it to the workoutRecorderActivity
         */

        fab.setOnClickListener(new onClickListener());

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

        /**
         * UNFINISHED METHOD
         *
         * This method needs to pass the workout recorded in workout array for display in the
         * workout recorder activity
         */
        public void PassWorkoutInformation() {
            WorkoutInformation workoutInfo1 = workoutInformationArrayList.get(counter++);
            String weightNum = Integer.toString(workoutInfo1.getWeightNumber());
            Toast.makeText(getContext(), "Weight: " + weightNum, Toast.LENGTH_SHORT).show();
        }
    }
}
