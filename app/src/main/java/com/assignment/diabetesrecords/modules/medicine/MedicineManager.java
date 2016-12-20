package com.assignment.diabetesrecords.modules.medicine;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.assignment.diabetesrecords.common.helper.sql_lite_helper.DBHelper;
import com.assignment.diabetesrecords.entity.MedicineRecord;

/**
 * Created by viswesvar on 11/24/16.
 */
public class MedicineManager

{
    DBHelper helper;
    SQLiteDatabase db;
    Context ctx;

    public MedicineManager(Context ctx) {
        super();
        this.ctx = ctx;

        helper = new DBHelper(ctx, "DiabetesEntryDB",null,1);
    }


    public long insertMedicine(MedicineRecord medicineRecord)
    {
        long l = 0;

        db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("entry_date", medicineRecord.getEntryDate());
        cv.put("entry_time", medicineRecord.getEntryTime());
        cv.put("food_taken_status", medicineRecord.getFoodTakenStatus());
        cv.put("title", medicineRecord.getTitle());
        cv.put("description", medicineRecord.getDescription());
        cv.put("insulineinformation", medicineRecord.getInsulineInformation());

        l = db.insert("medicine_record", null, cv);
        db.close();
        return l;
    }










}

