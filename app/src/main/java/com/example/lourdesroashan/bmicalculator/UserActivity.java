package com.example.lourdesroashan.bmicalculator;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class UserActivity extends AppCompatActivity {

//
//    DatabaseHelper newHelper = new DatabaseHelper(this);
//    SQLiteDatabase db = newHelper.getWritableDatabase();
    double optimalBMI = 21.5;


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

//        Activity activity = ((MyApp)context.getApplicationContext()).getCurrentActivity();

        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        assert inputMethodManager != null;
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);


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

            long optWt = Math.round(optimalBMI * heightValue * heightValue);
            String suggestWt = String.valueOf(Math.round(Math.abs(weightValue - optWt)));

            //Code for BMI description and suggestions
            /*
            BMI Categories:
            Underweight = <18.5
            Normal weight = 18.5–24.9
            Overweight = 25–29.9
            Obesity = BMI of 30 or greater
            */
            TextView descBMI = findViewById(R.id.descBMI);
            if(calc >= 18.5 && calc <= 24.9){
                descBMI.setText("Hey, "+uname+"! Your weight seems to be within the NORMAL range!");
            }
            else if(calc <= 18.4 && calc > 0.0){
                descBMI.setText("Hey, "+uname+"! You\'re Underweight by: "+suggestWt+ " Kgs");
            }
            else if(calc >= 25.0 && calc <= 29.9){
                descBMI.setText("Hey, "+uname+"! You\'re Over Weight by: "+suggestWt+ " Kgs");
            }
            else if(calc > 29.9){
                descBMI.setText("Hey, "+uname+"! You seem to be pretty fat. You need to lose around "+suggestWt+"" +
                        " Kgs. You might wanna go easy on the \'Diet\' coke and Cheese Burgers.");
            }
            else if(calc < 0.0 || calc > 150.0){
                System.out.println("You even Human bro?");
            }
            else {
                System.out.println("We don't do BMI for aliens");
            }







            Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            String dateStr = String.valueOf(mMonth+1) + "/" + String.valueOf(mDay) + "/" + String.valueOf(mYear);

            System.out.println(dateStr);

            DatabaseHelper helper = new DatabaseHelper(this);

            helper.addBMI(uname,wtVal,htVal,calc.toString(),dateStr);

            Toast.makeText(this, "Added BMI",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void goToHistory(View view){
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("username", getIntent().getStringExtra("username"));
        startActivity(intent);

    }


}
