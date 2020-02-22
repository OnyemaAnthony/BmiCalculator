package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText weight;
    private EditText height;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setElevation(0);

        weight = findViewById(R.id.weight_text);
        height = findViewById(R.id.height_text);
        calculate = findViewById(R.id.calculateButton);

        calculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String weightvalue = weight.getText().toString().trim();
        String heightValue = height.getText().toString().trim();

        if (weightvalue.equals("") && heightValue.equals("")) {

            Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_LONG).show();
        }else {

            if (heightValue.equals("0")){
                Toast.makeText(getApplicationContext(),"zero height not allowed",Toast.LENGTH_LONG).show();
                return;
            }
            double weight = Double.parseDouble(weightvalue);
            double height = Double.parseDouble(heightValue);
            double heightSquare = height * height;
            double result = weight/heightSquare;




            DecimalFormat decimalFormat = new DecimalFormat("00.00");
            String format =decimalFormat.format(result);

            Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
            intent.putExtra("format",format);
            intent.putExtra("size",7);
            startActivity(intent);
            finish();





        }
    }
}
