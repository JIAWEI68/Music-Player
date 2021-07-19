package com.example.musicstream;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FavouritesAdapter extends RecyclerView.Adapter<FavouritesAdapter.ViewHolder>

{
    SharedPreferences sharedPreferences;
    ArrayList<Song> favList;
    private Activity activity;
    public FavouritesAdapter(Activity activity, ArrayList<Song> favList){
        this.activity = activity;
        this.favList = favList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourites_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = favList.get(position);
        if(song!=null){
            holder.titleText.setText(song.getTitle());
            holder.artisteText.setText(song.getArtist());
            holder.coverImage.setImageDrawable(activity.getDrawable(song.getDrawable())
            );
            holder.removeBtn.setOnClickListener(v -> {
                favList.remove(position);
                sharedPreferences = activity.getSharedPreferences("FavouriteSongs", Context.MODE_PRIVATE);
                String currentFavouriteSongs = sharedPreferences.getString("list", "");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("list");
                editor.apply();
                notifyDataSetChanged();
            }
            );
        }
    }
    @Override
    public int getItemCount() {
        return favList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public View removeBtn;
        public ImageView coverImage;
        public TextView titleText, artisteText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            coverImage = itemView.findViewById(R.id.song_cover);
            titleText = itemView.findViewById(R.id.song_title);
            artisteText = itemView.findViewById(R.id.song_artiste);
            removeBtn = itemView.findViewById(R.id.removeBtn);

        }


    }
}