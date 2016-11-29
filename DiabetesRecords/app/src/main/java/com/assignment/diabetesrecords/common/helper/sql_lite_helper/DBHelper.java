package com.assignment.diabetesrecords.common.helper.sql_lite_helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lokendra on 11/24/16.
 */
public class DBHelper extends SQLiteOpenHelper
{

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL("create table diabetes_entry(diabetes_entry_id integer PRIMARY KEY AUTOINCREMENT,entry_date text,entry_time text,food_taken_status text,glucose_reading real,notes text)");


        //db.execSQL("delete table category");
      //  db.execSQL("create table category(categoryid integer PRIMARY KEY AUTOINCREMENT,categoryname text)");
      //  db.execSQL("create table card(cardid integer PRIMARY KEY AUTOINCREMENT,businessname text,personname text,street text,city text,state text,lat real,lon real,contact1 text,contact2 text,email text,pic text,categoryid integer,country text,comment text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion)
    {


    }
}
