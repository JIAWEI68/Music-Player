package com.example.musicstream;

import java.util.ArrayList;

public class FavouriteSongCollection {

        ArrayList<Song> FavouriteSongs =new ArrayList<Song>();
        public void setFavouriteSongs(ArrayList<Song> FavouriteSongs){
            this.FavouriteSongs = FavouriteSongs;
        }
        public ArrayList getFavouriteSongs(){
            return this.FavouriteSongs;

        }
    }


