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
import java.util.Random;

public class ComplexPlayingField extends AppCompatActivity {

    //private TextView playerOneName;
    //private TextView playerTwoName;
    private final List<int[]> combinationList = new ArrayList<>();
    private int activePlayer;
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int totalSelectBoxes = 1;

    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13, image14, image15, image16, image17, image18, image19, image20, image21, image22, image23, image24, image25;

    private int currentScoreOne= 0;
    private int currentScoreTwo = 0;

    boolean exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex_playing_field);

        //playerOneName = findViewById(R.id.playerOneName);
        //playerTwoName = findViewById(R.id.playerTwoName);
        Button exit_to_menu = findViewById(R.id.exit_menu_c);

        exit_to_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                exit = true;
                Intent intent = new Intent(ComplexPlayingField.this, MainActivity.class);
                startActivity(intent);

            }
        });

        combinationList.add(new int[]{0, 1, 2, 3, 4});
        combinationList.add(new int[]{5, 6, 7, 8, 9});
        combinationList.add(new int[]{10, 11, 12, 13, 14});
        combinationList.add(new int[]{15, 16, 17, 18, 19});
        combinationList.add(new int[]{20, 21, 22, 23, 24});
        combinationList.add(new int[]{0, 5, 10, 15, 20});
        combinationList.add(new int[]{1, 6, 11, 16, 21});
        combinationList.add(new int[]{2, 7, 12, 17, 22});
        combinationList.add(new int[]{3, 8, 13, 18, 23});
        combinationList.add(new int[]{4, 9, 14, 19, 24});
        combinationList.add(new int[]{0, 6, 12, 18, 24});
        combinationList.add(new int[]{4, 8, 12, 16, 20});


        //String getPlayerOneName = getIntent().getStringExtra("playerOne");
        //String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        //playerOneName.setText(getPlayerOneName);
        //playerTwoName.setText(getPlayerTwoName);

        image1 = findViewById(R.id.image1C);
        image2 = findViewById(R.id.image2C);
        image3 = findViewById(R.id.image3C);
        image4 = findViewById(R.id.image4C);
        image5 = findViewById(R.id.image5C);
        image6 = findViewById(R.id.image6C);
        image7 = findViewById(R.id.image7C);
        image8 = findViewById(R.id.image8C);
        image9 = findViewById(R.id.image9C);
        image10 = findViewById(R.id.image10C);
        image11 = findViewById(R.id.image11C);
        image12 = findViewById(R.id.image12C);
        image13 = findViewById(R.id.image13C);
        image14 = findViewById(R.id.image14C);
        image15 = findViewById(R.id.image15C);
        image16 = findViewById(R.id.image16C);
        image17 = findViewById(R.id.image17C);
        image18 = findViewById(R.id.image18C);
        image19 = findViewById(R.id.image19C);
        image20 = findViewById(R.id.image20C);
        image21 = findViewById(R.id.image21C);
        image22 = findViewById(R.id.image22C);
        image23 = findViewById(R.id.image23C);
        image24 = findViewById(R.id.image24C);
        image25 = findViewById(R.id.image25C);

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

        image10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(9)) {
                    performAction((ImageView) v, 9);
                }
            }
        });

        image11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(10)) {
                    performAction((ImageView) v, 10);
                }
            }
        });

        image12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(11)) {
                    performAction((ImageView) v, 11);
                }
            }
        });

        image13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(12)) {
                    performAction((ImageView) v, 12);
                }
            }
        });

        image14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(13)) {
                    performAction((ImageView) v, 13);
                }
            }
        });

        image15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(14)) {
                    performAction((ImageView) v, 14);
                }
            }
        });

        image16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(15)) {
                    performAction((ImageView) v, 15);
                }
            }
        });

        image17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(16)) {
                    performAction((ImageView) v, 16);
                }
            }
        });

        image18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(17)) {
                    performAction((ImageView) v, 17);
                }
            }
        });

        image19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(18)) {
                    performAction((ImageView) v, 18);
                }
            }
        });

        image20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(19)) {
                    performAction((ImageView) v, 19);
                }
            }
        });

        image21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(20)) {
                    performAction((ImageView) v, 20);
                }
            }
        });

        image22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(21)) {
                    performAction((ImageView) v, 21);
                }
            }
        });

        image23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(22)) {
                    performAction((ImageView) v, 22);
                }
            }
        });

        image24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(23)) {
                    performAction((ImageView) v, 23);
                }
            }
        });

        image25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(24)) {
                    performAction((ImageView) v, 24);
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
        if (computer_move == 10) {
            performAction(image10, 9);
        }
        if (computer_move == 11) {
            performAction(image11, 10);
        }
        if (computer_move == 12) {
            performAction(image12, 11);
        }
        if (computer_move == 13) {
            performAction(image13, 12);
        }
        if (computer_move == 14) {
            performAction(image14, 13);
        }
        if (computer_move == 15) {
            performAction(image15, 14);
        }
        if (computer_move == 16) {
            performAction(image16, 15);
        }
        if (computer_move == 17) {
            performAction(image17, 16);
        }
        if (computer_move == 18) {
            performAction(image18, 17);
        }
        if (computer_move == 19) {
            performAction(image19, 18);
        }
        if (computer_move == 20) {
            performAction(image20, 19);
        }
        if (computer_move == 21) {
            performAction(image21, 20);
        }
        if (computer_move == 22) {
            performAction(image22, 21);
        }
        if (computer_move == 23) {
            performAction(image23, 22);
        }
        if (computer_move == 24) {
            performAction(image24, 23);
        }
        if (computer_move == 25) {
            performAction(image25, 24);
        }
    }

    public int computer_move(){
        Random rd = new Random();
        int computer_move = rd.nextInt(25)+1;
        if (boxPositions[computer_move] == 0){
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
                ResultDialog resultDialog = new ResultDialog(ComplexPlayingField.this, "Player is a Winner!", ComplexPlayingField.this, '3');
                resultDialog.setCancelable(false);
                resultDialog.show();

                currentScoreOne++;
                scorePlayerA.setText(String.valueOf(currentScoreOne));
            } else if (totalSelectBoxes == 25){
                exit = true;
                ResultDialog resultDialog = new ResultDialog(ComplexPlayingField.this, "Match Draw", ComplexPlayingField.this, '3');
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
                ResultDialog resultDialog = new ResultDialog(ComplexPlayingField.this, "Computer is a Winner!", ComplexPlayingField.this, '3');
                resultDialog.setCancelable(false);
                resultDialog.show();

                currentScoreTwo++;
                scorePlayerB.setText(String.valueOf(currentScoreTwo));
            } else if (totalSelectBoxes == 25){
                exit = true;
                ResultDialog resultDialog = new ResultDialog(ComplexPlayingField.this, "Match Draw", ComplexPlayingField.this, '3');
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
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        activePlayer = 1;
        totalSelectBoxes = 1;

        image1 = findViewById(R.id.image1C);
        image2 = findViewById(R.id.image2C);
        image3 = findViewById(R.id.image3C);
        image4 = findViewById(R.id.image4C);
        image5 = findViewById(R.id.image5C);
        image6 = findViewById(R.id.image6C);
        image7 = findViewById(R.id.image7C);
        image8 = findViewById(R.id.image8C);
        image9 = findViewById(R.id.image9C);
        image10 = findViewById(R.id.image10C);
        image11 = findViewById(R.id.image11C);
        image12 = findViewById(R.id.image12C);
        image13 = findViewById(R.id.image13C);
        image14 = findViewById(R.id.image14C);
        image15 = findViewById(R.id.image15C);
        image16 = findViewById(R.id.image16C);
        image17 = findViewById(R.id.image17C);
        image18 = findViewById(R.id.image18C);
        image19 = findViewById(R.id.image19C);
        image20 = findViewById(R.id.image20C);
        image21 = findViewById(R.id.image21C);
        image22 = findViewById(R.id.image22C);
        image23 = findViewById(R.id.image23C);
        image24 = findViewById(R.id.image24C);
        image25 = findViewById(R.id.image25C);

        image1.setImageResource(R.drawable.white_box);
        image2.setImageResource(R.drawable.white_box);
        image3.setImageResource(R.drawable.white_box);
        image4.setImageResource(R.drawable.white_box);
        image5.setImageResource(R.drawable.white_box);
        image6.setImageResource(R.drawable.white_box);
        image7.setImageResource(R.drawable.white_box);
        image8.setImageResource(R.drawable.white_box);
        image9.setImageResource(R.drawable.white_box);
        image10.setImageResource(R.drawable.white_box);
        image11.setImageResource(R.drawable.white_box);
        image12.setImageResource(R.drawable.white_box);
        image13.setImageResource(R.drawable.white_box);
        image14.setImageResource(R.drawable.white_box);
        image15.setImageResource(R.drawable.white_box);
        image16.setImageResource(R.drawable.white_box);
        image17.setImageResource(R.drawable.white_box);
        image18.setImageResource(R.drawable.white_box);
        image19.setImageResource(R.drawable.white_box);
        image20.setImageResource(R.drawable.white_box);
        image21.setImageResource(R.drawable.white_box);
        image22.setImageResource(R.drawable.white_box);
        image23.setImageResource(R.drawable.white_box);
        image24.setImageResource(R.drawable.white_box);
        image25.setImageResource(R.drawable.white_box);
    }
}