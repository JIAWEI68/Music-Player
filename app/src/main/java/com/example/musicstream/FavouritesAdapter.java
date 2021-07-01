package com.example.musicstream;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FavouritesAdapter extends RecyclerView.Adapter<FavouritesAdapter.ViewHolder>

{
    SharedPreferences sharedPreferences;
    ArrayList<Song> favlist;
    private Activity activity;
    //context of main activity
    //extended context
    public FavouritesAdapter(Activity activity, ArrayList<Song> favlist){
        this.activity = activity;
        this.favlist = favlist;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = favlist.get(position);
        if(song!=null){
            holder.titleText.setText(song.getTitle());
            holder.artisteText.setText(song.getArtist());
            holder.coverImage.setImageDrawable(activity.getDrawable(song.getDrawable()));
            //get id of drawable
            //context.getDrawable file
            holder.coverImage.setOnClickListener(v -> {
                Intent intent = new Intent(activity, PlayingActivity.class);
                intent.putExtra("index", position);
                activity.startActivity(intent); });
        }
    }
    @Override
    public int getItemCount() {
        return favlist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public ImageView coverImage;
        public TextView titleText, artisteText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            coverImage = itemView.findViewById(R.id.song_cover);
            titleText = itemView.findViewById(R.id.song_title);
            artisteText = itemView.findViewById(R.id.song_artiste);

        }


    }
}