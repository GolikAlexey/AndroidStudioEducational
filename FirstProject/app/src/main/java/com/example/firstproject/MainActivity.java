package com.example.firstproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextView primary_text1;
    private TextView primary_text2;
    private Button test_button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.homework_9_03_2025);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.buttons), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        primary_text2 = findViewById(R.id.text_hw2);
        test_button2 = findViewById(R.id.button_hw2);

        test_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primary_text2.setText("HELLO HELLO WORLD");
                primary_text2.setTextSize(30);
            }
        });
    }
    public void sayHello(View view){
        primary_text1 = findViewById(R.id.text_hw1);
        primary_text1.setText("Hello world! Hello, Android!");
        primary_text1.setTextSize(30);
    }
}