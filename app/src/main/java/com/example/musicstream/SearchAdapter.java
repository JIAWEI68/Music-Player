package com.example.musicstream;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> implements Filterable{
    private static ArrayList<Song> songArray;
    List<Song> songFilter;
    @NonNull
    private Activity activity;
    private Song[] songs;
    public ArrayList<Song> currentFavList = new ArrayList<>();
    private Song[] filteredSongs;
    @RequiresApi(api = Build.VERSION_CODES.N)
    public SearchAdapter(Activity activity){
        this.activity = activity;
        SearchSongCollection searchSongCollection = new SearchSongCollection();
        songs = searchSongCollection.getSongs();
        songArray = new ArrayList<Song>();
        for (int i = 0; i< songs.length; i++){
            songArray.add(songs[i]);
        }
        songFilter = songArray;

        SearchSongCollection songCollection = new SearchSongCollection();
        songs = songCollection.getSongs();
    }
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Song song = songFilter.get(position);
        holder.titleText.setText(song.getTitle());
        holder.artisteText.setText(song.getArtist());
        holder.coverImage.setImageDrawable(activity.getDrawable(song.getDrawable())
        );
    }

    @Override
    public int getItemCount(){
        if (songFilter==null){
            return 0;
        }
        else
        {
        return songFilter.size();
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()){
                    songFilter = songArray;

                }
                else {
                    List<Song> filteredList = new ArrayList<>();
                    for (int i = 0; i<songArray.size();i++){
                        if(songArray.get(i).getTitle().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(songArray.get(i));
                        }
                    }
                    songFilter = filteredList;
                    notifyDataSetChanged();
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = songFilter;
                Log.d("filter results", filterResults.values.toString());
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                songFilter = (ArrayList<Song>)results.values;
                notifyDataSetChanged();
            }
        };
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