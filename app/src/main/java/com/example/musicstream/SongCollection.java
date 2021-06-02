package com.example.musicstream;

public class SongCollection {

    private static Song getCurrentSong;
    private Song songs[] = new Song[5];
    private int currentIndex;

    public SongCollection() {
        Song TheWayYouLookTonight = new Song("S1001",
                "The Way You Look Tonight",
                "Michael Buble",
                "https://p.scdn.co/mp3-preview/a5b8972e764025020625bbf9c1c2bbb06e394a60?cid=2afe87a64b0042dabf51f37318616965",
                4.66,
                R.drawable.michael_buble_collection);
        Song BillieJean = new Song("S1002",
                "Billie Jean",
                "Michael Jackson",
                "https://p.scdn.co/mp3-preview/f504e6b8e037771318656394f532dede4f9bcaea?cid=2afe87a64b0042dabf51f37318616965",
                4.9,
                R.drawable.billie_jean);
        Song Photograph = new Song("S1003",
                "Photograph",
                "Ed Sheeran",
                "https://p.scdn.co/mp3-preview/097c7b735ceb410943cbd507a6e1dfda272fd8a8?cid=2afe87a64b0042dabf51f37318616965\n",
                4.32,
                R.drawable.photograph);
        Song OnTheFloor = new Song("S1004",
                "On The Floor",
                "Jennifer Lopez feat Pitbull",
                "http://www.filefactory.com/stream/fv5z2mr4kwe/Roar-KatyPerry(Lyrics)(320kbps)(1).mp3",
                4.44,
                R.drawable.on_the_floor);
        Song Roar = new Song("S1005",
                "Roar",
                "Katty Perry",
                " https://www.mboxdrive.com/Roar-Katy Perry (Lyrics) (320 kbps) (1).mp3",
                3.43,
                R.drawable.roar);
        songs[0] = TheWayYouLookTonight;
        songs[1] = BillieJean;
        songs[2] = Photograph;
        songs[3] = OnTheFloor;
        songs[4] = Roar;
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



