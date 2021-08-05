package com.example.musicstream;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayList2Adapter extends RecyclerView.Adapter<PlayList2Adapter.ViewHolder> {
    private Activity activity;
    private Song[] songs;
    public PlayList2Adapter(Activity activity){
        this.activity = activity;
        PlayList2SongCollection songCollection = new PlayList2SongCollection();
        songs = songCollection.getSongs();
    }

    @NonNull
    @Override
    public PlayList2Adapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist2_item, parent, false);
        return new PlayList2Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayList2Adapter.ViewHolder holder, int position) {
        Song song = songs[position];
        holder.titleText.setText(song.getTitle());
        holder.artisteText.setText(song.getArtist());
        holder.coverImage.setImageDrawable(activity.getDrawable(song.getDrawable())
        );
        holder.coverImage.setOnClickListener(v -> {
                    Intent intent = new Intent(activity, PlayList2PlayingActivity.class);
                    intent.putExtra("index", position);
                    activity.startActivity(intent);
                }
        );
        holder.titleText.setOnClickListener(v -> {
                    Intent intent = new Intent(activity, PlayList2PlayingActivity.class);
                    intent.putExtra("index", position);
                    activity.startActivity(intent);
                }
        );
    }

    @Override
    public int getItemCount() { return songs.length; }
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
