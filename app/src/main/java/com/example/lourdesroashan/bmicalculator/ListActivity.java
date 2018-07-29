package com.example.lourdesroashan.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

public class ListActivity extends android.app.ListActivity {

    public BMIHelper[] results = { new BMIHelper(5.5,100),new BMIHelper(4.3,156)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list);

        ListView listBMIResults = getListView();
        ArrayAdapter<BMIHelper> listAdapter = new ArrayAdapter<BMIHelper>(this, android.R.layout.simple_list_item_1, results);

        listBMIResults.setAdapter(listAdapter);
//        ScrollView scrollView = findViewById(R.id.idScroll);
//        scrollView.addView(listBMIResults);
    }
}
