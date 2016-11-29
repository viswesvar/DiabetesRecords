package com.assignment.diabetesrecords.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.assignment.diabetesrecords.R;
import com.assignment.diabetesrecords.common.my_validator.MyValidator;
import com.assignment.diabetesrecords.entity.DiabetesEntry;
import com.assignment.diabetesrecords.manager.EntryManager;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;


public class EntriesFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener {


    View parent;
    private EditText dateet, timeet, etReading, etNote;
    private Button bSave, bAddAnother;
    Spinner spReadingTimings;



    public static Context mContext;
    public static AppCompatActivity mParentActivity;
    public EntriesFragment() {
        // Required empty public constructor

    }

    public static EntriesFragment newInstance(Context context)
    {
        EntriesFragment fragment = new EntriesFragment();

        mContext = context;
        mParentActivity = (AppCompatActivity) context;

        return fragment;
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
        etReading = (EditText) parent.findViewById(R.id.etReading);
        etNote = (EditText) parent.findViewById(R.id.etNote);
        bSave= (Button) parent.findViewById(R.id.bSave);
        bAddAnother= (Button) parent.findViewById(R.id.bAddAnother);
        spReadingTimings= (Spinner) parent.findViewById(R.id.spReadingTimings);

        dateet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(
                            EntriesFragment.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                    dpd.setAccentColor(getResources().getColor(R.color.colorAccent));
                    dpd.show(mParentActivity.getFragmentManager(), "Datepickerdialog");
                }
                return true;
            }
        });

        timeet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Calendar now = Calendar.getInstance();
                    TimePickerDialog tpd = TimePickerDialog.newInstance(
                            EntriesFragment.this,
                            now.get(Calendar.HOUR),
                            now.get(Calendar.MINUTE),
                            false
                    );
                    tpd.setAccentColor(getResources().getColor(R.color.colorAccent));
                    tpd.show(mParentActivity.getFragmentManager(), "Datepickerdialog");
                }
                return true;
            }
        });

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation())
                {
                    save();
                }

            }
        });


        bAddAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyForm();

            }
        });


        return parent;
    }

    private void EmptyForm()
    {
        etReading.setText("");
        etNote.setText("");
        dateet.setText("");
        timeet.setText("");
    }


    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        String time = (hourOfDay>12?(hourOfDay-12):hourOfDay)+":"+minute+" "+(hourOfDay>12?"PM":"AM");
        timeet.setText(time);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year ;
        dateet.setText(date);
    }

    private boolean validation()
    {
        boolean result = true;

        if (etReading.length() ==0)
        {
            result=false;
            etReading.setError("Enter Reading");
        }
        else
        {
            etReading.setError(null);
        }


        if (dateet.length() ==0)
        {
            result=false;
            dateet.setError("Enter Date");
        }
        else
        {
            dateet.setError(null);
        }


        if (timeet.length() ==0)
        {
            result=false;
            timeet.setError("Enter Time");
        }
        else
        {
            timeet.setError(null);
        }





        return result;
    }

    private void save()
    {
        EntryManager entryManager= new EntryManager(getActivity());
        long l=0;
        try{

            String sDate= MyValidator.getDateInyyyymmdd(dateet.getText().toString());
            String sTime = MyValidator.getTimeIn24HoursFormat(timeet.getText().toString());


            String FoodTakenStatus= spReadingTimings.getSelectedItem().toString();
            float GlucoseReading= Float.parseFloat(etReading.getText().toString());
            String Notes= etNote.getText().toString();


            DiabetesEntry diabetesEntry = new DiabetesEntry(0, sDate,sTime,FoodTakenStatus,GlucoseReading,Notes);


            l = entryManager.insertDiabetesEntry(diabetesEntry);


        }
        catch(Exception ex)
        {
            Toast.makeText(mContext, ex.toString(), Toast.LENGTH_SHORT).show();
        }


        if(l>0) {
            Toast.makeText(mContext, "Record Save", Toast.LENGTH_SHORT).show();
            EmptyForm();
          //  ((MainActivity) mContext).refreshTabs();
            //finish();
        }
        else
            Toast.makeText(mContext,"Record Not Save",Toast.LENGTH_SHORT).show();

    }

}
