package com.example.secondproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.ImageButton;
import android.media.MediaPlayer;

public class MusicActivity extends AppCompatActivity {
    private Button back_music;
    private Button music_stop;
    private ImageButton music_button1;
    private ImageButton music_button2;
    private MediaPlayer music1;
    private MediaPlayer music2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);

        back_music = findViewById(R.id.back_music);
        music_stop = findViewById(R.id.stop_button);
        music_button1 = findViewById(R.id.music_button_1);
        music_button2 = findViewById(R.id.music_button_2);
        music1 = MediaPlayer.create(this, R.raw.sound_1);
        music2 = MediaPlayer.create(this, R.raw.sound_2);

        back_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        music_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayButton(music1, music2);
            }
        });

        music_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayButton(music2, music1);
            }
        });

        music_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(music1.isPlaying()){
                    music1.stop();
                }
                if(music2.isPlaying()){
                    music2.stop();
                }
            }

        });
    }
    public void soundPlayButton(MediaPlayer sound1, MediaPlayer sound2){
        if (sound1.isPlaying()){
            sound1.pause();
            sound2.seekTo(0);
            sound1.setLooping(false);
        }
        if (sound2.isPlaying()){
            sound2.pause();
            sound1.seekTo(0);
            sound2.setLooping(false);
        }
        sound1.start();
        sound1.setLooping(true);
    }

}