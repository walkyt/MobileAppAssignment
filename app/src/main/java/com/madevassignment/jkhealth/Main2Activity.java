package com.madevassignment.jkhealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


public class Main2Activity extends AppCompatActivity {
    private Button Sedentary;
    private Button Light;
    private Button Moderate;
    private Button Very;
    private Button Extra;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle applesData = getIntent().getExtras();

        String bmr_value = applesData.getString("bmr_value");
        //final  TextView textView = (TextView) findViewById(R.id.textView);
        textView = findViewById(R.id.textView);

        textView.setText(bmr_value);


        Sedentary = findViewById(R.id.button);
        Light= findViewById(R.id.button2);
        Moderate = findViewById(R.id.button3);
        Very = findViewById(R.id.button4);
        Extra = findViewById(R.id.button5);

        Sedentary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateSedentary();
            }
        });

        Light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              calculateLight();
            }
        });

        Moderate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             calculateModerate();
            }
        });

        Very.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              calculateVery();
            }
        });

        Extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             calculateExtra();
            }
        });


    }

    private void calculateSedentary(){

    }

    private void calculateLight(){

    }

    private void calculateModerate(){

    }

    private void calculateVery(){

    }

    private void calculateExtra(){

    }
}
