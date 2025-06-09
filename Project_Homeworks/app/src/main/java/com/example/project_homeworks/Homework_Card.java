package com.example.project_homeworks;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.ViewSwitcher;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Homework_Card extends AppCompatActivity {

    EditText text_tovar_name;
    EditText text_tovar_price;
    Button button_add_tovar;
    RecyclerView recycleViewCard;

    List<String> cardList = new ArrayList<>();
    List<String> priceList = new ArrayList<>();
    CardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_homework_card);

        text_tovar_name = findViewById(R.id.editTextTovarName);
        text_tovar_price = findViewById(R.id.editTextTovarPrice);
        button_add_tovar = findViewById(R.id.button_add_tovar);
        recycleViewCard = findViewById(R.id.recycleView_card);

        recycleViewCard.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        adapter = new CardAdapter(cardList, priceList);
        recycleViewCard.setAdapter(adapter);

        button_add_tovar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data;
                data = text_tovar_name.getText().toString();
                cardList.add(data);
                text_tovar_name.setText("");
                adapter.notifyDataSetChanged();

                Locale usLocale = new Locale("ru", "RU");
                NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(usLocale);
                data = usCurrencyFormat.format(text_tovar_price.getText().toString());
                priceList.add(data);
                text_tovar_price.setText("");
                adapter.notifyDataSetChanged();

            }
        });

    }

}