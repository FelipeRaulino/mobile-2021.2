package com.example.componentesbasicos;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.componentesbasicos.R;

public class Autocomplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_complete);

        String nomes[] = {"Roberto", "Tomas", "Gustavo", "Manoel",
                          "Carlos", "Emilly", "Isabelly", "Giovanna",
                          "Vinicius", "Cauã"};

        AutoCompleteTextView autocomplete = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,nomes);

        autocomplete.setThreshold(1);
        autocomplete.setAdapter(adp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.auto_complete, menu);
        return true;
    }
}
