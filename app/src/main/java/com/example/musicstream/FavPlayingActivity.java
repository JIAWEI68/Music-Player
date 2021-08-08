package com.example.musicstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FavPlayingActivity extends AppCompatActivity {
    private String title = "";
    private String artiste = "";
    private String fileLink = "";
    public int drawable;
    private int currentIndex = -1;

    private MediaPlayer player = new MediaPlayer();
    private Button btnPlayPause = null;
    ArrayList<Song> favList = FavouritesActivity.favList;
    SeekBar seekBar;
    Handler handler = new Handler();
    boolean repeatFlag = false;
    boolean shuffleFlag = false;
    Button shuffleBtn;
    Button loopBtn;
    TextView barDuration;
    SearchSongCollection originalSongCollection = new SearchSongCollection();
    ArrayList<Song> constant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_playing);
        btnPlayPause = findViewById(R.id.playButton);
        Bundle songData = this.getIntent().getExtras();
        currentIndex = songData.getInt("index");
        Log.d("temasek", "Retrieved position is: " + currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
        getSupportActionBar().hide();
        seekBar = findViewById(R.id.seekBar);
        handler.removeCallbacks(bar);
        handler.postDelayed(bar,500);
        seekBar.setMax(player.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setProgress(progress);
                barDuration.setText("0:" + progress/1000);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (player != null && player.isPlaying()){
                    player.seekTo(seekBar.getProgress());
                }
            }
        });
        shuffleBtn = findViewById(R.id.shuffleBtn);
        loopBtn = findViewById(R.id.loopBtn);
        barDuration = findViewById(R.id.barDuration);
    }
    Runnable bar = new Runnable() {
        @Override
        public void run() {
            if (player!= null && player.isPlaying()){
                seekBar.setProgress(player.getCurrentPosition());
            }
            handler.postDelayed(this,500);
        }
    };

    public void playPrevious(View view) {
        if(currentIndex < favList.size() -1) {
            currentIndex += 1;
        } else {
            currentIndex = 0;
        }
        Log.d("temasek","After playPrev, the index is now :" + currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
    }
    public void pauseOrPlay (View view){
        if (player.isPlaying()) {
            player.pause();
            btnPlayPause.setBackgroundResource(R.drawable.ic_media_play_dark);
        } else {
            player.start();
            btnPlayPause.setBackgroundResource(R.drawable.ic_media_pause_dark);
        }
    }
    public void playNext(View view) {
        if(currentIndex < favList.size() -1) {
            currentIndex += 1;
        } else {
            currentIndex = 0;
        }
        Log.d("temasek","After playNext, the index is now :" + currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
    }

    public void displaySongBasedOnIndex(int selectedIndex) {
        Song song = favList.get(currentIndex);
        title = song.getTitle();
        artiste = song.getArtist();
        fileLink = song.getFileLink();
        drawable = song.getDrawable();
        TextView txtTitle = findViewById(R.id.txtSongTitle);
        txtTitle.setText(title);
        TextView txtArtiste = findViewById(R.id.txtArtiste);
        txtArtiste.setText(artiste);
        ImageView iCoverArt = findViewById(R.id.imgCoverArt);
        iCoverArt.setImageResource(drawable);
    }
    public void playSong(String songUrl) {
        try {
            player.reset();
            player.setDataSource(songUrl);
            player.prepare();
            player.start();
            gracefullyStopsWhenMusicEnds();
            btnPlayPause.setBackgroundResource(R.drawable.ic_media_pause_dark);
            setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();}
    }
    private void gracefullyStopsWhenMusicEnds(){
    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
    if(repeatFlag)
    {
     pauseOrPlay(null);
    }
     else
    {
    playNext(null);
    }
            }
            }
        );
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        player.release();
        handler.removeCallbacks(bar);
    }
    public void goBack(View view) {
        Intent intent = new Intent(FavPlayingActivity.this, FavouritesActivity.class);
        player.release();
        handler.removeCallbacks(bar);
        startActivity(intent);
    }
    public void goToHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        player.release();
        handler.removeCallbacks(bar);
        startActivity(intent);
    }
    public void goToSearch(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        player.release();
        handler.removeCallbacks(bar);
        startActivity(intent);
    }

}