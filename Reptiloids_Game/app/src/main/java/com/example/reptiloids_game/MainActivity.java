package com.example.reptiloids_game;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    public static boolean isLeftPressed = false; // нажата левая кнопка
    public static boolean isRightPressed = false; // нажата правая кнопка

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameView gameView = new GameView(this); // создаём gameView
        LinearLayout gameLayout = findViewById(R.id.gameLayout); // находим gameLayout
        gameLayout.addView(gameView); // и добавляем в него gameView
        Button leftButton = findViewById(R.id.leftButton); // находим кнопки
        Button rightButton = findViewById(R.id.rightButton);
        leftButton.setOnTouchListener(this); // и добавляем этот класс как слушателя (при нажатии сработает onTouch)
        rightButton.setOnTouchListener(this);
    }

    public boolean onTouch(View button, MotionEvent motion) {
        if (button.getId() == R.id.leftButton) {
            if (motion.getAction() == MotionEvent.ACTION_DOWN) {
                isLeftPressed = true;
            }
            if (motion.getAction() == MotionEvent.ACTION_UP) {
                isLeftPressed = false;

            }
        }
        if (button.getId() == R.id.rightButton) {
            if (motion.getAction() == MotionEvent.ACTION_DOWN) {
                isRightPressed = true;
            }
            if (motion.getAction() == MotionEvent.ACTION_UP) {
                isRightPressed = false;
            }

        }
        return true;
    }
}


