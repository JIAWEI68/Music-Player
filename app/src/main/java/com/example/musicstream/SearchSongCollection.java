package com.example.musicstream;

public class SearchSongCollection {
    private static Song getCurrentSong;
    public Song[] songs = new Song[30];
    private int currentIndex;

    public SearchSongCollection(){
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
        Song redBone = new Song("S1017",
                "RedBone",
                "Childish Gambino",
                "https://p.scdn.co/mp3-preview/0167089f98ed9b52156232cc17294c7676a88dd4?cid=2afe87a64b0042dabf51f37318616965",
                5.45,
                R.drawable.redbone_cover);
        Song everlastingSummer = new Song("S1018",
                "Everlasting Summer",
                "Hikaru Station",
                "https://p.scdn.co/mp3-preview/3473e43f252176228a75020d3c672fae3c195892?cid=2afe87a64b0042dabf51f37318616965",
                4.37,
                R.drawable.everlastin_summer);
        Song drunkMe = new Song("S1019",
                "Drunk Me",
                "Davin Kingston",
                "https://p.scdn.co/mp3-preview/dde251dddb5a373fa221d981715b1f06de1f0513?cid=2afe87a64b0042dabf51f37318616965",
                3.15,
                R.drawable.drunk_me);
        Song parachute = new Song("S1020",
                "parachute",
                "John K",
                "https://p.scdn.co/mp3-preview/8d68c12502ca5454361d93e8b9136d6564842cfb?cid=2afe87a64b0042dabf51f37318616965",
                2.61,
                R.drawable.parachute_cover);
        Song queenBee = new Song("S1021",
                "火炎",
                "QUEEN BEE",
                "https://p.scdn.co/mp3-preview/5de3de9cf71a2d6ecbe6a569e63be4399f82ba09?cid=2afe87a64b0042dabf51f37318616965",
                3.6,
                R.drawable.queen_bee);
        Song summerTime = new Song("S1022",
                "하계",
                "Maggie",
                "https://p.scdn.co/mp3-preview/8ddc6685b18c4728f3a6c4e461b9d5b9d751ce9f?cid=2afe87a64b0042dabf51f37318616965",
                2.57,
                R.drawable.summertime_cover);
        Song suspect = new Song("S1023",
                "Suspect",
                "hololive IDOL PROJECT",
                "https://p.scdn.co/mp3-preview/c0329d886247aea33a6d825de6a7fea6e60aa6af?cid=2afe87a64b0042dabf51f37318616965",
                4.47,
                R.drawable.suspect_cover);
        Song stopSaying = new Song("S1024",
                "Stop Sayin'",
                "Noah Raquel",
                "https://p.scdn.co/mp3-preview/ff8178941ef2db0ee18b89279538f55015129e05?cid=2afe87a64b0042dabf51f37318616965",
                2.87,
                R.drawable.stop_saying);
        Song constant = new Song("S1025",
                "Constant (feat Jeremy Passion)",
                "Jesse Barrera",
                "https://p.scdn.co/mp3-preview/cd80c8d288fcbb07248afa2ba924f607e3faa841?cid=2afe87a64b0042dabf51f37318616965",
                3.17,
                R.drawable.constant);
        Song storySeeker = new Song("S1026",
                "STORYSEEKER",
                "STEREO DIVE FOUNDATION",
                "https://p.scdn.co/mp3-preview/313a5bb4d00e4024e071ad3e2118bc529720ffb7?cid=2afe87a64b0042dabf51f37318616965",
                3.93,
                R.drawable.story_seeker);
        Song tpain = new Song("S1027",
                "T-Pain Mashup",
                "T-Pain Kurt Hugo Schneider",
                "https://p.scdn.co/mp3-preview/54865f9c0e1ede562c2a2166539c8217f5f01f01?cid=2afe87a64b0042dabf51f37318616965",
                3.08,
                R.drawable.t_pain);
        Song leaveTheDoorOpen = new Song("S1028",
                "Leave The Door Open",
                "Bruno Mars Anderson .Paak Silk Sonic",
                "https://p.scdn.co/mp3-preview/98f4a6a2e2c031e272ffc93c5fec5d7cb43de490?cid=2afe87a64b0042dabf51f37318616965",
                4.03,
                R.drawable.leave_the_door_open_cover);
        Song saySo = new Song("S1029",
                "Say So - Japanese Version",
                "Rainych",
                "https://p.scdn.co/mp3-preview/15c2e9923dcc420d408836e68ab6b3e811868911?cid=2afe87a64b0042dabf51f37318616965",
                4.04,
                R.drawable.say_so_cover);
        Song clearly = new Song("S1030",
                "Clearly",
                "Grace VanderWaal",
                "https://p.scdn.co/mp3-preview/ce26eb64ad19094160114797ee912fd5a1c21d70?cid=2afe87a64b0042dabf51f37318616965",
                4.2,
                R.drawable.clearly_cover);
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
        songs[16]=redBone;
        songs[17]=everlastingSummer;
        songs[18]=drunkMe;
        songs[19]=parachute;
        songs[20]=queenBee;
        songs[21]=summerTime;
        songs[22]=suspect;
        songs[23]=stopSaying;
        songs[24]=constant;
        songs[25]=storySeeker;
        songs[26]=tpain;
        songs[27]=leaveTheDoorOpen;
        songs[28]=saySo;
        songs[29]=clearly;
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
