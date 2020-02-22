package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import static java.lang.Double.*;

public class DetailsActivity extends AppCompatActivity {
    private Bundle extras;
    private TextView bmiValue;
    private TextView details;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        bmiValue = findViewById(R.id.bmiValue);
        details = findViewById(R.id.details);


        extras = getIntent().getExtras();

        if (extras != null) {
           double format;
            format = parseDouble(Objects.requireNonNull(extras.getString("format")));


            if (format<18.5){
                bmiValue.setText("your BMI is "+format);
                Toast.makeText(getApplicationContext(),"your values is "+format,Toast.LENGTH_LONG).show();

                details.setText("your underWeight");

            }else if (format>=18.5 && format<25){
                bmiValue.setText("your BMIis "+format);
                details.setText("you have a normal BMi...");
            }else if (format>=25 && format<30){
                bmiValue.setText("your BMI is "+format);
                details.setText("your overWeight");
              


            }
        }
    }

}