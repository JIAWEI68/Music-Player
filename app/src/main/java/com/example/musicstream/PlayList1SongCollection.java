package com.example.musicstream;

public class PlayList1SongCollection {
    private static Song getCurrentSong;
    public Song[] songs = new Song[7];
    private int currentIndex;
    public PlayList1SongCollection(){
        Song queenBee = new Song("S1001",
                "火炎",
                "QUEEN BEE",
                "https://p.scdn.co/mp3-preview/5de3de9cf71a2d6ecbe6a569e63be4399f82ba09?cid=2afe87a64b0042dabf51f37318616965",
                3.6,
                R.drawable.queen_bee);
        Song summerTime = new Song("S1002",
                "하계",
                "Maggie",
                "https://p.scdn.co/mp3-preview/8ddc6685b18c4728f3a6c4e461b9d5b9d751ce9f?cid=2afe87a64b0042dabf51f37318616965",
                2.57,
                R.drawable.summertime_cover);
        Song suspect = new Song("S1003",
                "Suspect",
                "hololive IDOL PROJECT",
                "https://p.scdn.co/mp3-preview/c0329d886247aea33a6d825de6a7fea6e60aa6af?cid=2afe87a64b0042dabf51f37318616965",
                4.47,
                R.drawable.suspect_cover);
        Song stopSaying = new Song("S1004",
                "Stop Sayin'",
                "Noah Raquel",
                "https://p.scdn.co/mp3-preview/ff8178941ef2db0ee18b89279538f55015129e05?cid=2afe87a64b0042dabf51f37318616965",
                2.87,
                R.drawable.stop_saying);
        Song constant = new Song("S1005",
                "Constant (feat Jeremy Passion)",
                "Jesse Barrera",
                "https://p.scdn.co/mp3-preview/cd80c8d288fcbb07248afa2ba924f607e3faa841?cid=2afe87a64b0042dabf51f37318616965",
                3.17,
                R.drawable.constant);
        Song storySeeker = new Song("S1006",
                "STORYSEEKER",
                "STEREO DIVE FOUNDATION",
                "https://p.scdn.co/mp3-preview/313a5bb4d00e4024e071ad3e2118bc529720ffb7?cid=2afe87a64b0042dabf51f37318616965",
                3.93,
                R.drawable.story_seeker);
        Song tpain = new Song("S1007",
                "T-Pain Mashup",
                "T-Pain",
                "https://p.scdn.co/mp3-preview/54865f9c0e1ede562c2a2166539c8217f5f01f01?cid=2afe87a64b0042dabf51f37318616965",
                3.08,
                R.drawable.t_pain);
        songs[0]=queenBee;
        songs[1]=summerTime;
        songs[2]=suspect;
        songs[3]=stopSaying;
        songs[4]=constant;
        songs[5]=storySeeker;
        songs[6]=tpain;
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
