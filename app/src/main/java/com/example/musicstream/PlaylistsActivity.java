package com.example.musicstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlaylistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        getSupportActionBar().hide();
    }

    public void PlayList1(View view) {
        Intent intent = new Intent(PlaylistsActivity.this,PlayList1Activity.class);
        startActivity(intent);
    }

    public void PlayList2(View view) {
        Intent intent = new Intent(PlaylistsActivity.this,PlayList2Activity.class);
        startActivity(intent);
    }

    public void PlayList3(View view) {
        Intent intent = new Intent(PlaylistsActivity.this,PlayList3Activity.class);
        startActivity(intent);
    }
    public void goBack(View view) {
        Intent intent = new Intent(PlaylistsActivity.this,HomeActivity.class);
        startActivity(intent);
    }
    public void goToHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}