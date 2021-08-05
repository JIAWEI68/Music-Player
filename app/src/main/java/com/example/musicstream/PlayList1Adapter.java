package com.example.musicstream;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayList1Adapter extends RecyclerView.Adapter<PlayList1Adapter.ViewHolder>{
    private Activity activity;
    private Song[] songs;
    @RequiresApi(api = Build.VERSION_CODES.N)
    public PlayList1Adapter(Activity activity){
        this.activity = activity;
        PlayList1SongCollection songCollection = new PlayList1SongCollection();
        songs = songCollection.getSongs();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public PlayList1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist1_item, parent, false);
        return new PlayList1Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayList1Adapter.ViewHolder holder, int position) {
        Song song = songs[position];
        holder.titleText.setText(song.getTitle());
        holder.artisteText.setText(song.getArtist());
        holder.coverImage.setImageDrawable(activity.getDrawable(song.getDrawable())
        );
        holder.coverImage.setOnClickListener(v -> {
                    Intent intent = new Intent(activity, PlayList1PlayingActivity.class);
                    intent.putExtra("index", position);
                    activity.startActivity(intent);
                }
        );
        holder.titleText.setOnClickListener(v -> {
                    Intent intent = new Intent(activity, PlayList1PlayingActivity.class);
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