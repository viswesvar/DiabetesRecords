package com.assignment.diabetesrecords.modules.summary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assignment.diabetesrecords.R;
import com.assignment.diabetesrecords.entity.DiabetesEntry;
import com.assignment.diabetesrecords.modules.diabetes_entry.EntryManager;

import java.util.ArrayList;


public class SummaryFragment extends Fragment{

    int iPageCounter;
    ArrayList<DiabetesEntry> diabetesEntryList;
    DiabetesEntryAdapter diabetesEntryAdapter;
    private RecyclerView mRecyclerView;

    public SummaryFragment() {
        // Required empty public constructor
        int i=0;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parent = inflater.inflate(R.layout.fragment_summary, container, false);

        //-------------------------------------

        EntryManager  entryManager= new EntryManager(getActivity());
        //ArrayList<Category> clist;




        //Begin -- Load Data in List--------------------------------
        mRecyclerView = (RecyclerView) parent.findViewById(R.id.listUsers);
        iPageCounter=1;
        diabetesEntryList = entryManager.getAll(iPageCounter);
        diabetesEntryAdapter = new DiabetesEntryAdapter(getActivity(), diabetesEntryList);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(diabetesEntryAdapter);

        //End -- Load Data in List--------------------------------
        //------------------------------------------

        return  parent;
    }

    @Override
    public void onResume() {
        super.onResume();
        EntryManager  entryManager= new EntryManager(getActivity());
        //ArrayList<Category> clist;




        //Begin -- Load Data in List--------------------------------

        iPageCounter=1;
        diabetesEntryList = entryManager.getAll(iPageCounter);
        diabetesEntryAdapter = new DiabetesEntryAdapter(getActivity(), diabetesEntryList);


   //     RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
     //   mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(diabetesEntryAdapter);
        diabetesEntryAdapter.notifyDataSetChanged();
    }
}
