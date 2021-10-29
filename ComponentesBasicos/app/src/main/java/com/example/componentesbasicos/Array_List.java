package com.example.componentesbasicos;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Array_List extends AppCompatActivity {

    private static final String TAG = "Array_List";
    ArrayList<String> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);

        people = new ArrayList<>();

        people.add("João");
        people.add("Maria");
        people.add("José");

        for (int i = 0; i < people.size(); i++) {
            Log.d(TAG, "onCreate: Name: " +people.get(i));
        }

        TextView txtView = (TextView) findViewById(R.id.array_list_txtView);
        txtView.setText(people.get(0));
    }
}