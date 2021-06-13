package com.example.giftideas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);

        //Back Button
        android.widget.Button singUpButton = (Button) findViewById(R.id.backProfileInfoButton);


        singUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                startActivity(new Intent(ProfileInfo.this, Profile.class));

            }
        });


    }
}