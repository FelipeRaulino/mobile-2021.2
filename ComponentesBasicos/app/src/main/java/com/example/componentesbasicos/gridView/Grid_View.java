package com.example.componentesbasicos.gridView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.componentesbasicos.R;
import com.example.componentesbasicos.databinding.ActivityGridViewBinding;

public class Grid_View extends AppCompatActivity {

    ActivityGridViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGridViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] franchiseName = {"Lakers", "Warriors", "Nets", "Bucks"};
        int[] franchiseImages = { R.drawable.lakers, R.drawable.warriors, R.drawable.nets, R.drawable.bucks};


        GridAdapter gridAdapter = new GridAdapter(Grid_View.this, franchiseName, franchiseImages);
        binding.gridView.setAdapter(gridAdapter);

        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Grid_View.this, "You clicked on: "+franchiseName[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

}
