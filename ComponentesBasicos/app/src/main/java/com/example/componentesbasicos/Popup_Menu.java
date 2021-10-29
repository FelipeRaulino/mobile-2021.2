package com.example.componentesbasicos;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class Popup_Menu extends AppCompatActivity {
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_menu);

    button1 = (Button) findViewById(R.id.button1);

    button1.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            PopupMenu popup = new PopupMenu(Popup_Menu.this, button1);

            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(
                            Popup_Menu.this,
                            "You Clicked : " + item.getTitle(),
                            Toast.LENGTH_SHORT
                    ).show();
                    return true;
                }
            });
            popup.show();
        }
    });

    }
}
