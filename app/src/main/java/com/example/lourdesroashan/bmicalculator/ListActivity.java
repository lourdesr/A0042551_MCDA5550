package com.example.lourdesroashan.bmicalculator;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;

public class ListActivity extends android.app.ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list);
        String user = getIntent().getStringExtra("username");
        BMIHelper r = new BMIHelper();

        ArrayList<String> results = getHistory(user);
        System.out.println(results);

        ListView listBMIResults = getListView();
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, results);

        listBMIResults.setAdapter(listAdapter);
//        ScrollView scrollView = findViewById(R.id.idScroll);
//        scrollView.addView(listBMIResults);
    }


    public ArrayList<String> getHistory(String user){

        DatabaseHelper newHelper = new DatabaseHelper(this);
        SQLiteDatabase db = newHelper.getWritableDatabase();

        String whereClause = "USERNAME = ?";
        String[] whereArgs = new String[] {
                user
        };

        Cursor cursor = db.query("HISTORY", new String[] {"HEIGHT","WEIGHT","EDATE","BMI"}, whereClause,whereArgs,null,null,null);

        ArrayList<String> histList = new ArrayList<>();
        histList.add("BMI Entries by "+user);
        histList.add("Entry Date | Height | Weight | BMI");

        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                String height = cursor.getString(0);
                String weight = cursor.getString(1);
                String edate = cursor.getString(2);
                String bmi = cursor.getString(3);

                BMIHelper e = new BMIHelper();
                e.setHeight(height);
                e.setWeight(weight);
                e.setDate(edate);
                e.setBmi(bmi);
                histList.add(e.strUtil(e));

            }
        }
        else {
            histList.add("No records added yet");
        }

        return histList;
    }
}
