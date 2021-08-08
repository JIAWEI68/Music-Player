package com.example.musicstream;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {
    ArrayList<Song> FavList = new ArrayList<Song>();
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        RecyclerView recyclerView = findViewById(R.id.Recycler_view);
        SongsAdapter songsAdapter = new SongsAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(songsAdapter);
        setTitle("SongList");
        getSupportActionBar().hide();
    }


    public void goBack(View view) {
        Intent intent = new Intent(SongsActivity.this,HomeActivity.class);
        startActivity(intent);
    }
    public void goToHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void goToSearch(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}

