package com.wpmdesignstudio.tabswithviewpagerandfragments;


import android.os.Bundle;
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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrackTabFragment extends Fragment {

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

        return view;
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

        WorkoutInformation workoutInfo1 = workoutInformationArrayList.get(counter++);
        String weightNum = Integer.toString(workoutInfo1.getWeightNumber());
        Toast.makeText(getContext(), "Weight: " + weightNum, Toast.LENGTH_SHORT).show();
    }
}
