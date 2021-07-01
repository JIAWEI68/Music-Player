package com.example.musicstream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {
    SharedPreferences sharedPreferences;



   private Activity activity;
   //context of main activity
   //extended context
   private Song[] songs;
   public ArrayList<Song> currentFavList = new ArrayList<>();
   public SongsAdapter(Activity activity){
       this.activity = activity;
       SongCollection songCollection = new SongCollection();

       songs = songCollection.getSongs();

   }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Song song = songs[position];

        holder.titleText.setText(song.getTitle());
        holder.artisteText.setText(song.getArtist());
        holder.coverImage.setImageDrawable(activity.getDrawable(song.getDrawable()));
        //get id of drawable
        //context.getDrawable file
        holder.coverImage.setOnClickListener(v -> {
            Intent intent = new Intent(activity, PlayingActivity.class);
            intent.putExtra("index", position);
            activity.startActivity(intent);
        });

        // 1) Ensure duplicate songs dont get added into the array
        // 2) Clear the json
        holder.AddButton.setOnClickListener(v -> {
            boolean hasMatch = false;
            Gson gson = new Gson();
            sharedPreferences = activity.getSharedPreferences("FavouriteSongs", Context.MODE_PRIVATE);
            String currentFavouriteSongs = sharedPreferences.getString("list", "");
            if (!currentFavouriteSongs.equals("")) {
                TypeToken<ArrayList<Song>> token = new TypeToken<ArrayList<Song>>() {};
                currentFavList = gson.fromJson(currentFavouriteSongs, token.getType());
                for (Song song1 : currentFavList) {
                    Log.d("temasek", "CURRENT Song Name :" + song1.getTitle());
                }

                for(int i = 0; i< currentFavList.size(); i++) {
                    if(i == currentFavList.size()-1 && !currentFavList.get(i).getTitle().equals(song.getTitle())) {
                        currentFavList.add(song);
                    }
                    if(currentFavList.get(i).getTitle().equals(song.getTitle())) {
                        // BREAK OUT OF FOR LOOP
                        break;
                    }
                }
            } else {
                currentFavList.add(song);
            }


            for (Song song1 : currentFavList) {
                Log.d("temasek", "Song Name :" + song1.getTitle());
            }
            String json = gson.toJson(currentFavList);
            Log.d("gson is:",json);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("list",json);
            editor.apply();
        }


                // 1) Here we have a arrayList of songs u stored in THIS PAGE.
            // 2) Now convert this arrayList to JSON using GSON LIBRARY
            // 3) Use the feature shared preferences (WATCH THE VID) to transfer the JSON DATA OUT OF THIS PAGE
        );

        // GO WATCH THE VIDEO AND HE'LL EXPLAIN TO U HOW TO USE GSON TO TRANSFER THE ARRAY OF DATA ACROSS TO OTHER PAGES IN THE APP
    

    }

    @Override
    public int getItemCount() {
        return songs.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View AddButton;
        public View itemView;
        public ImageView coverImage;
        public TextView titleText, artisteText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            coverImage = itemView.findViewById(R.id.song_cover);
            titleText = itemView.findViewById(R.id.song_title);
            artisteText = itemView.findViewById(R.id.song_artiste);
            AddButton = itemView.findViewById(R.id.AddButton);
        }


    }
}
