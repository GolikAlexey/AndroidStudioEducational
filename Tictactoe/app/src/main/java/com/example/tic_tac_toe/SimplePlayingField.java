package com.example.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SimplePlayingField extends AppCompatActivity {

    //private TextView playerOneName;
    //private TextView playerTwoName;
    private final List<int[]> combinationList = new ArrayList<>();
    private int activePlayer;
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int totalSelectBoxes = 1;

    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;

    private int currentScoreOne= 0;
    private int currentScoreTwo = 0;

    boolean exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_playing_field);

        //playerOneName = findViewById(R.id.playerOneName);
        //playerTwoName = findViewById(R.id.playerTwoName);
        Button exit_to_menu = findViewById(R.id.exit_menu_s);

        exit_to_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                exit = true;
                Intent intent = new Intent(SimplePlayingField.this, MainActivity.class);
                startActivity(intent);

            }
        });

        combinationList.add(new int[]{0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{0, 4, 8});
        combinationList.add(new int[]{2, 4, 6});


        //String getPlayerOneName = getIntent().getStringExtra("playerOne");
        //String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        //playerOneName.setText(getPlayerOneName);
        //playerTwoName.setText(getPlayerTwoName);

        image1 = findViewById(R.id.image1S);
        image2 = findViewById(R.id.image2S);
        image3 = findViewById(R.id.image3S);
        image4 = findViewById(R.id.image4S);
        image5 = findViewById(R.id.image5S);
        image6 = findViewById(R.id.image6S);
        image7 = findViewById(R.id.image7S);
        image8 = findViewById(R.id.image8S);
        image9 = findViewById(R.id.image9S);

        changePlayerTurn(activePlayer);

        boolean exit = false;

        while (exit == false){

            activePlayer = 1;
            movePlayer();
            activePlayer = 2;
            moveComputer();

        }
    }

        public void movePlayer() {
            image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(0)) {
                        performAction((ImageView) v, 0);
                    }
                }
            });

            image2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(1)) {
                        performAction((ImageView) v, 1);
                    }
                }
            });

            image3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(2)) {
                        performAction((ImageView) v, 2);
                    }
                }
            });

            image4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(3)) {
                        performAction((ImageView) v, 3);
                    }
                }
            });

            image5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(4)) {
                        performAction((ImageView) v, 4);
                    }
                }
            });

            image6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(5)) {
                        performAction((ImageView) v, 5);
                    }
                }
            });

            image7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(6)) {
                        performAction((ImageView) v, 6);
                    }
                }
            });

            image8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(7)) {
                        performAction((ImageView) v, 7);
                    }
                }
            });

            image9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBoxSelectable(8)) {
                        performAction((ImageView) v, 8);
                    }
                }
            });
        }

     public void moveComputer() {
         int computer_move = computer_move();

         if (computer_move == 1) {
             performAction(image1, 0);
         }
         if (computer_move == 2) {
             performAction(image2, 1);
         }
         if (computer_move == 3) {
             performAction(image3, 2);
         }
         if (computer_move == 4) {
             performAction(image4, 3);
         }
         if (computer_move == 5) {
             performAction(image5, 4);
         }
         if (computer_move == 6) {
             performAction(image6, 5);
         }
         if (computer_move == 7) {
             performAction(image7, 6);
         }
         if (computer_move == 8) {
             performAction(image8, 7);
         }
         if (computer_move == 9) {
             performAction(image9, 8);
         }
     }

    public int computer_move(){
        int computer_move = (int) Math.random()*10;
        if(computer_move == 0){
            return computer_move();
        }else if (boxPositions[computer_move] == 0){
            return computer_move;
        }else{
            return computer_move();
        }
    }

    private void performAction(ImageView imageView, int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = activePlayer;
        imageView.setBackgroundResource(R.drawable.white_box);
        imageView.setScaleType(ImageView.ScaleType.CENTER);

        //playerOneName = findViewById(R.id.playerOneName);
        //playerTwoName = findViewById(R.id.playerTwoName);

        TextView scorePlayerA = findViewById(R.id.scoreOne);
        TextView scorePlayerB = findViewById(R.id.scoreTwo);

        if (activePlayer == 1) {
            imageView.setImageResource(R.drawable.ximage);

            if (checkResults()){
                exit = true;
                ResultDialog resultDialog = new ResultDialog(SimplePlayingField.this, "Player is a Winner!", SimplePlayingField.this, '2');
                resultDialog.setCancelable(false);
                resultDialog.show();

                currentScoreOne++;
                scorePlayerA.setText(String.valueOf(currentScoreOne));
            } else if (totalSelectBoxes == 9){
                exit = true;
                ResultDialog resultDialog = new ResultDialog(SimplePlayingField.this, "Match Draw", SimplePlayingField.this, '2');
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(2);
                totalSelectBoxes++;
            }
        }
        if (activePlayer == 2) {
            imageView.setImageResource(R.drawable.oimage);

            if (checkResults()){
                exit = true;
                ResultDialog resultDialog = new ResultDialog(SimplePlayingField.this, "Computer is a Winner!", SimplePlayingField.this, '2');
                resultDialog.setCancelable(false);
                resultDialog.show();

                currentScoreTwo++;
                scorePlayerB.setText(String.valueOf(currentScoreTwo));
            } else if (totalSelectBoxes == 9){
                exit = true;
                ResultDialog resultDialog = new ResultDialog(SimplePlayingField.this, "Match Draw", SimplePlayingField.this, '2');
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(1);
                totalSelectBoxes++;
            }
        }
    }

    private boolean checkResults(){
        boolean response = false;
        for (int i = 0; i < combinationList.size(); i++) {
            final  int[] combination = combinationList.get(i);

            if(boxPositions[combination[0]]  == activePlayer && boxPositions[combination[1]]  == activePlayer && boxPositions[combination[2]]  == activePlayer){
                response = true;
            }
        }
        return response;
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        activePlayer = currentPlayerTurn;

        LinearLayout playerOneLayoutOuter = findViewById(R.id.playerOneLayoutOuter);
        LinearLayout playerTwoLayoutOuter = findViewById(R.id.playerTwoLayoutOuter);

        if (activePlayer == 1) {
            playerOneLayoutOuter.setBackgroundResource(R.drawable.black_border);
            playerTwoLayoutOuter.setBackgroundResource(R.drawable.white_box);

        }
        if (activePlayer == 2) {
            playerTwoLayoutOuter.setBackgroundResource(R.drawable.black_border);
            playerOneLayoutOuter.setBackgroundResource(R.drawable.white_box);
        }
    }

    private boolean isBoxSelectable(int boxPosition) {
        boolean response = false;
        if (boxPositions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }

    public void restartMatch() {
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        activePlayer = 1;
        totalSelectBoxes = 1;

        image1 = findViewById(R.id.image1S);
        image2 = findViewById(R.id.image2S);
        image3 = findViewById(R.id.image3S);
        image4 = findViewById(R.id.image4S);
        image5 = findViewById(R.id.image5S);
        image6 = findViewById(R.id.image6S);
        image7 = findViewById(R.id.image7S);
        image8 = findViewById(R.id.image8S);
        image9 = findViewById(R.id.image9S);

        image1.setImageResource(R.drawable.white_box);
        image2.setImageResource(R.drawable.white_box);
        image3.setImageResource(R.drawable.white_box);
        image4.setImageResource(R.drawable.white_box);
        image5.setImageResource(R.drawable.white_box);
        image6.setImageResource(R.drawable.white_box);
        image7.setImageResource(R.drawable.white_box);
        image8.setImageResource(R.drawable.white_box);
        image9.setImageResource(R.drawable.white_box);
    }
}