package com.example.componentesbasicos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.componentesbasicos.gridView.Grid_View;
import com.example.componentesbasicos.tabbed_activity.Tabbed_activity;
import com.google.android.material.navigation.NavigationView;

public class ToggleButton extends AppCompatActivity {

    private android.widget.ToggleButton toggleButton1, toggleButton2;
    private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_togglebutton);

        addListenerOnButton();
    }

    public void addListenerOnButton(){
        toggleButton1 = (android.widget.ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton2 = (android.widget.ToggleButton) findViewById(R.id.toggleButton2);
        btnDisplay = (Button) findViewById((R.id.btnDisplay));

        btnDisplay.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v){

                StringBuffer result = new StringBuffer();
                result.append("toggleButton1 : ").append(toggleButton1.getText());
                result.append("\ntoggleButton2 : ").append(toggleButton2.getText());

                Toast.makeText(ToggleButton.this, result.toString(),
                    Toast.LENGTH_SHORT).show();
            }
        });

        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            DrawerLayout drawerLayout;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                DrawerLayout drawerLayout;
                switch(item.getItemId()){
                    case R.id.nav_editText:
                        startActivity(new Intent(ToggleButton.this, EditClass.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_arrayList:
                        startActivity(new Intent(ToggleButton.this, Array_List.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_spinners:
                        startActivity(new Intent(ToggleButton.this, Spinners.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_radioButtons:
                        startActivity(new Intent(ToggleButton.this, Radio_Button.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_optionsMenu:
                        startActivity(new Intent(ToggleButton.this, OverflowMenu.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_popupMenu:
                        startActivity(new Intent(ToggleButton.this, Popup_Menu.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_longPress:
                        startActivity(new Intent(ToggleButton.this, Long_Press.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_backgroundImage:
                        startActivity(new Intent(ToggleButton.this, BackgroundImage.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_activitiesMultipleTabs:
                        startActivity(new Intent(ToggleButton.this, Tabbed_activity.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_listView:
                        startActivity(new Intent(ToggleButton.this, List_View.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_arrayAdapter:
                        startActivity(new Intent(ToggleButton.this, Array_Adapter.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_autoComplete:
                        startActivity(new Intent(ToggleButton.this, Autocomplete.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_gridView:
                        startActivity(new Intent(ToggleButton.this, Grid_View.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    case R.id.nav_som:
                        startActivity(new Intent(ToggleButton.this, Som.class));
                        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;

                    default:
                        return true;
                }
            }
        });
    }
}