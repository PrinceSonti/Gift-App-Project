package com.example.giftideas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //sign up Button
        android.widget.Button singUpButton = (Button) findViewById(R.id.backProfileButton2);


        singUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                startActivity(new Intent(Profile.this, Login.class));


                TextView userNameTextView = findViewById(R.id.userNameTextView);
                userNameTextView.setText(Login.userName);



            }
        });

        //Back Button
        Button backButton = (Button) findViewById(R.id.backProfileButton2);


        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                startActivity(new Intent(Profile.this, Login.class));


            }
        });



        //Search Button
        Button searchButton = (Button) findViewById(R.id.searhGiftButton);


        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                startActivity(new Intent(Profile.this, SearchPage.class));


            }
        });


        //Profile info Button
        Button profileInfo = (Button) findViewById(R.id.profileButton);


        profileInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                startActivity(new Intent(Profile.this, ProfileInfo.class));


            }
        });


        //watch list Button
        Button watchList = (Button) findViewById(R.id.watchListButton);


        watchList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                startActivity(new Intent(Profile.this, watch_list.class));


            }
        });



    }
}