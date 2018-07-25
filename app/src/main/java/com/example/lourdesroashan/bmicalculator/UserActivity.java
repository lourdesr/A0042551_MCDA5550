package com.example.lourdesroashan.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        String uname = getIntent().getStringExtra("username");
        TextView uText = findViewById(R.id.uText);
        uText.setText(uname);

    }
}
