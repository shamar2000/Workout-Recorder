package com.wpmdesignstudio.tabswithviewpagerandfragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TrackTabFragment extends Fragment {

     ListView listView;
     FloatingActionButton fab;
     EditText weightEditText;
     EditText repsEditText;
     CheckBox checkBoxes;
     private int setNumber = 1;
     private int counter = 0;

     Button saveBtn;
     Button deleteBtn;
     ArrayList<WorkoutInformation> workoutInformationArrayList;
     TrackTabFragmentListAdapter trackTabFragmentListAdapter;


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
        listView.setChoiceMode(2);
        saveBtn = (Button) view.findViewById(R.id.save_workout_button);
        deleteBtn = (Button) view.findViewById(R.id.delete_workout_button);
        fab = (FloatingActionButton) view.findViewById(R.id.fab_TrackTabFragment);
        workoutInformationArrayList = new ArrayList<>();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveWorkout();
                trackTabFragmentListAdapter = new TrackTabFragmentListAdapter
                        (getActivity(), R.layout.track_tab_fragment_list_view, workoutInformationArrayList);
                listView.setAdapter(trackTabFragmentListAdapter);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                SparseBooleanArray checked = listView.getCheckedItemPositions();
                int itemCount = listView.getCount();
                for (int i = itemCount-1; i >= 0; i--){

                    if (checked.get(i)) {
                        workoutInformationArrayList.remove(i);
                    }

                    trackTabFragmentListAdapter.notifyDataSetChanged();
                }
                listView.clearChoices();
            }
        });


        fab.setOnClickListener(new onClickListener());

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "it works", Toast.LENGTH_SHORT).show();
                return true;
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
