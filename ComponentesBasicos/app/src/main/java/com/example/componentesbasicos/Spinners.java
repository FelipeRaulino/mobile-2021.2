package com.example.componentesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class Spinners extends AppCompatActivity {

    Spinner spinner;

    String franchises[] = {"Lakers", "Celtics", "Warriors", "Nets", "Knicks",
                           "Bulls", "Bucks", "Hawks", "Blazers", "Raptors"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinners);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, franchises);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        int position = spinner.getSelectedItemPosition();
                        Toast.makeText(getApplicationContext(), "You have selected: "
                        +franchises[+position],Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {

                    }
                }
        );
    }
}
