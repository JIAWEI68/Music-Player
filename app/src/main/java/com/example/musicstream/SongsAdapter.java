package com.example.musicstream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> implements Filterable {
    SharedPreferences sharedPreferences;

   private Activity activity;
   private Song[] songs;
   private Song[] filteredSongs;
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
        holder.coverImage.setImageDrawable(activity.getDrawable(song.getDrawable())
        );
        holder.coverImage.setOnClickListener(v -> {
            Intent intent = new Intent(activity, PlayingActivity.class);
            intent.putExtra("index", position);
            activity.startActivity(intent);
        }
        );
        holder.titleText.setOnClickListener(v -> {
        Intent intent = new Intent(activity, PlayingActivity.class);
        intent.putExtra("index", position);
        activity.startActivity(intent);
        }
        );
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
        );
    }

    @Override
    public int getItemCount() {
        return songs.length;
    }

    @Override
    public Filter getFilter() {
        return null;
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
