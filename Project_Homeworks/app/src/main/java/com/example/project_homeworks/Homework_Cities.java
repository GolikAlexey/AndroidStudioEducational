package com.example.project_homeworks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Homework_Cities extends AppCompatActivity {
    Spinner spinnerCities = findViewById(R.id.spinner_cities);
    Button buttonCities = findViewById(R.id.button_cities);
    ImageView coat_of_arms = findViewById(R.id.Gerb);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_cities);

        buttonCities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = spinnerCities.getSelectedItemPosition();
                if (position == 0){
                    coat_of_arms.setImageDrawable(getResources().getDrawable(R.drawable.moskva));
                } else if (position == 1){
                    coat_of_arms.setImageDrawable(getResources().getDrawable(R.drawable.peterburg));
                } else if (position == 2){
                    coat_of_arms.setImageDrawable(getResources().getDrawable(R.drawable.vlladivostok));
                } else if (position == 3){
                    coat_of_arms.setImageDrawable(getResources().getDrawable(R.drawable.krasnojarsk));
                } else if (position == 4){
                    coat_of_arms.setImageDrawable(getResources().getDrawable(R.drawable.sochi));
                } else if (position == 5){
                    coat_of_arms.setImageDrawable(getResources().getDrawable(R.drawable.tjumenj));
                } else if (position == 6){
                    coat_of_arms.setImageDrawable(getResources().getDrawable(R.drawable.cheljabinsk));
                } else if (position == 7) {
                    coat_of_arms.setImageDrawable(getResources().getDrawable(R.drawable.jaroslavlj));
                }
            }
        });

    }
}