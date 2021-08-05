package com.example.musicstream;

public class PlayList3SongCollection {
    private static Song getCurrentSong;
    public Song[] songs = new Song[11];
    private int currentIndex;
    public PlayList3SongCollection(){
        Song 白日 = new Song("S1001",
                "白日",
                "King Gnu",
                "https://p.scdn.co/mp3-preview/1ff5453c09e7c2f9f80d0773e293da466fbb9398?cid=2afe87a64b0042dabf51f37318616965",
                4.61,
                R.drawable.king_gnu_cover);
        Song Photograph = new Song("S1002",
                "Photograph",
                "Ed Sheeran",
                "https://p.scdn.co/mp3-preview/097c7b735ceb410943cbd507a6e1dfda272fd8a8?cid=2afe87a64b0042dabf51f37318616965",
                4.32,
                R.drawable.photograph);
        Song DreamyNight = new Song("S1003",
                "dreamy night",
                "Us The Duo",
                "https://p.scdn.co/mp3-preview/8084a68dfddbc0fa9fac02c88c822cf9f6768500?cid=2afe87a64b0042dabf51f37318616965",
                3.89,
                R.drawable.dreamy_night_cover);
        Song StayNextToMe = new Song("S1004",
                "Stay Next To Me",
                "Quin XCII",
                "https://p.scdn.co/mp3-preview/aa02bddcbc9614fe746b8de6ba685d1b0371018a?cid=2afe87a64b0042dabf51f37318616965",
                3.43,
                R.drawable.stay_next_to_me_cover);
        Song yea = new Song("S1005",
                "YEA",
                "RITCHRD",
                "https://p.scdn.co/mp3-preview/e6f4e9e762f4141b63c44eb7a11fed21878fe1bc?cid=2afe87a64b0042dabf51f37318616965)",
                1.18,
                R.drawable.yea_cover);
        Song insecurity = new Song("S1006",
                "my insecurities, not yours",
                "slchld",
                "https://p.scdn.co/mp3-preview/9543c449d92a8fd168586a036f29daf806180a52?cid=2afe87a64b0042dabf51f37318616965",
                4.04,
                R.drawable.my_insecurties_cover);
        Song oneDay = new Song("S1007",
                "One Day",
                "Matisyahu",
                "https://p.scdn.co/mp3-preview/7ef22a7d6a93d8a3aa54262f8fc3e32157e0eada?cid=2afe87a64b0042dabf51f37318616965",
                3.46,
                R.drawable.one_day_cover);
        Song redBone = new Song("S1008",
                "RedBone",
                "Childish Gambino",
                "https://p.scdn.co/mp3-preview/0167089f98ed9b52156232cc17294c7676a88dd4?cid=2afe87a64b0042dabf51f37318616965",
                5.45,
                R.drawable.redbone_cover);
        Song everlastingSummer = new Song("S1009",
                "Everlasting Summer",
                "Hikaru Station",
                "https://p.scdn.co/mp3-preview/3473e43f252176228a75020d3c672fae3c195892?cid=2afe87a64b0042dabf51f37318616965",
                4.37,
                R.drawable.everlastin_summer);
        Song drunkMe = new Song("S1010",
                "Drunk Me",
                "Davin Kingston",
                "https://p.scdn.co/mp3-preview/dde251dddb5a373fa221d981715b1f06de1f0513?cid=2afe87a64b0042dabf51f37318616965",
                3.15,
                R.drawable.drunk_me);
        Song parachute = new Song("S1011",
                "parachute",
                "John K",
                "https://p.scdn.co/mp3-preview/8d68c12502ca5454361d93e8b9136d6564842cfb?cid=2afe87a64b0042dabf51f37318616965",
                2.61,
                R.drawable.parachute_cover);
        songs[0]= 白日;
        songs[1]= Photograph;
        songs[2]=DreamyNight;
        songs[3]=StayNextToMe;
        songs[4]=yea;
        songs[5]=insecurity;
        songs[6]=oneDay;
        songs[7]=redBone;
        songs[8]=everlastingSummer;
        songs[9]=drunkMe;
        songs[10]=parachute;
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
