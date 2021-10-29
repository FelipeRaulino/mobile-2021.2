package com.example.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Array_Adapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);

        final ArrayList<NumbersView> arrayList = new ArrayList<NumbersView>();

        arrayList.add(new NumbersView(R.drawable.profile, "1", "One"));
        arrayList.add(new NumbersView(R.drawable.profile, "2", "Two"));
        arrayList.add(new NumbersView(R.drawable.profile, "3", "Three"));
        arrayList.add(new NumbersView(R.drawable.profile, "4", "Four"));
        arrayList.add(new NumbersView(R.drawable.profile, "5", "Five"));
        arrayList.add(new NumbersView(R.drawable.profile, "6", "Six"));
        arrayList.add(new NumbersView(R.drawable.profile, "7", "Seven"));
        arrayList.add(new NumbersView(R.drawable.profile, "8", "Eight"));
        arrayList.add(new NumbersView(R.drawable.profile, "9", "Nine"));
        arrayList.add(new NumbersView(R.drawable.profile, "10", "Ten"));
        arrayList.add(new NumbersView(R.drawable.profile, "11", "Eleven"));
        arrayList.add(new NumbersView(R.drawable.profile, "12", "Twelve"));
        arrayList.add(new NumbersView(R.drawable.profile, "13", "Thirteen"));
        arrayList.add(new NumbersView(R.drawable.profile, "14", "Fourteen"));
        arrayList.add(new NumbersView(R.drawable.profile, "15", "Fifteen"));

        NumbersViewAdapter numbersArrayAdapter = new NumbersViewAdapter(this, arrayList);
        ListView numbersListView = findViewById(R.id.listView);

        numbersListView.setAdapter(numbersArrayAdapter);
    }
}