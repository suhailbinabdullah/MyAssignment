package com.suhail.myassignment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    String course;
    Spinner levels;
    ArrayAdapter<String> adapter;
    String flag = "";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        levels = findViewById(R.id.spinner_levels);
        textView = findViewById(R.id.text_view);

        List<String> spinnerArray = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            course = extras.getString("course");
        }

        switch (course) {
            case "appInd":
            case "appFor":
                spinnerArray.clear();
                spinnerArray.add("All-Plans");
                spinnerArray.add("UG");
                spinnerArray.add("UG-Diploma");
                spinnerArray.add("PG");
                break;

            case "exInd":
            case "exFor":
            case "exNri":
            case "exSaarc":
                spinnerArray.clear();
                spinnerArray.add("All-Plans");
                spinnerArray.add("UG");
                spinnerArray.add("PG");
                spinnerArray.add("DIPLOMA");
                spinnerArray.add("Ph.D");
                break;
        }

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levels.setAdapter(adapter);

        levels.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                FeeStructure feeStructure = AppConstants.getFeeStructure();
                if (i != 0) {
                    if (adapter.getItem(i).equals("UG") && course.equals("appInd")) {
                        assert feeStructure != null;
                        int amount = feeStructure.applicationFee.iNDIAN.aLL_COURSES.uG.amount;
                        int gst=amount*18/100;
                        textView.setText(getString(R.string.the_fees_is) + (amount+gst));
                    }

                    if (adapter.getItem(i).equals("UG-Diploma") && course.equals("appInd")) {
                        assert feeStructure != null;
                        int amount = feeStructure.applicationFee.iNDIAN.aLL_COURSES.uGDIPLOMA.amount;
                        int gst=amount*18/100;
                        textView.setText(getString(R.string.the_fees_is) + (amount+gst));
                    }

                    if (adapter.getItem(i).equals("PG") && course.equals("appInd")) {
                        assert feeStructure != null;
                        int amount = feeStructure.applicationFee.iNDIAN.aLL_COURSES.pG.amount;
                        int gst=amount*18/100;
                        textView.setText(getString(R.string.the_fees_is) + (amount+gst));
                    }

                    if (adapter.getItem(i).equals("UG") && course.equals("appFor")) {
                        assert feeStructure != null;
                        int amount = feeStructure.applicationFee.fOREIGN.aLL_COURSES.uG.amount;
                        int gst=amount*28/100;
                        textView.setText(getString(R.string.the_fees_is) + (amount+gst));
                    }

                    if (adapter.getItem(i).equals("UG-Diploma") && course.equals("appFor")) {
                        assert feeStructure != null;
                        int amount = feeStructure.applicationFee.fOREIGN.aLL_COURSES.uGDIPLOMA.amount;
                        int gst=amount*28/100;
                        textView.setText(getString(R.string.the_fees_is) + (amount+gst));
                    }

                    if (adapter.getItem(i).equals("PG") && course.equals("appFor")) {
                        assert feeStructure != null;
                        int amount = feeStructure.applicationFee.fOREIGN.aLL_COURSES.pG.amount;
                        int gst=amount*28/100;
                        textView.setText(getString(R.string.the_fees_is) + (amount+gst));
                    }

                    //exam fees code goes form here.......
                    if (course.equals("exInd")) {
                        assert feeStructure != null;
                        int amount = feeStructure.examFee.iNDIAN.aLL_COURSES.aLL_LEVEL.amount;
                        int gst=amount*18/100;
                        textView.setText(getString(R.string.the_fees_is) + (amount+gst));
                    }

                    if (course.equals("exFor")) {
                        assert feeStructure != null;
                        int amount = feeStructure.examFee.fOREIGN.aLL_COURSES.aLL_LEVEL.amount;
                        int gst=amount*28/100;
                        textView.setText(getString(R.string.the_fees_is) + (amount+gst));
                    }

                    if (course.equals("exNri")) {
                        assert feeStructure != null;
                        int amount = feeStructure.examFee.nRI.aLL_COURSES.aLL_LEVEL.amount;
                        int gst=amount*28/100;
                        textView.setText(getString(R.string.the_fees_is) + (amount+gst));
                    }

                    if (course.equals("exSaarc")) {
                        assert feeStructure != null;
                        int amount = feeStructure.examFee.sAARC.aLL_COURSES.aLL_LEVEL.amount;
                        int gst=amount*18/100;
                        textView.setText(getString(R.string.the_fees_is) + (amount+gst));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}