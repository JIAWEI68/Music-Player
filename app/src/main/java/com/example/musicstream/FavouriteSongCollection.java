package com.example.musicstream;

public class FavouriteSongCollection {

        Song[]favouriteSongs=new Song[12];
        public void setFavouriteSongs(Song[]favouriteSongs){
            this.favouriteSongs = favouriteSongs;
        }
        public Song[] getFavouriteSongs(){
            return this.favouriteSongs;

        }
    }


