package com.example.project_homeworks;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Radiobuttons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobuttons);

        TextView sampleTextView = findViewById(R.id.sampleTextView);
        CheckBox boldCheckBox = findViewById(R.id.boldCheckBox);
        CheckBox italicCheckBox = findViewById(R.id.italicCheckBox);

        boldCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if (italicCheckBox.isChecked()){
                        sampleTextView.setTypeface(null, Typeface.BOLD_ITALIC);
                    }else {
                        sampleTextView.setTypeface(null, Typeface.BOLD);
                    }
                }else {
                    if (italicCheckBox.isChecked()){
                        sampleTextView.setTypeface(null, Typeface.ITALIC);
                    }else {
                        sampleTextView.setTypeface(null, Typeface.NORMAL);
                    }
                }

            }
        });

        italicCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if (boldCheckBox.isChecked()){
                        sampleTextView.setTypeface(null, Typeface.BOLD_ITALIC);
                    }else {
                        sampleTextView.setTypeface(null, Typeface.BOLD);
                    }
                }else {
                    if (boldCheckBox.isChecked()){
                        sampleTextView.setTypeface(null, Typeface.BOLD);
                    }else {
                        sampleTextView.setTypeface(null, Typeface.NORMAL);
                    }
                }
            }
        });
    }
}