package com.example.mytown;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private ImageButton backButton;
    private EditText nameSignUp, emailSignUp, passwordSingUp, passwordConfirmSignUp;
    private Button signUpButton;
    private DataBaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);

        backButton = findViewById(R.id.backButton);

        nameSignUp = findViewById(R.id.signUpName);
        emailSignUp = findViewById(R.id.signUpEmail);
        passwordSingUp = findViewById(R.id.signUpPassword);
        passwordConfirmSignUp = findViewById(R.id.singUpConfirmPassword);

        signUpButton = findViewById(R.id.signUpButton);

        myDB = new DataBaseHelper(this);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        insertUser();

    }

    private void insertUser() {
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameSignUp.getText().toString();
                String email = emailSignUp.getText().toString();
                String password = passwordSingUp.getText().toString();
                String confirmPassword = passwordConfirmSignUp.getText().toString();

                if(name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    if(password.equals(confirmPassword)){
                        boolean checkUserEmail = myDB.checkEmail(email);
                        if(!checkUserEmail){
                            boolean insert = myDB.registerUser(name, email, password);
                            if(insert){
                                Toast.makeText(SignUpActivity.this, "User Register Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignUpActivity.this, "Register Error", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignUpActivity.this, "User already exists. Please login", Toast.LENGTH_SHORT).show();
                        }
                    } else{
                        Toast.makeText(SignUpActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}