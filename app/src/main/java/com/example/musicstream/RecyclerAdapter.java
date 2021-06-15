package com.example.musicstream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>

{
   private Activity activity;
   //context of main activity
   //extended context
   private Song[] songs;
   public RecyclerAdapter(Activity activity){
       this.activity = activity;
       SongCollection songCollection = new SongCollection();
       songs = songCollection.getSongs();
   }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
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
            Intent intent = new Intent(activity,PlaySongActivity.class);
            intent.putExtra("index", position);
            activity.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return songs.length;
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
