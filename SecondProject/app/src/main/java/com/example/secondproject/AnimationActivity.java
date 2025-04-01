package com.example.secondproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.graphics.drawable.AnimationDrawable;
import android.view.animation.AnimationUtils;


public class AnimationActivity extends AppCompatActivity {
private Button button_back_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        button_back_animation = findViewById(R.id.back_animation);
        ImageView animation = findViewById(R.id.animation_hand);

        animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AnimationDrawable) animation.getDrawable()).start();
                Animation translate = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.anim_translate);
                animation.startAnimation(translate);
            }
        });

        button_back_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}