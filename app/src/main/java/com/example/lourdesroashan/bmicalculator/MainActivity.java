package com.example.lourdesroashan.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLogin(View view){
        System.out.println("Go to Register");
        Intent intent = new Intent( this,LoginActivity.class);
        startActivity(intent);
    }

    public void goToRegister(View view){
        System.out.println("Go to Register");
        Intent intent = new Intent( this,RegisterActivity.class);
        startActivity(intent);
    }
}
