package com.assignment.diabetesrecords.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.assignment.diabetesrecords.common.helper.sql_lite_helper.DBHelper;
import com.assignment.diabetesrecords.entity.DiabetesEntry;

import java.util.ArrayList;

/**
 * Created by lokendra on 11/24/16.
 */
public class EntryManager

{
    DBHelper helper;
    SQLiteDatabase db;
    Context ctx;

    public EntryManager(Context ctx) {
        super();
        this.ctx = ctx;

        helper = new DBHelper(ctx, "DiabetesEntryDB",null,1);
    }


    public long insertDiabetesEntry(DiabetesEntry diabetesEntry)
    {
        long l = 0;

        db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("entry_date", diabetesEntry.getEntryDate());
        cv.put("entry_time", diabetesEntry.getEntryTime());
        cv.put("food_taken_status", diabetesEntry.getFoodTakenStatus());
        cv.put("glucose_reading", diabetesEntry.getGlucoseReading());
        cv.put("notes", diabetesEntry.getNotes());

        l = db.insert("diabetes_entry", null, cv);
        db.close();
        return l;
    }




    public ArrayList<DiabetesEntry> getAllDiabetesEntry(int iPageCount)
    {
        db = helper.getReadableDatabase();
        int iOffset=0;
        int iLimit=10;
        iOffset=iLimit*(iPageCount)-iLimit;
        //db.query("employee", null,null,null,null,null,null);
        Cursor cr = db.rawQuery("select * from diabetes_entry order by diabetes_entry_id desc LIMIT " + iLimit + " OFFSET " +iOffset, null);

        ArrayList<DiabetesEntry> list = new ArrayList<DiabetesEntry>();

        while(cr.moveToNext())
        {
             int DiabetesEntryId= cr.getInt(0);
             String EntryDate= cr.getString(1);
             String EntryTime= cr.getString(2);
             String FoodTakenStatus= cr.getString(3);
             float GlucoseReading=cr.getFloat(4);
             String Notes= cr.getString(5);


            DiabetesEntry diabetesEntry = new DiabetesEntry(DiabetesEntryId, EntryDate,EntryTime,FoodTakenStatus,GlucoseReading,Notes);
            list.add(diabetesEntry);
        }

        db.close();
        return list;
    }






}

