package com.example.lourdesroashan.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calculate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
    }

    public void calcBMI(View view){
        EditText ht = findViewById(R.id.editText5);
        String htVal = ht.getText().toString();
        Double heightValue = Double.parseDouble(htVal);


        EditText wt = findViewById(R.id.editText6);
        String wtVal = wt.getText().toString();
        Double weightValue = Double.parseDouble(wtVal);


        Double calc = (weightValue/ (heightValue * heightValue));
        TextView result = findViewById(R.id.textView7);

        result.setText(calc.toString());




        System.out.println(heightValue);





    }
}
