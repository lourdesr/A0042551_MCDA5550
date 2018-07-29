package com.example.lourdesroashan.bmicalculator;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    public int flag;
    private int mYear, mMonth, mDay;

    Calendar myCalendar = Calendar.getInstance();

    EditText regDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        flag = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regDOB = findViewById(R.id.regDOB);
        regDOB.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        if (view == regDOB) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            regDOB.setText((monthOfYear+1) + "/" + (dayOfMonth) + "/" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }


    public void registerUser(View view)
    {

        EditText uname = findViewById(R.id.regUserName);
        EditText name = findViewById(R.id.regName);
        EditText password = findViewById(R.id.regPassword);
        EditText date = findViewById(R.id.regDOB);
        EditText hcn = findViewById(R.id.regHCN);
        EditText height = findViewById(R.id.regHeight);

        String uName = uname.getText().toString();
        String uFullName = name.getText().toString();
        String uPass = password.getText().toString();
        String uDOB = date.getText().toString();
        System.out.println(uDOB);
        String uHCN = hcn.getText().toString();
        String uHT = height.getText().toString();

        if(     uName.trim().equals("") ||
                uFullName.trim().equals("") ||
                uPass.trim().equals("") ||
                uDOB.trim().equals("") ||
                uHCN.trim().equals("") ||
                uHT.trim().equals("")
                ){

            Toast.makeText(this, "All fields are mandatory",
                    Toast.LENGTH_LONG).show();
        }
        else {

            DatabaseHelper helper = new DatabaseHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();

            String whereClause = "USERNAME = ?";
            String[] whereArgs = new String[] {
                    uName
            };

            Cursor cursor = db.query("USER", new String[] {"USERNAME"}, whereClause,whereArgs,null,null,null);

            if(cursor.moveToFirst()) {
                String username = cursor.getString(0);
                if(username.equals(uName)){
                    flag = 1;
                    Toast.makeText(this, "Username "+uName+" already exists",
                            Toast.LENGTH_LONG).show();
                    System.out.println("User Exists");
                }
            }
            else{

                if(flag == 0){
                    System.out.println("User Does not Exists");
                    //helper.addUser(uName, uPass, uFullName, uDOB, uHCN, uHT);
                    Toast.makeText(this, "New User "+uFullName+" Registered",
                            Toast.LENGTH_LONG).show();
                }
            }


            System.out.println(uDOB);

            Intent intent = new Intent( this,MainActivity.class);
            startActivity(intent);

        }

    }

}
