package com.example.musicstream;

import androidx.appcompat.app.AppCompatActivity;

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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayList3PlayingActivity extends AppCompatActivity {
    private String title = "";
    private String artiste = "";
    private String fileLink = "";
    public int drawable;
    private int currentIndex = -1;

    private MediaPlayer player = new MediaPlayer();
    private Button btnPlayPause = null;
    public PlayList3SongCollection songCollection = new PlayList3SongCollection();
    SeekBar seekBar;
    Handler handler = new Handler();
    boolean repeatFlag = false;
    boolean shuffleFlag = false;
    Button shuffleBtn;
    Button loopBtn;
    TextView barDuration;
    PlayList3SongCollection originalSongCollection = new  PlayList3SongCollection();
    List<Song> shuffleList = Arrays.asList(songCollection.songs);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list3_playing);
        btnPlayPause = findViewById(R.id.playButton);
        Bundle songData = this.getIntent().getExtras();
        currentIndex = songData.getInt("index");
        Log.d("temasek", "Retrieved position is: " + currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
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
        currentIndex = songCollection.getPrevSong(currentIndex);
        Toast.makeText(this, "After clicking playPrevious,\nthe current index of this song\n" +
                "in the SongCollection array is now:" + currentIndex, Toast.LENGTH_SHORT).show();
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
        currentIndex = songCollection.getNextSong(currentIndex);
        Log.d("temasek","After playNext, the index is now :" + currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
    }

    public void displaySongBasedOnIndex(int selectedIndex) {
        Song song = songCollection.getCurrentSong(selectedIndex);
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

    public void shuffle(View view) {
        if (shuffleFlag){
            shuffleBtn.setBackgroundResource(R.drawable.shuffle_off);
            songCollection = new PlayList3SongCollection();
        }
        else{
            shuffleBtn.setBackgroundResource(R.drawable.shuffle_on);
            Collections.shuffle(shuffleList);
            for (int i = 0; i < shuffleList.size(); i ++){
                Log.d("shuffle", shuffleList.get(i).getTitle());
                shuffleList.toArray(songCollection.songs);
            }
        }
        shuffleFlag=!shuffleFlag;
    }

    public void Loop(View view) {
        if (repeatFlag){
            loopBtn.setBackgroundResource(R.drawable.repeat_off);
            songCollection = new PlayList3SongCollection();
        }
        else{
            loopBtn.setBackgroundResource(R.drawable.repeat_on);
        }
        repeatFlag = !repeatFlag;
    }
}