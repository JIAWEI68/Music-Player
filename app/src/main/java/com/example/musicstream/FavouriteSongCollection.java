package com.example.musicstream;

import android.content.SharedPreferences;
import android.view.Display;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FavouriteSongCollection {


    ArrayList<Song> FavouriteSongs =new ArrayList<Song>();

    public static int getNextSong(int currentIndex) {
        return 0;
    }

    public static int getPrevSong(int currentIndex) {
        return 0;
    }

    public ArrayList setFavouriteSongs(ArrayList<Song> FavouriteSongs){
            this.FavouriteSongs = FavouriteSongs;
            return this.getFavouriteSongs();
        }
        public ArrayList getFavouriteSongs(){
        return this.FavouriteSongs;

        }
    public int getFavouriteSong(){
        return FavouriteSongs.indexOf(FavouriteSongs);

    }
}


