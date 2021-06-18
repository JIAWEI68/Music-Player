package com.example.musicstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}
        public void SongList(View view) {
        Intent intent = new Intent(MainActivity.this, SongsActivity.class);
        startActivity(intent);
    }public void Favourite(View view){
        Intent intent = new Intent(MainActivity.this, FavouritesActivity.class);

    }




}



