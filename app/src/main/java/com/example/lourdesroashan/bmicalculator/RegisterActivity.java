package com.example.lourdesroashan.bmicalculator;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void registerUser(View view)
    {
        int flag = 0;
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
                helper.addUser(uName, uPass, uFullName, uDOB, uHCN, uHT);
                Toast.makeText(this, "User "+uFullName+" Registered",
                        Toast.LENGTH_LONG).show();
            }
        }


        System.out.println(uDOB);

        Intent intent = new Intent( this,MainActivity.class);
        startActivity(intent);
    }
}
