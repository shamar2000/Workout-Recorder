package com.wpmdesignstudio.tabswithviewpagerandfragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TrackTabFragmentListAdapter extends ArrayAdapter<WorkoutInformation> {

    private Context context;
    int resource;

    public TrackTabFragmentListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<WorkoutInformation> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int setNumber = getItem(position).getSetNumber();
        int weightNumber = getItem(position).getWeightNumber();
        int repNumber = getItem(position).getRepNumber();

        WorkoutInformation workoutInformation = new WorkoutInformation(setNumber, weightNumber, repNumber);

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView sets = (TextView) convertView.findViewById(R.id.set_number_textView);
        TextView weight = (TextView) convertView.findViewById(R.id.weight_number_textView);
        TextView reps = (TextView) convertView.findViewById(R.id.rep_number_textView);

        sets.setText(setNumber);
        weight.setText(weightNumber);
        reps.setText(repNumber);

        return convertView;

    }
}
