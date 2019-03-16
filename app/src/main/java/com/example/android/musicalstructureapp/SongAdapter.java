package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Initialize the ArrayAdapter.
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID song_text_view
        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_text_view);
        // Get the song title from the current Song object and set this text on the name TextView
        songTextView.setText(currentSong.getSongTitle());

        // Find the TextView in the list_item.xml layout with the ID artist_text_view
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        // Get the artist name from the current Song object and set this text on the name TextView
        artistTextView.setText(currentSong.getArtistName());

        // Find the TextView in the list_item.xml layout with the ID album_text_view
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.album_text_view);
        // Get the album name from the current Song object and set this text on the name TextView
        albumTextView.setText(currentSong.getAlbumName());

        // Return the whole list item layout in the ListView
        return listItemView;
    }
}
