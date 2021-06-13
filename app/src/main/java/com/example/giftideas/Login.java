package com.example.giftideas;

import androidx.appcompat.app.AppCompatActivity;

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

public class Login extends AppCompatActivity {
    String loginType = new String();
    static String userName = new String();

    public static class Account {
        private String password;
        private String name;
        public String getName() {
            return name;
        }
        public String getPassword() {
            return password;
        }
        Account(String username, String password)
        {
            this.name = username;
            this.password = password;
        }
    }

    public static List<Account> signInDetails = new ArrayList<Account>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signInDetails.add(new Account("admin","admin"));
        Button singUpButton = (Button) findViewById(R.id.signUpButton);
        singUpButton.setOnClickListener(new View.OnClickListener() {
             public void onClick(View view) {
                 startActivity(new Intent(Login.this, Signup.class));
            }
        });

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Boolean loginSuccess = false;

                //Get user type username/email
                EditText userNameEditText = findViewById(R.id.editTextLoginID);
                String userName = userNameEditText.getText().toString();
                //Get user type password
                EditText passwordEditText = findViewById(R.id.editTextLoginPassword);
                String password = passwordEditText.getText().toString();
                //Create account from credentials
                Account checkAccountExistence = new Account(userName,password);
                //Check if email address exists in database
                for (Account searchAccount : signInDetails)
                {
                    if (searchAccount.getName().equals(userName))
                    {
                        System.out.println("This is current Account's username: "+ searchAccount.getName().toString());
                        //If email exists, check if password matches
                        if (searchAccount.getPassword().equals(password))
                        {
                            System.out.println("This is current Account's password: "+ searchAccount.getPassword().toString());
                            //make loginSuccess true to let user login
                            loginSuccess = true;
                            userName = searchAccount.getName();
                            break;
                        }
                    }
                }


                TextView errorTextView = findViewById(R.id.loginPageErrorTextview);
                if(loginSuccess)
                {
                    startActivity(new Intent(Login.this, Profile.class));
                }
                else
                {
                    errorTextView.setText("Wrong login Credentials");
                }
            }
        });
    }
}