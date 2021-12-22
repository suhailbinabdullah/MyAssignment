package com.suhail.myassignment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    String act, nat;
    Spinner course;
    ArrayAdapter<String> adapter;
    String flag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        course = findViewById(R.id.spinner_course);

        List<String> spinnerArray = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            act = extras.getString("act");
            nat = extras.getString("nat");
        }

        spinnerArray.add("All-Courses");
        spinnerArray.add("Medical");
        spinnerArray.add("Dental");
        spinnerArray.add("Ayurveda");

        if (act.equals("appfees")) {
            //appfees code here...

            switch (nat) {
                case "INDIAN":
                    Log.v("Nationlity", nat);
                    flag = "appInd";
                    break;

                case "FOREIGN":
                    Log.v("Nationality", nat);
                    flag = "appFor";
                    break;
            }
        } else {
            //examfees code here...
            switch (nat) {
                case "INDIAN":
                    Log.v("Nationality", nat);
                    flag = "exInd";
                    break;

                case "FOREIGN":
                    Log.v("Nationality", nat);
                    flag = "exFor";
                    break;

                case "NRI":
                    Log.v("Nationality", nat);
                    flag = "exNri";
                    break;

                case "SAARC":
                    Log.v("Nationality", nat);
                    flag = "exSaarc";
                    break;
            }
        }

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course.setAdapter(adapter);

        course.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                if (i != 0) {
                    intent.putExtra("course", flag);
                    //intent.putExtra("cor", adapter.getItem(i));
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}