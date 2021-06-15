package com.example.musicstream;

public class SongCollection {

    private static Song getCurrentSong;
    private Song songs[] = new Song[9];
    private int currentIndex;

    public SongCollection() {
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
        songs[0] = Scargazer;
        songs[1] = 白日;
        songs[2] = Photograph;
        songs[3] =FunkyGalileo;
        songs[4] = HeartBreakAnniversary;
        songs[5]= AtMyWorst;
        songs[6]= Smile;
        songs[7]= Gurenge;
        songs[8] = BetterWithYou;
    }

    public Song[] getSongs(){
        return songs;
    }

    public Song getCurrentSong(int currentSongId) {
        return songs[currentSongId];
    }

    public int SearchSongById(String id) {
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
}



