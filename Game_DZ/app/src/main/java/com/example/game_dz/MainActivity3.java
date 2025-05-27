package com.example.game_dz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    private MediaPlayer sound_start_game;
    private ImageView imageFon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        sound_start_game = MediaPlayer.create(this, R.raw.start_game);
        sound_start_game.start();

        imageFon = findViewById(R.id.imageViewFon);
        imageFon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound_start_game.stop();
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Задержка перед переходом на основную активность
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
                finish(); // Закрываем
            }
        }, 12000); // Задержка в 3 секунды
    }
}