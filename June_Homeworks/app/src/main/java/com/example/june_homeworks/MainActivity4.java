package com.example.june_homeworks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity4 extends AppCompatActivity {

    private final static String FILE_NAME = "content.txt";
    Button saveText, openText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        saveText = findViewById(R.id.save_text);
        openText = findViewById(R.id.open_text);

        saveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;

                EditText textBox = findViewById(R.id.editor);
                String text = textBox.getText().toString();
                try {
                    fos = openFileOutput(FILE_NAME, MODE_PRIVATE);  // MODE_APPEND
                    fos.write(text.getBytes());
                    Toast.makeText(MainActivity4.this, "Файл сохранен", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity4.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        Toast.makeText(MainActivity4.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        openText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fis = null;
                TextView textView = findViewById(R.id.text);

                try {
                    fis = openFileInput(FILE_NAME);
                    byte[] bytes = new byte[fis.available()];
                    fis.read(bytes);
                    String text = new String(bytes);
                    textView.setText(text);
                } catch (IOException e) {
                    Toast.makeText(MainActivity4.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                } finally {
                    try {
                        if(fis != null){
                            fis.close();
                        }
                    } catch (IOException e) {
                        Toast.makeText(MainActivity4.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}