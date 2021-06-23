package com.example.musicstream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class FavouritesActivity extends AppCompatActivity {

    RecyclerView avList;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        avList = findViewById(R.id.recycler_view);
        FavouritesAdapter favouritesAdapter = new FavouritesAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        avList.setLayoutManager(linearLayoutManager);
        avList.setAdapter(favouritesAdapter);
        sharedPreferences = getSharedPreferences("Favourite", MODE_PRIVATE);
        String album = sharedPreferences.getString("list", "");
        if (!album.equals("")) {
            TypeToken<ArrayList<Song>> token = new TypeToken<ArrayList<Song>>() {
            };
            Gson gson = new Gson();
            favlist = gson.fromJson(album, token.getType());
        }



    }

    SongCollection songCollection = new SongCollection();
    ArrayList<Song> favlist = new ArrayList<Song>();


    public void Favourite(View view) {
        String songId = view.getContentDescription().toString();
        Song song = songCollection.SearchSongById(songId);
        Gson gson = new Gson();
        String json = gson.toJson(favlist);
        Log.d("gson",json);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("list",json);
        editor.apply();




    }









    }












