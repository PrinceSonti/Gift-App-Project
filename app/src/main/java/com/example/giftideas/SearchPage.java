package com.example.giftideas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class SearchPage extends AppCompatActivity {

    String loginType = new String();
    ArrayList<Contact> contacts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
        Button backButton = (Button) findViewById(R.id.backButtonSearchPage);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(SearchPage.this, Profile.class));
            }
        });


        Spinner spinner;
        spinner = findViewById(R.id.searchPageSpinner);
        List<String> sortByType = new ArrayList<>();
        sortByType.add(0, "Sort By");
        sortByType.add("Name");
        sortByType.add("Low to High");
        sortByType.add("High to Low");
        sortByType.add("Popularity");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sortByType);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                System.out.println("This is selected in spinner :" + parent.getItemAtPosition(position));
                loginType = parent.getItemAtPosition(position).toString();
                if (parent.getItemAtPosition(position).equals("Choose sort by from list"))
                {
                }
                else {
                    String item = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //Recycler View


        //define a  class which represents the data model being displayed by the RecyclerView:
         class Contact {
            private String mName;
            private boolean mOnline;

            public Contact(String name, boolean online) {
                mName = name;
                mOnline = online;
            }

            public String getName() {
                return mName;
            }

            public boolean isOnline() {
                return mOnline;
            }

            private int lastContactId = 0;

            public ArrayList<Contact> createContactsList(int numContacts) {
                ArrayList<Contact> contacts = new ArrayList<Contact>();

                for (int i = 1; i <= numContacts; i++) {
                    contacts.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
                }

                return contacts;
            }
        }


        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.searchPageRecylerView);

        // Initialize contacts
        contacts = com.example.giftideas.Contact.createContactsList(20);
        // Create adapter passing in the sample user data
        ContactsAdapter adapter = new ContactsAdapter(contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all!




    }
}