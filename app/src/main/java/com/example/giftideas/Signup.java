package com.example.giftideas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        

        //When sign up is clicked
        Button button = (Button) findViewById(R.id.cretateAccountButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText firstNameEditText = findViewById(R.id.firstNameEditText);
                String firstName = firstNameEditText.getText().toString();
                EditText lastNameEditText = findViewById(R.id.lastNameEditText);
                String lastName = lastNameEditText.getText().toString();
                @SuppressLint("WrongViewCast") String userName =  firstName+ lastName;
                EditText  passwordEditText = findViewById(R.id.passwordSignUpEditText);
                String password = passwordEditText.getText().toString();
                Login.Account newAccount = new Login.Account(userName,password);
                Login.signInDetails.add(newAccount);
                TextView successText = findViewById(R.id.signUpErrorTextView);
                successText.setText("Account Created for :"+userName);
            }
        });

        //Back Button
        Button backButton = (Button) findViewById(R.id.backSignUpButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(Signup.this, Login.class));
            }
        });
}
}