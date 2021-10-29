package com.example.componentesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Radio_Button extends AppCompatActivity {

    Button button;
    RadioButton genderRadioButton;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_button);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    public void onClickButtonMethod(View v){
        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderRadioButton = (RadioButton) findViewById(selectedId);

        if (selectedId == -1){
            Toast.makeText(Radio_Button.this,"Nothing selected", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(Radio_Button.this,genderRadioButton.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
