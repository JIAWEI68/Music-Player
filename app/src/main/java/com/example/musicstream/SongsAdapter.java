package com.example.musicstream;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder>

{
   private Activity activity;
   //context of main activity
   //extended context
   private Song[] songs;
   private ArrayList<Song> FavList = new ArrayList<>();
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
        holder.AddButton.setOnClickListener(v -> {
            if (FavList.contains(song)) {
                return;
            } else {
                FavList.add(song);
                for (Song song1 : FavList) {
                    Log.d("temasek", "Song Name :" + song1.getTitle());
                } }
        });


    

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
