package com.example.firstproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class CalculatorActivity extends AppCompatActivity {

    private Button back_calc;
    private TextView result;
    private EditText num1;
    private EditText num2;
    private Button plus;
    private Button minus;
    private Button umnozhenie;
    private Button delenie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caljkuljator_1);

        result = findViewById(R.id.calc_result);
        num1 = findViewById(R.id.number1);
        num2 = findViewById(R.id.number2);
        plus = findViewById(R.id.button_plus);
        minus = findViewById(R.id.button_minus);
        umnozhenie = findViewById(R.id.button_umn);
        delenie = findViewById(R.id.button_delen);
        back_calc = findViewById(R.id.back_calc);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number1 = Double.parseDouble(num1.getText().toString());
                Double number2 = Double.parseDouble(num2.getText().toString());
                result.setText(String.valueOf(number1 + number2));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number1 = Double.parseDouble(num1.getText().toString());
                Double number2 = Double.parseDouble(num2.getText().toString());
                result.setText(String.valueOf(number1 - number2));
            }
        });

        umnozhenie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number1 = Double.parseDouble(num1.getText().toString());
                Double number2 = Double.parseDouble(num2.getText().toString());
                result.setText(String.valueOf(number1 * number2));
            }
        });

        delenie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number1 = Double.parseDouble(num1.getText().toString());
                Double number2 = Double.parseDouble(num2.getText().toString());
                if(number2 == 0){
                    result.setText("Input error");
                }else{
                    result.setText(String.valueOf(number1 / number2));
                }
            }
        });

        back_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}