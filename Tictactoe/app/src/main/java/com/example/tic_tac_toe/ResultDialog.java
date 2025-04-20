package com.example.tic_tac_toe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ResultDialog extends Dialog {
    private final String message;
    private Multiplayer_playing_field playingField_MP;
    private SimplePlayingField playingField_S;
    private ComplexPlayingField playingField_C;
    private final char game_indicator;

    public ResultDialog(@NonNull Context context, String message, Multiplayer_playing_field playingField, char game_indicator) {
        super(context);
        this.message = message;
        this.playingField_MP = playingField;
        this.game_indicator = game_indicator;
    }

    public ResultDialog(@NonNull Context context, String message, SimplePlayingField playingField, char game_indicator) {
        super(context);
        this.message = message;
        this.playingField_S = playingField;
        this.game_indicator = game_indicator;
    }

    public ResultDialog(@NonNull Context context, String message, ComplexPlayingField playingField, char game_indicator) {
        super(context);
        this.message = message;
        this.playingField_C = playingField;
        this.game_indicator = game_indicator;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_dialog);

        TextView messageText = findViewById(R.id.messageText);
        Button startAganeButton = findViewById(R.id.startAgainButton);

        messageText.setText(message);

        if(game_indicator=='1'){
            startAganeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playingField_MP.restartMatch();
                    dismiss();  // закрытие окна
                }
            });
        }else if(game_indicator=='2'){
            startAganeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playingField_S.restartMatch();
                    dismiss();  // закрытие окна
                }
            });
        }else if(game_indicator=='3'){
            startAganeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //playingField_C.restartMatch();
                    dismiss();  // закрытие окна
                }
            });
        }
    }
}