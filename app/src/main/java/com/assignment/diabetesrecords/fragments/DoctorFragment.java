package com.assignment.diabetesrecords.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.assignment.diabetesrecords.R;
import com.assignment.diabetesrecords.activity.AddAppointmentActivity;
import com.assignment.diabetesrecords.activity.AddDoctorActivity;


public class DoctorFragment extends Fragment{

    Button bAddDoctor, bAppointment;

    public DoctorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parent= inflater.inflate(R.layout.fragment_doctor, container, false);

        bAddDoctor = (Button) parent.findViewById(R.id.bAddDoctor);

        bAddDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(getActivity(), AddDoctorActivity.class);
                getActivity().startActivity(in);
            }
        });


        bAppointment = (Button) parent.findViewById(R.id.bAppointment);

        bAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(getActivity(), AddAppointmentActivity.class);
                getActivity().startActivity(in);
            }
        });



        return  parent;
    }

}
