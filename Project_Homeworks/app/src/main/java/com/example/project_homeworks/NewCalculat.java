package com.example.project_homeworks;

import java.text.NumberFormat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class NewCalculat extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String SAVED_PURCHASE_PRICE = "SAVED_PURCHASE_PRICE";
    private static final String SAVED_YOUR_DISCOUNT = "SAVED_YOUR_DISCOUNT";
    private static final String SAVED_NEW_PRICE = "SAVED_NEW_PRICE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_calculat);

        TextView text_discount = findViewById(R.id.discount);
        TextView text_price = findViewById(R.id.text_new_price);
        String str_discount = "Ваша скидка:  ";
        String str_price = "Стоимость покупки с учётом скидки:  ";
        String str_error = "ERROR";
        EditText purchase_price = findViewById(R.id.purchase_price);
        Button button_reset = findViewById(R.id.button_reset);
        Button button_download = findViewById(R.id.button_download);
        Button button_save = findViewById(R.id.button_save);
        Button button_discount = findViewById(R.id.button_discount);

        button_discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = purchase_price.getText().toString();
                if (keyword.equals("")){
                    text_discount.setText(String.valueOf(str_discount + str_error));
                    text_price.setText(String.valueOf(str_price + str_error));
                }else {
                    double cost = Double.parseDouble(keyword);
                    double discount = 0;

                    if (cost >= 500 && cost < 1000) {
                        discount = cost * 0.03;
                    }
                    if (cost >= 1000) {
                        discount = cost * 0.05;
                    }

                    Locale usLocale = new Locale("ru", "RU");
                    NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(usLocale);

                    text_discount.setText(String.valueOf(str_discount + usCurrencyFormat.format(discount)));
                    text_price.setText(String.valueOf(str_price + usCurrencyFormat.format((cost - discount))));
                }
            }
        });

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SAVED_PURCHASE_PRICE, purchase_price.getText().toString());
                editor.putString(SAVED_YOUR_DISCOUNT, text_discount.getText().toString());
                editor.putString(SAVED_NEW_PRICE, text_price.getText().toString());
                editor.apply();
                Toast.makeText(NewCalculat.this, "Данные сохранены", Toast.LENGTH_SHORT).show();
            }
        });

        button_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchase_price.getText().clear();
                text_discount.setText(String.valueOf(str_discount));
                text_price.setText(String.valueOf(str_price));
            }
        });

        button_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String saved_PP = sharedPreferences.getString(SAVED_PURCHASE_PRICE, null);
                String saved_YD = sharedPreferences.getString(SAVED_YOUR_DISCOUNT, null);
                String saved_NP = sharedPreferences.getString(SAVED_NEW_PRICE, null);
                purchase_price.setText(saved_PP);
                text_discount.setText(String.valueOf(saved_YD));
                text_price.setText(String.valueOf(saved_NP));
            }
        });
    }
}