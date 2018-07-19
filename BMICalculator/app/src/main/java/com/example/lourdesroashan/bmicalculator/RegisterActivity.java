package com.example.lourdesroashan.bmicalculator;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {

    Context context = this;
    EditText editDate;
    Calendar myCalendar = Calendar.getInstance();
    String dateFormat = "MM/dd/yy";
    DatePickerDialog.OnDateSetListener date;
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        editDate = findViewById(R.id.regDOB);
//
//        // init - set date to current date
//        long currentdate = System.currentTimeMillis();
//        String dateString = sdf.format(currentdate);
//        editDate.setText(dateString);
//
//        // set calendar date and update editDate
//        date = new DatePickerDialog.OnDateSetListener() {
//
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear,
//                                  int dayOfMonth) {
//
//                myCalendar.set(Calendar.YEAR, year);
//                myCalendar.set(Calendar.MONTH, monthOfYear);
//                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//                updateDate();
//            }
//
//        };

        // onclick - popup datepicker
//        editDate.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
               // TODO Auto-generated method stub
//                new DatePickerDialog(context, date, myCalendar
//                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
//                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//            }
//        });

    }

//    private void updateDate() {
//        editDate.setText(sdf.format(myCalendar.getTime()));
//    }

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
        String uHCN = hcn.getText().toString();
        String uHT = height.getText().toString();



        System.out.println(uDOB);

        //Intent intent = new Intent( this,RegisterActivity.class);
        //startActivity(intent);
    }




}
