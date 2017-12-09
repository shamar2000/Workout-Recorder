package com.wpmdesignstudio.tabswithviewpagerandfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrackFragment extends Fragment {

    private EditText weightEditText;
    private EditText repsEditText;


    public TrackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_track_layout, container, false);
        weightEditText = (EditText) view.findViewById(R.id.weight_editText);
        repsEditText = (EditText) view.findViewById(R.id.reps_editTEXT);
        ListView listView = (ListView) view.findViewById(android.R.id.list);
        return view;
    }

}
