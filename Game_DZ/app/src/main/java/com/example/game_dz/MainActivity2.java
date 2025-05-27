package com.example.game_dz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.util.SparseIntArrayKt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private MediaPlayer sound_start_game, sound_prav_0, sound_no_prav, sound_prav_end;
    private TextView questionTextView21,questionTextView22;
    private ImageView imageFon2;
    private Button answerButton21, answerButton22, answerButton23, answerButton24,buttonLevel2,buttonBack2;


    private String[] questions = {
            "Что в России 19 века делали в дортуаре?",
            "Какой химический элемент назван в честь злого подземного гнома? ",
            "Какой русский праздник является аналогом католического Карнавала?",
            "Какого числа отмечается Всемирный день поцелуя?",
            "Какие овощи изначально были основой фонарей для Хэллоуина?",
            "Какой важнейший христианский праздник не соответствует своему названию?",
            "Когда празднуют день числа Пи?",
            "Когда празднуют международный день вязания?",
            "Какая свадебная традиция произошла от ковбоев?",
            "Кому и в какой день швейцары писали адрес мелом на спинах?",
            "Какой праздник отмечают 4 июля в финском городе Сонкайрави?",
            "Каким корейцам предписано 14 апреля идти в ресторан и есть чёрную лапшу?",
            "Какой праздник какого животного на Руси отмечался 15 января?",
            "Какой праздник отмечают в Италии 21 марта?",
            "Какой праздник проходит в каждый последний понедельник августа в Ллануртид-Уэлс, Великобритании?"
    };
    private String[] questions2 = {
            "вопрос на 500 рублей.",
            "вопрос на 1000 рублей.",
            "вопрос на 2000 рублей.",
            "вопрос на 3000 рублей.",
            "вопрос на 5000 рублей.",
            "вопрос на 10000 рублей.",
            "вопрос на 15000 рублей.",
            "вопрос на 25000 рублей.",
            "вопрос на 50000 рублей.",
            "вопрос на 100000 рублей.",
            "вопрос на 200000 рублей.",
            "вопрос на 400000 рублей.",
            "вопрос на 800000 рублей.",
            "вопрос на 1500000 рублей.",
            "вопрос на 3000000 рублей."
    };
    private String[][] answers = {
            {"A:  Ели", "B:  Спали", "C:  Ездили верхом", "D:  Купались"},
            {"A:  Гафний", "B:  Кобальт  ", "C:  Бериллий  ", "D:  Теллур "},
            {"A:  Новый год", "B:  Рождество  ", "C:  Пасха  ", "D:  Масленица "},
            {"A:  6 июля", "B:  15 мая", "C:  3 августа", "D:  1 января"},
            {"A:  Тыква", "B:  Репа", "C:  Баклажан", "D:  Патисон"},
            {"A:  Троица ", "B:  Пасха    ", "C:  Крещение", "D:  Рождество   "},
            {"A:  12 июля", "B:  14 марта   ", "C:  1 декабря     ", "D:  14 сентября    "},
            {"A:  11 июня", "B:  1 августа", "C:  1 апреля", "D:  11 октября"},
            {"A:  Подарки новобрачным", "B:  Обмен кольцами", "C:  Выкуп невесты", "D:  Автомобили"},
            {"A:  Новобрачным на свадьбе", "B:  Ученикам в начале учебного года", "C:  Соседям 1 апреля", "D:  Студентам в «Татьянин день»"},
            {"A:  Тёщи", "B:  Домашних животных", "C:   Сбора урожая", "D:  Жены"},
            {"A:  Женатым", "B:  Холостым", "C:  Голодным", "D:  Не получившим подарков"},
            {"A:  Кошек", "B:  Коров", "C:  Овец", "D:  Кур"},
            {"A:  Праздник спагетти", "B:  День дерева", "C:  Праздник пасты", "D:  День влюблённых"},

            {"A:  Бега за катящимся сыром", "B:  Чемпионат по нырянию в болото", "C:  Международный день поцелуя", "D:  Чемпионат мира по горным устрицам"}
    };

    private int[] correctAnswers = {1, 1, 3, 0, 0, 3, 1, 0, 3, 3, 3, 3, 3, 1, 1}; // Индексы правильных ответов

    private int currentQuestionIndex = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sound_start_game = MediaPlayer.create(this, R.raw.start_game);
        sound_start_game.start();
        //sound_sled_vopros = MediaPlayer.create(this, R.raw.sled_vopros);
        sound_prav_0 = MediaPlayer.create(this, R.raw.prav);
        //sound_prav_1 = MediaPlayer.create(this, R.raw.prav2);
        sound_prav_end = MediaPlayer.create(this, R.raw.prav_end);


        sound_no_prav = MediaPlayer.create(this, R.raw.no_prav);

        questionTextView21 = findViewById(R.id.questionTextView21);
        questionTextView22 = findViewById(R.id.questionTextView22);
        answerButton21 = findViewById(R.id.answerButton21);
        answerButton22 = findViewById(R.id.answerButton22);
        answerButton23 = findViewById(R.id.answerButton23);
        answerButton24 = findViewById(R.id.answerButton24);
        buttonLevel2 = findViewById(R.id.buttonLevel2);
        buttonBack2 = findViewById(R.id.buttonBack2);
        imageFon2 = findViewById(R.id.imageFon2);

