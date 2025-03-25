package com.example.secondproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextView primary_text2;
    private Button button_open_music;
    private Button button_open_calculator;
    private Button test_button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primary_text2 = findViewById(R.id.text_hw2);
        button_open_music = findViewById(R.id.button_open_music);
        button_open_calculator = findViewById(R.id.button_open_calculator);
        test_button2 = findViewById(R.id.button_text_hw);

        test_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primary_text2.setText("HELLO HELLO WORLD");
                primary_text2.setTextSize(30);
            }
        });

        button_open_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(intent);
            }
        });

        button_open_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });

    }
}