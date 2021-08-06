package com.example.musicstream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class FavouritesActivity extends AppCompatActivity {

    RecyclerView avList;
    SharedPreferences sharedPreferences;
    ArrayList<Song> favList = new ArrayList<Song>();
    SongCollection songCollection = new SongCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("temasek", "IN HERE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourties);
        avList = findViewById(R.id.favRecyclerView);
        sharedPreferences = getSharedPreferences("FavouriteSongs", MODE_PRIVATE);
        String listOfFavouriteSongs = sharedPreferences.getString("list", "");
        if (!listOfFavouriteSongs.equals("")) {
            TypeToken<ArrayList<Song>> token = new TypeToken<ArrayList<Song>>() {
            };
            Gson gson = new Gson();
            favList = gson.fromJson(listOfFavouriteSongs, token.getType());
            for (Song song1 : favList) {
                Log.d("temasek", "Song Name :" + song1.getTitle());
            }
        }
        FavouritesAdapter favouritesAdapter = new FavouritesAdapter(this, favList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        avList.setLayoutManager(linearLayoutManager);
        avList.setAdapter(favouritesAdapter);
        getSupportActionBar().hide();
    }
    public void goBack(View view) {
        Intent intent = new Intent(FavouritesActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    public void goToHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }


}












