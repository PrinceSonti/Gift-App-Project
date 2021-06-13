package com.example.giftideas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class watch_list extends AppCompatActivity {


    ArrayList<Row> rows;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_list);

        //Back Button
        Button backButton = (Button) findViewById(R.id.backWatchListButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(watch_list.this, Profile.class));
            }
        });


        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.recyclerView2);

        // Initialize contacts
        rows = Row.createContactsList(20);
        // Create adapter passing in the sample user data
        recyclerViewAdaptor adapter = new recyclerViewAdaptor(rows);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all!

    }


    }
