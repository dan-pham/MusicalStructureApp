package com.example.android.musicalstructureapp;

public class Song {

    // Title of the song
    private String mSongTitle;

    // Name of the artist
    private String mArtistName;

    // Name of the album
    private String mAlbumName;

    public Song(String songTitle, String artistName, String albumName) {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mAlbumName = albumName;
    }

    // Get the title of the song
    public String getSongTitle() {
        return mSongTitle;
    }

    // Get the name of the artist
    public String getArtistName() {
        return mArtistName;
    }

    // Get the name of the album
    public String getAlbumName() {
        return mAlbumName;
    }

}
