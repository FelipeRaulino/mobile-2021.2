package com.example.componentesbasicos;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Som extends AppCompatActivity {

    MediaPlayer mySound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_som);

        mySound = MediaPlayer.create(this, R.raw.campainha);
    }

    public void tocarCampainha(View view) {
        mySound.start();
    }
}