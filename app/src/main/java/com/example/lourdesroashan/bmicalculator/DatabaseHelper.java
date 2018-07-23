package com.example.lourdesroashan.bmicalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "inclass";
    private static final int DB_VERSION = 1;
    private  static final String TABLE_NAME = "USER";

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public  void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE "+TABLE_NAME+"("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"USERNAME TEXT,"
                +"PASSWORD TEXT,"
                +"NAME TEXT,"
                +"DOB TEXT,"
                +"HEALTH_CARD_NUMB TEXT,"
                +"HEIGHT INTEGER);");
//
//        Date today = new Date();
//
//        ContentValues personValues = new ContentValues();
//
//        personValues.put("NAME","Foo");
//        personValues.put("PASSWORD","secret");
//        personValues.put("HEALTH_CARD_NUMB","314142");
//        personValues.put("DATE",today.getTime());
//
//        db.insert(TABLE_NAME,null,personValues);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public  void addUser(String username, String password, String name, String date, String hcn, String height){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues personValues = new ContentValues();

        personValues.put("USERNAME",username);
        personValues.put("NAME",name);
        personValues.put("PASSWORD",password);
        personValues.put("HEALTH_CARD_NUMB",hcn);
        personValues.put("HEIGHT",height);
        personValues.put("DOB",date);

        db.insert(TABLE_NAME,null,personValues);
    }
}
