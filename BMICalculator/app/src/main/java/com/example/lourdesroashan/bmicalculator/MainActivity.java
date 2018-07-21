package com.example.lourdesroashan.bmicalculator;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DatabaseHelper helper = new DatabaseHelper(this);
//        SQLiteDatabase db = helper.getWritableDatabase();
//
//        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, new String[] {"NAME","PASSWORD","DATE"},
//                null,null,null,null,null);
//
//
//        if(cursor.moveToFirst()){
//            String name = cursor.getString(0);
//
//
//            EditText res = findViewById(R.id.textView7);
//            results.setText(name);
//        }

    }

    public void goToCalculate(View view)
    {
        Intent intent = new Intent( this,RegisterActivity.class);
        startActivity(intent);
    }
}
