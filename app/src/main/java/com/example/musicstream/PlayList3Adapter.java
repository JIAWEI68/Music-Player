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

public class PlayList3Adapter extends RecyclerView.Adapter<PlayList3Adapter.ViewHolder> {
    private Activity activity;
    private Song[] songs;
    public PlayList3Adapter(Activity activity){
        this.activity = activity;
        PlayList3SongCollection songCollection = new PlayList3SongCollection();
        songs = songCollection.getSongs();
    }

    @NonNull
    @Override
    public PlayList3Adapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist3_item, parent, false);
        return new PlayList3Adapter.ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull PlayList3Adapter.ViewHolder holder, int position) {
        Song song = songs[position];
        holder.titleText.setText(song.getTitle());
        holder.artisteText.setText(song.getArtist());
        holder.coverImage.setImageDrawable(activity.getDrawable(song.getDrawable())
        );
        holder.coverImage.setOnClickListener(v -> {
                    Intent intent = new Intent(activity, PlayList3PlayingActivity.class);
                    intent.putExtra("index", position);
                    activity.startActivity(intent);
                }
        );
        holder.titleText.setOnClickListener(v -> {
                    Intent intent = new Intent(activity, PlayList3PlayingActivity.class);
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