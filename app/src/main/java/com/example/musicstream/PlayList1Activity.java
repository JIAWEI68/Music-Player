package com.example.musicstream;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class PlayList1Activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list1);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        PlayList1Adapter playList1Adapter = new PlayList1Adapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(playList1Adapter);
        getSupportActionBar().hide();
    }
    public void goBack(View view) {
        Intent intent = new Intent(PlayList1Activity.this, PlaylistsActivity.class);
        startActivity(intent);
    }
}