package com.assignment.diabetesrecords.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.assignment.diabetesrecords.R;


public class EntriesFragment extends DialogFragment {


    View parent;
    private EditText dateet, timeet;


    public EntriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        parent= inflater.inflate(R.layout.fragment_entries, container, false);
        dateet = (EditText) parent.findViewById(R.id.dateet);
        timeet = (EditText) parent.findViewById(R.id.timeet);





        return parent;
    }






}
