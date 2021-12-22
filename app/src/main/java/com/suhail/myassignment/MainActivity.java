package com.suhail.myassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFees;
    private int userAmmount;
    private Button btnAppFees, btnExamFees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAppFees = findViewById(R.id.btn_appl_fees);
        btnExamFees = findViewById(R.id.btn_exam_fees);

//        ObjectMapper om = new ObjectMapper();
//        FeeStructure root = new FeeStructure();
//        try {
//            root = om.readValue(AppConstants.jsonString, FeeStructure.class);
//            Log.e("this", "is a test");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        btnAppFees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("which","appfees");
                startActivity(intent);
            }
        });

        btnExamFees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("which","examfees");
                startActivity(intent);
            }
        });

    }
}