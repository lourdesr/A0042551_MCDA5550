package com.example.lourdesroashan.bmicalculator;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BMIHelper {

    public String height;
    public String weight;
    public String date;
    public String bmi;

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String strUtil(BMIHelper e){
        return e.getDate() + " | " + e.getHeight() + " | " + e.getWeight() + " | " + e.getBmi();
    }

}

