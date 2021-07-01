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

public class PlayingActivity extends AppCompatActivity {
    private String title = "";
    private String artiste = "";
    private String fileLink = "";
    public int drawable;
    private int currentIndex = -1;

    private MediaPlayer player = new MediaPlayer();
    private Button btnPlayPause = null;
    public final SongCollection songCollection = new SongCollection();
    SeekBar seekBar;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        btnPlayPause = findViewById(R.id.playButton);
        Bundle songData = this.getIntent().getExtras();
        currentIndex = songData.getInt("index");
        Log.d("temasek", "Retrieved position is: " + currentIndex);
        displaySongBasedOnIndex(currentIndex);
        playSong(fileLink);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

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

    }
    Runnable bar = new Runnable() {
        @Override
        public void run() {
            if (player != null&&player.isPlaying()){
        seekBar.setProgress(player.getCurrentPosition());

        }
            handler.postDelayed(this,1000);}
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
                btnPlayPause.setText("PLAY");
            } else {
                player.start();
                handler.removeCallbacks(bar);
                handler.postDelayed(bar,1000);
                seekBar.setMax(player.getDuration());
                btnPlayPause.setText("PAUSE");
            }
        }
    



    public void playNext(View view) {
        currentIndex = songCollection.getNextSong(currentIndex);
        Toast.makeText(this, "After clicking playNext,\nthe current index of this song\n" +
                "in the SongCollection array is now : " + currentIndex, Toast.LENGTH_SHORT).show();
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
            btnPlayPause.setText("PAUSE");
            setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();}
        }
        private void gracefullyStopsWhenMusicEnds(){
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    Toast.makeText(getBaseContext(), "The song had ended and the onCompleteListener is activated\n" + "The button text is changed to 'PLAY'",
                            Toast.LENGTH_SHORT).show();
                    btnPlayPause.setText("PLAY");
                }
            });
        }
        @Override
        public void onBackPressed(){
        super.onBackPressed();
            player.release();

        }

}


