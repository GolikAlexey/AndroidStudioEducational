package com.example.game_dz;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.util.SparseIntArrayKt;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer sound_start_game, sound_prav_0,  sound_no_prav, sound_prav_end;
    private TextView questionTextView,questionTextView2;
    private ImageView imageFon;
    private Button answerButton1, answerButton2, answerButton3, answerButton4,buttonLevel2,buttonBack;


    private String[] questions = {
            "Какой цвет у неба?",
            "Что растёт в огороде?",
            "Как называют микроавтобусы, совершающие поездки по определённым маршрутам?",
            "О чём писал Грибоедов, отмечая, что он «нам сладок и приятен?",
            "Какого персонажа нет в известной считалке «На золотом крыльце сидели ?.",
            "Какоой специалист занимается изучением неопознанных летающих объектов? ",
            "Как называется разновидность воды, в которой атом водорода замещён его изотопом дейтерием?",
            "Что такое десница? ",
            "В какое море впадает река Урал? ",
            "На что кладут руку члены английского общества лысых во время присяги?",
            "Как назывался каменный монолит, на котором установлен памятник Петру I в Санкт-Петербурге?",
            "Как Пётр Ильич Чайковский назвал свою серенаду для скрипки с оркестром си-бемоль минор?",
            "Какого ордена не было у первого советского космонавта Юрия Гагарина? ",
            "Какое животное имеет второе название — кугуар?"
    };
    private String[] questions2 = {
            "вопрос на 100 рублей.",
            "вопрос на 200 рублей.",
            "вопрос на 300 рублей.",
            "вопрос на 500 рублей.",
            "вопрос на 1000 рублей.",
            "вопрос на 2000 рублей.",
            "вопрос на 4000 рублей.",
            "вопрос на 8000 рублей.",
            "вопрос на 16000 рублей.",
            "вопрос на 32000 рублей.",
            "вопрос на 64000 рублей.",
            "вопрос на 125000 рублей.",
            "вопрос на 500000 рублей.",
            "вопрос на 1000000 рублей."
    };
    private String[][] answers = {
            {"A:  Синий", "B:  Зеленый", "C:  Красный", "D:  Желтый"},
            {"A:  Лук", "B:  Пистолет ", "C:  Пулемёт ", "D:  Ракета СС-20"},
            {"A:  Рейсовка ", "B:  Путёвка  ", "C:  Курсовка  ", "D:  Маршрутка "},
            {"A:  Дым Отечества ", "B:  Дух купечества  ", "C:  Дар пророчества", "D:  Пыл девичества"},
            {"A:  Сапожника", "B:  Кузнеца", "C:  Короля", "D:  Портного"},
            {"A:  Кинолог     ", "B:  Уфолог    ", "C:  Сексопатолог", "D:  Психиатр   "},
            {"A:  Лёгкая      ", "B:  Средняя   ", "C:  Тяжёлая     ", "D:  Невесомая    "},
            {"A:  Бровь       ", "B:  Глаз      ", "C:  Шея      ", "D:  Рука     "},
            {"A:  Азовское    ", "B:  Чёрное    ", "C:  Средиземное       ", "D:  Каспийское      "},
            {"A:  Баскетбольный мяч", "B:  Бильярдный шар", "C:  Апельсин", "D:  Кокосовый орех"},
            {"A:  Дом-камень", "B:  Гром-камень", "C:   Гора-камень", "D:  Разрыв-камень"},
            {"A:  Флегматическая", "B:  Меланхолическая", "C:  Холерическая", "D:  Сангвиническая"},
            {"A:  «Ожерелье Нила» (Египет)", "B:  «Крест Грюнвальда» (Польша)", "C:  «Плайя Хирон» (Куба)", "D:  «Орден двойного дракона» (Китай)"},
            {"A:  Оцелот", "B:  Леопард", "C:  Пума", "D:  Пантера "}
    };

    private int[] correctAnswers = {0, 0, 3, 0, 1, 1, 2, 3, 3, 1, 1, 1, 3, 2}; // Индексы правильных ответов

    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sound_start_game = MediaPlayer.create(this, R.raw.start_game);
        //sound_start_game.start();
        //sound_sled_vopros = MediaPlayer.create(this, R.raw.sled_vopros);
        sound_prav_0 = MediaPlayer.create(this, R.raw.prav);
        //sound_prav_1 = MediaPlayer.create(this, R.raw.prav2);
        sound_prav_end = MediaPlayer.create(this, R.raw.prav_end);


        sound_no_prav = MediaPlayer.create(this, R.raw.no_prav);

        questionTextView = findViewById(R.id.questionTextView);
        questionTextView2 = findViewById(R.id.questionTextView2);
        answerButton1 = findViewById(R.id.answerButton1);
        answerButton2 = findViewById(R.id.answerButton2);
        answerButton3 = findViewById(R.id.answerButton3);
        answerButton4 = findViewById(R.id.answerButton4);
        buttonLevel2 = findViewById(R.id.buttonLevel2);
        buttonBack = findViewById(R.id.buttonBack);
        imageFon = findViewById(R.id.imageFon);



        loadQuestion();

        answerButton1.setOnClickListener(v -> checkAnswer(0));
        answerButton2.setOnClickListener(v -> checkAnswer(1));
        answerButton3.setOnClickListener(v -> checkAnswer(2));
        answerButton4.setOnClickListener(v -> checkAnswer(3));
    }

    private void loadQuestion() {

        questionTextView.setText(questions[currentQuestionIndex]); // показываем вопрос
        questionTextView2.setText(questions2[currentQuestionIndex]); // показываем приз рублей
        answerButton1.setText(answers[currentQuestionIndex][0]); // показываем вариант ответа A
        answerButton2.setText(answers[currentQuestionIndex][1]);// показываем вариант ответа B
        answerButton3.setText(answers[currentQuestionIndex][2]);// показываем вариант ответа C
        answerButton4.setText(answers[currentQuestionIndex][3]);// показываем вариант ответа D
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
                questionTextView.setText("Поздравляем! \nВы выиграли!\n1000000 рублей!");
                questionTextView.setTextColor(ContextCompat.getColor(this, R.color.pink));
                questionTextView.setBackgroundResource(R.color.black);
                questionTextView2.setTextColor(Color.TRANSPARENT); //
                answerButton1.setVisibility(View.GONE);
                answerButton2.setVisibility(View.GONE);
                answerButton3.setVisibility(View.GONE);
                answerButton4.setVisibility(View.GONE);
                imageFon.setImageResource(R.drawable.priz);
                sound_prav_end.start();
                buttonLevel2.setTextColor(ContextCompat.getColor(this, R.color.green));
                buttonBack.setTextColor(ContextCompat.getColor(this, R.color.green));
                // нажимаемна НА КНОПКУ НАЗАД, чтобы начать сначало
                buttonBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                buttonLevel2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sound_prav_end.stop();
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }
                });

            }
        } else {
            // Неправильный ответ
            sound_start_game.stop();
            questionTextView.setText("Неправильный ответ!\n Попробуйте снова!");
            sound_no_prav.start(); // трек неправильного ответа
        }
    }
}