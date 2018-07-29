package com.example.lourdesroashan.bmicalculator;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class UserActivity extends AppCompatActivity {

//
//    DatabaseHelper newHelper = new DatabaseHelper(this);
//    SQLiteDatabase db = newHelper.getWritableDatabase();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user);
        String uname = getIntent().getStringExtra("username");
        String height = getIntent().getStringExtra("height");
        System.out.println(uname);

        EditText editHt = findViewById(R.id.editHeight);
        editHt.setText(height);
//        String whereClause = "USERNAME = ? AND PASSWORD = ?";
//        String[] whereArgs = new String[] {
//                eUname,
//                ePass
//        };
//
//        Cursor cursor = db.query("USER", new String[] {"USERNAME","PASSWORD"}, whereClause,whereArgs,null,null,null);


    }

    public void calculateBMI(View view){


        EditText wt = findViewById(R.id.editWeight);
        EditText ht = findViewById(R.id.editHeight);

        String htVal = ht.getText().toString();
        String wtVal = wt.getText().toString();

        if(htVal.trim().equals("") || wtVal.trim().equals("")){
            Toast.makeText(this, "All fields are required",
                    Toast.LENGTH_LONG).show();
        }
        else {
            Double heightValue = Double.parseDouble(htVal);
            Double weightValue = Double.parseDouble(wtVal);

            Double calc = (weightValue/ (heightValue * heightValue));
            TextView result = findViewById(R.id.bmiText);
            result.setText("BMI : "+calc.toString());

            String uname = getIntent().getStringExtra("username");

            Date d = new Date();
            String dateStr = d.toString();

            DatabaseHelper helper = new DatabaseHelper(this);

            helper.addBMI(uname,wtVal,htVal,calc.toString(),dateStr);

            Toast.makeText(this, "Added BMI",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void goToHistory(View view){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }


}
