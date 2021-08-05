package com.example.musicstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    private Object Color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
    }
    public void SongList(View view) {
        Intent intent = new Intent(HomeActivity.this, SongsActivity.class);
        startActivity(intent);
    }

    public void FavouritePage(View view) {
        Intent intent = new Intent(HomeActivity.this, FavouritesActivity.class);
        startActivity(intent);
    }

    public void goToPlayList(View view) {
        Intent intent = new Intent(HomeActivity.this,PlaylistsActivity.class);
        startActivity(intent);
    }
}