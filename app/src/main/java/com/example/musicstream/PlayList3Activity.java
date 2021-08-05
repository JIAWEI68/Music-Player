package com.example.musicstream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlayList3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list3);
        RecyclerView recyclerView = findViewById(R.id.recyler_view);
        PlayList3Adapter playList3Adapter = new PlayList3Adapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(playList3Adapter);
        getSupportActionBar().hide();
    }

    public void goBack(View view) {
        Intent intent = new Intent(PlayList3Activity.this, PlaylistsActivity.class);
        startActivity(intent);
    }
}