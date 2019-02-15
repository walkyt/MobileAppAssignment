package com.madevassignment.jkhealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button calculate_male;
    private Button calculate_female;
    private EditText weight_in;
    private EditText height_in;
    private TextView bmi;
    private TextView status;
    private float bmi_value;
    public float bmi_real;
    private EditText age_in;
    private TextView bmr_var;
    private float bmr_value;
    private String weight;
    private String height;
    private String age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate_male = findViewById(R.id.calculate_male);
        calculate_female = findViewById(R.id.calculate_female);
        weight_in = findViewById(R.id.weight_in);
        age_in = findViewById(R.id.age_in);
        bmi = findViewById(R.id.bmi);
        height_in = (EditText) findViewById(R.id.height_in);
        status = findViewById(R.id.status);
        bmr_var = findViewById(R.id.bmr);

        calculate_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(weight_in.getText().toString().length()==0){
                        Toast.makeText(MainActivity.this, "Error: Do npt leave it empty", Toast.LENGTH_SHORT);
                    }
                    else {
                        calculateBMI();
                        calculateBMR_male();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }


            }
        });

        calculate_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    if(weight_in.getText().toString().length()==0) {
                        Toast.makeText(MainActivity.this, "Error: Do npt leave it empty", Toast.LENGTH_SHORT);
                    }else{
                        calculateBMI();
                        calculateBMR_female();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void calculateBMI(){
        weight = weight_in.getText().toString();
        height = height_in.getText().toString();

        bmi_value = Float.valueOf(weight)/((Float.valueOf(height))*(Float.valueOf(height)));
        DecimalFormat formater = new DecimalFormat("#.##");
        bmi.setText("BMI:"+formater.format(bmi_value));
        bmi_real = Float.parseFloat(formater.format(bmi_value));

        displayBMI();
    }


    private void displayBMI(){
        if(Float.compare(bmi_real,18.5f)<=0){
            status.setText("You are underweight");
        }

        else if(Float.compare(bmi_real,18.5f)>0&&Float.compare(bmi_real,24.9f)<=0){
            status.setText("You are normal weight");
        }

        else if(Float.compare(bmi_real,24.9f)>0&&Float.compare(bmi_real,29.9f)<=0){
            status.setText("You are Overweight");
        }

        else if(Float.compare(bmi_real,29.9f)>0){
            status.setText("You are Obesity");
        }
    }

    private void calculateBMR_male(){
        weight = weight_in.getText().toString();
        height = height_in.getText().toString();
        age = age_in.getText().toString();

        bmr_value = (float) (88.362 + (13.397*Float.valueOf(weight))+(479.9*Float.valueOf(height))-(5.677* Float.valueOf(age)));
        Log.d("abc",Float.toString(bmr_value));
        bmr_var.setText("BMR:"+ Float.toString(bmr_value));

    }
    private void calculateBMR_female(){
        weight = weight_in.getText().toString();
        height = height_in.getText().toString();
        age = age_in.getText().toString();

        bmr_value = (float) (447.593 + (9.247*Float.valueOf(weight))+(309.8*Float.valueOf(height))-(4.330* Float.valueOf(age)));
        Log.d("abc",Float.toString(bmr_value));
        bmr_var.setText("BMR:"+ Float.toString(bmr_value));

    }
}
