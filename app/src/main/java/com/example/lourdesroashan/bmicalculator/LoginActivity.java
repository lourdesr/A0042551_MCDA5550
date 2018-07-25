package com.example.lourdesroashan.bmicalculator;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginUser(View view){

        DatabaseHelper newHelper = new DatabaseHelper(this);
        SQLiteDatabase db = newHelper.getWritableDatabase();

        EditText eUsername = findViewById(R.id.loginUserName);
        EditText ePassword = findViewById(R.id.loginPassword);
        String eUname = eUsername.getText().toString();
        String ePass = ePassword.getText().toString();

        String whereClause = "USERNAME = ? AND PASSWORD = ?";
        String[] whereArgs = new String[] {
                eUname,
                ePass
        };

        Cursor cursor = db.query("USER", new String[] {"USERNAME","PASSWORD"}, whereClause,whereArgs,null,null,null);

        if(cursor.moveToFirst()){
            String username = cursor.getString(0);
            String password = cursor.getString(1);

        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);

            System.out.println(username + "  " + password);
        }
        else {
            Toast.makeText(this, "Login Unsuccessful",
                    Toast.LENGTH_LONG).show();
        }


    }
}
