package com.example.firstproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //private TextView primary_text1;
    //private TextView primary_text2;
    //private Button test_button2;
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
        EdgeToEdge.enable(this);
        setContentView(R.layout.caljkuljator_1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calc1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        result = findViewById(R.id.calc_result);
        num1 = findViewById(R.id.number1);
        num2 = findViewById(R.id.number2);
        plus = findViewById(R.id.button_plus);
        minus = findViewById(R.id.button_minus);
        umnozhenie = findViewById(R.id.button_umn);
        delenie = findViewById(R.id.button_delen);

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

        //primary_text2 = findViewById(R.id.text_hw2);
        //test_button2 = findViewById(R.id.button_hw2);

        //test_button2.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        primary_text2.setText("HELLO HELLO WORLD");
        //        primary_text2.setTextSize(30);
        //    }
        //});
    }
    //public void sayHello(View view){
    //    primary_text1 = findViewById(R.id.text_hw1);
    //    primary_text1.setText("Hello world! Hello, Android!");
    //    primary_text1.setTextSize(30);
    //}
}