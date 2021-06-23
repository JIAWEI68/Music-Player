package com.example.musicstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Object view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void SongList(View view) {
        Intent intent = new Intent(MainActivity.this, SongsActivity.class);
        startActivity(intent);
    }

    public void FavouritePage(View view) {
        Intent intent = new Intent(MainActivity.this, FavouritesActivity.class);
        startActivity(intent);
    }

}



