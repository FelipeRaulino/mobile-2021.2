package com.example.componentesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Long_Press extends AppCompatActivity {
    private static final int LENGTH_LONG = 2000;
    private static final int LENGTH_SHORT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.long_press);

        TextView textView = (TextView) findViewById(R.id.textView);

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "You have pressed it long :)", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Not Long Enough :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
