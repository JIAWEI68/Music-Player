package com.example.musicstream;

import java.util.Collection;

public class SongCollection {
    private static Song getCurrentSong;
    public Song songs[] = new Song[16];
    private int currentIndex;

    public SongCollection(){
        Song Scargazer = new Song("S1001",
            "Scargazer",
            "Prompto",
            "https://p.scdn.co/mp3-preview/4d368f85ea9df59a9aa321241b1b3986017af8b3?cid=2afe87a64b0042dabf51f37318616965",
            2.4,
            R.drawable.scargazer_cover);
        Song 白日 = new Song("S1002",
                "白日",
                "King Gnu",
                "https://p.scdn.co/mp3-preview/1ff5453c09e7c2f9f80d0773e293da466fbb9398?cid=2afe87a64b0042dabf51f37318616965",
                4.61,
                R.drawable.king_gnu_cover);
        Song Photograph = new Song("S1003",
                "Photograph",
                "Ed Sheeran",
                "https://p.scdn.co/mp3-preview/097c7b735ceb410943cbd507a6e1dfda272fd8a8?cid=2afe87a64b0042dabf51f37318616965",
                4.32,
                R.drawable.photograph);
        Song FunkyGalileo = new Song("S1004",
                "Funky Galileo",
                "Sure Sure",
                "https://p.scdn.co/mp3-preview/cad27609508d21777b74207affa78e0f52a07e64?cid=2afe87a64b0042dabf51f37318616965",
                4.1,
                R.drawable.funcky_galileo_cover);
        Song HeartBreakAnniversary = new Song("S1005",
                "Heart Break Anniversary",
                "Giveon",
                "https://p.scdn.co/mp3-preview/680c39287fb49fdcb9e6690a1419a97fe67d8420?cid=2afe87a64b0042dabf51f37318616965",
                3.31,
                R.drawable.heart_break_anniversary_cover);
        Song AtMyWorst = new Song("S1006",
                "At My Worst(feat Kehlani)",
                "PINK SWEAT$",
                "https://p.scdn.co/mp3-preview/ecf02a806bbdb610caa3695f38a7154897eeb7d4?cid=2afe87a64b0042dabf51f37318616965",
                2.82,
                R.drawable.at_my_worst_cover);
        Song Smile = new Song("S1007",
                "Smile",
                "Johnny Stimson",
                "https://p.scdn.co/mp3-preview/60395eb96b9ab9eecc8873917d659e57d8d07315?cid=2afe87a64b0042dabf51f37318616965",
                2.71,
                R.drawable.smile_cover);
        Song Gurenge = new Song("S1008",
                "Gurenge",
                "LiSA",
                "https://p.scdn.co/mp3-preview/57da7629db12384bd4205854aeddc34668261a36?cid=2afe87a64b0042dabf51f37318616965",
                3.98,
                R.drawable.gurenge_cover);
        Song BetterWithYou = new Song("S1009",
                "Better with You",
                "Gentle Bones",
                "https://p.scdn.co/mp3-preview/7babdc7a71c3e758e4e8421f1212d549921ca9e6?cid=2afe87a64b0042dabf51f37318616965",
                2.77,
                R.drawable.better_with_you_cover);
        Song Wicked = new Song("S1010",
                "Wicked",
                "Benjamin Kheng",
                "https://p.scdn.co/mp3-preview/ed6d34be8cf892a34c1c161b8f524adac8047ee2?cid=2afe87a64b0042dabf51f37318616965",
                3.16,
                R.drawable.wicked_cover);
        Song JustForYou = new Song("S1011",
                "Just For You",
                "Lil Pitchy",
                "https://p.scdn.co/mp3-preview/b945d5274d01c2177ea6012e2136d3446e5b4603?cid=2afe87a64b0042dabf51f37318616965",
                3.19,
                R.drawable.just_for_you_cover);
        Song DreamyNight = new Song("S1012",
                "dreamy night",
                "Us The Duo",
                "https://p.scdn.co/mp3-preview/8084a68dfddbc0fa9fac02c88c822cf9f6768500?cid=2afe87a64b0042dabf51f37318616965",
                3.89,
                R.drawable.dreamy_night_cover);
        Song StayNextToMe = new Song("S1013",
                "Stay Next To Me",
                "Quin XCII",
                "https://p.scdn.co/mp3-preview/aa02bddcbc9614fe746b8de6ba685d1b0371018a?cid=2afe87a64b0042dabf51f37318616965",
                3.43,
                R.drawable.stay_next_to_me_cover);
        Song yea = new Song("S1014",
                "YEA",
                "RITCHRD",
                "https://p.scdn.co/mp3-preview/e6f4e9e762f4141b63c44eb7a11fed21878fe1bc?cid=2afe87a64b0042dabf51f37318616965)",
                1.18,
                R.drawable.yea_cover);
        Song insecurity = new Song("S1015",
                "my insecurities, not yours",
                "slchld",
                "https://p.scdn.co/mp3-preview/9543c449d92a8fd168586a036f29daf806180a52?cid=2afe87a64b0042dabf51f37318616965",
                4.04,
                R.drawable.my_insecurties_cover);
        Song oneDay = new Song("S1016",
                "One Day",
                "Matisyahu",
                "https://p.scdn.co/mp3-preview/7ef22a7d6a93d8a3aa54262f8fc3e32157e0eada?cid=2afe87a64b0042dabf51f37318616965",
                3.46,
                R.drawable.one_day_cover);
        songs[0]= Scargazer;
        songs[1]= 白日;
        songs[2]= Photograph;
        songs[3]=FunkyGalileo;
        songs[4]= HeartBreakAnniversary;
        songs[5]= AtMyWorst;
        songs[6]= Smile;
        songs[7]= Gurenge;
        songs[8]= BetterWithYou;
        songs[9]= Wicked;
        songs[10]=JustForYou;
        songs[11]=DreamyNight;
        songs[12]=StayNextToMe;
        songs[13]=yea;
        songs[14]=insecurity;
        songs[15]=oneDay;
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
        return tempSong;
    }
}



