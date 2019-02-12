package com.madevassignment.jkhealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button calculate;
    private EditText weight_in;
    private EditText height_in;
    private TextView bmi;
    private TextView status;
    private double bmi_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate = findViewById(R.id.calculate);
        weight_in = findViewById(R.id.weight_in);
        bmi = findViewById(R.id.bmi);
        height_in = findViewById(R.id.height_in);
        status = findViewById(R.id.status);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weight = weight_in.getText().toString();
                String height = height_in.getText().toString();

                bmi_value = Double.valueOf(weight)/(Math.pow(Double.valueOf(height),2));
                DecimalFormat formater = new DecimalFormat("#.##");
                bmi.setText("BMI:"+formater.format(bmi_value));
                if(bmi_value<18.50){

                    status.setText("You are underweight");
                }
//                bmi_value = Double.valueOf(weight)/(Math.pow(Double.valueOf(height),2));
//                DecimalFormat formater = new DecimalFormat("#.##");

                else if((bmi_value<=18.50)&&(bmi_value<24.90)){
                    status.setText("You are normal weight");
                }

            }
        });
    }

}
