package com.example.musicstream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        setContentView(R.layout.activity_songs);
        avList = findViewById(R.id.recycler_view);
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
    }



    public void Favourite(View view) {
        String songId = view.getContentDescription().toString();
        Song song = songCollection.SearchSongById(songId);
        Gson gson = new Gson();
        String json = gson.toJson(favList);
        Log.d("gson",json);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("list",json);
        editor.apply();



    }









    }












