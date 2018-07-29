package com.example.lourdesroashan.bmicalculator;

import java.util.ArrayList;

public class BMIHelper {

    public double height;
    public double weight;
    public String date;

    BMIHelper(double height, double weight){
        this.height = height;
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


//
//    public ArrayList<BMIHelper> getHistory(){
//
//    }
}