//        buttonBack2 = findViewById(R.id.buttonBack2);
//        imageFon2 = findViewById(R.id.imageFon2);



        loadQuestion();

        answerButton21.setOnClickListener(v -> checkAnswer(0));
        answerButton22.setOnClickListener(v -> checkAnswer(1));
        answerButton23.setOnClickListener(v -> checkAnswer(2));
        answerButton24.setOnClickListener(v -> checkAnswer(3));
    }

    private void loadQuestion() {
        questionTextView21.setText(questions[currentQuestionIndex]); // показываем вопрос
        questionTextView22.setText(questions2[currentQuestionIndex]); // показываем приз рублей
        answerButton21.setText(answers[currentQuestionIndex][0]); // показываем вариант ответа A
        answerButton22.setText(answers[currentQuestionIndex][1]);// показываем вариант ответа B
        answerButton23.setText(answers[currentQuestionIndex][2]);// показываем вариант ответа C
        answerButton24.setText(answers[currentQuestionIndex][3]);// показываем вариант ответа D
    }

    private void checkAnswer(int selectedAnswer) {
        if (selectedAnswer == correctAnswers[currentQuestionIndex]) {
            // Правильный ответ
            sound_prav_0.start(); // трек правильного ответа
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                sound_start_game.stop();
                loadQuestion();
            } else {
                // Конец игры Вы миллионер
                questionTextView21.setText("Поздравляем! \nВы выиграли!\n3000000 рублей!");
                questionTextView21.setTextColor(ContextCompat.getColor(this, R.color.pink));
                questionTextView21.setBackgroundResource(R.color.black);
                questionTextView22.setTextColor(Color.TRANSPARENT); //
                answerButton21.setVisibility(View.GONE);
                answerButton22.setVisibility(View.GONE);
                answerButton23.setVisibility(View.GONE);
                answerButton24.setVisibility(View.GONE);
                imageFon2.setImageResource(R.drawable.priz);
                sound_prav_end.start();
                //buttonLevel2.setTextColor(ContextCompat.getColor(this, R.color.green));
                buttonBack2.setTextColor(ContextCompat.getColor(this, R.color.green));
                // нажимаемна фоновую картинку, чтобы начать сначало
                buttonBack2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
//                buttonLevel2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
//                        startActivity(intent);
//                    }
//                });

            }
        } else {
            // Неправильный ответ
            sound_start_game.stop();
            questionTextView21.setText("Неправильный ответ!\n Попробуйте снова!");
            sound_no_prav.start(); // трек неправильного ответа
        }
    }
}