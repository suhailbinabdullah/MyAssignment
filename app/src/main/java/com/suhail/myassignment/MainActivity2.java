package com.suhail.myassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    String value = "";
    private Spinner nationalitySpinner;
    String act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nationalitySpinner = findViewById(R.id.spinner_nationality);
        List<String> spinnerArray = new ArrayList<String>();
        ArrayAdapter<String> adapter;


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("which");
            if ("appfees".equals(value)) {
                //app fees code....

                spinnerArray.clear();
                spinnerArray.add("Select Nationality");
                spinnerArray.add("INDIAN");
                spinnerArray.add("FOREIGN");
                act = "appfees";

            } else {
                //exam fees code....

                spinnerArray.clear();
                spinnerArray.add("Select Nationality");
                spinnerArray.add("INDIAN");
                spinnerArray.add("FOREIGN");
                spinnerArray.add("NRI");
                spinnerArray.add("SAARC");
                act = "examfees";
            }

            adapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_item, spinnerArray);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            nationalitySpinner.setAdapter(adapter);

            nationalitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if (i != 0) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                        intent.putExtra("act", act);
                        intent.putExtra("nat", adapter.getItem(i));
                        startActivity(intent);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }
}