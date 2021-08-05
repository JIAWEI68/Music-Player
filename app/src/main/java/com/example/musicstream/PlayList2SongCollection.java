package com.example.musicstream;

public class PlayList2SongCollection {
    private static Song getCurrentSong;
    public Song[] songs = new Song[3];
    private int currentIndex;
    public PlayList2SongCollection(){
        Song FunkyGalileo = new Song("S1001",
                "Funky Galileo",
                "Sure Sure",
                "https://p.scdn.co/mp3-preview/cad27609508d21777b74207affa78e0f52a07e64?cid=2afe87a64b0042dabf51f37318616965",
                4.1,
                R.drawable.funcky_galileo_cover);
        Song StayNextToMe = new Song("S1002",
                "Stay Next To Me",
                "Quin XCII",
                "https://p.scdn.co/mp3-preview/aa02bddcbc9614fe746b8de6ba685d1b0371018a?cid=2afe87a64b0042dabf51f37318616965",
                3.43,
                R.drawable.stay_next_to_me_cover);
        Song insecurity = new Song("S1003",
                "my insecurities, not yours",
                "slchld",
                "https://p.scdn.co/mp3-preview/9543c449d92a8fd168586a036f29daf806180a52?cid=2afe87a64b0042dabf51f37318616965",
                4.04,
                R.drawable.my_insecurties_cover);
        songs[0]=FunkyGalileo;
        songs[1]=StayNextToMe;
        songs[2]=insecurity;
    }
    public Song[] getSongs(){
        return songs;
    }

    public Song getCurrentSong(int currentSongId) {
        return songs[currentSongId];
    }

    public int searchSongById(String id) {
        for (int index = 0; index < songs.length; index++) {
            Song tempSong = songs[index];
            if (tempSong.getId().equals(id)) {
                return index;
            }
        }
        return -1;
    }

    public int getNextSong(int currentSongIndex) {
        if (currentSongIndex >= songs.length - 1) {
            return currentSongIndex;
        } else {
            return currentSongIndex + 1;
        }
    }

    public int getPrevSong(int currentSongIndex) {
        if (currentSongIndex <= 0) {
            return currentSongIndex;
        } else {
            return currentSongIndex - 1;
        }

    }
    public Song SearchSongById(String id){
        byte index = 0;
        Song tempSong = songs[index];
        if (tempSong.getId().equals(id)){
            return tempSong;
        }
        return null;
    }
}
