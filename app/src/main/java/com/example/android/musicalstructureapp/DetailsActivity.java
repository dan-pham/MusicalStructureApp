package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

//Pass in the variables for the intent from MainActivity
import static com.example.android.musicalstructureapp.MainActivity.KEY_SONG;
import static com.example.android.musicalstructureapp.MainActivity.KEY_ARTIST;
import static com.example.android.musicalstructureapp.MainActivity.KEY_ALBUM;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the content of the activity to use the song_details.xml layout file
        setContentView(R.layout.song_details);

        //Initialize empty strings
        String songTitle = "";
        String artistName = "";
        String albumName = "";

        //If there is information with the intent, pass it to the strings declared
        Intent intent = getIntent();
        if (null != intent) {
            songTitle = intent.getStringExtra(KEY_SONG);
            artistName = intent.getStringExtra(KEY_ARTIST);
            albumName = intent.getStringExtra(KEY_ALBUM);
        }

        TextView songText = (TextView) findViewById(R.id.song);
        songText.setText(songTitle);

        TextView artistText = (TextView) findViewById(R.id.artist);
        artistText.setText(artistName);

        TextView albumText = (TextView) findViewById(R.id.album);
        albumText.setText(albumName);

        //Reference used from:
        //https://stackoverflow.com/questions/32420565/android-changing-imageview-between-two-images-on-button-click-and-reclick
        //Change the play button to a pause button and vice versa when clicked
        final ImageView playButton = (ImageView) findViewById(R.id.playButton);
        playButton.setTag(1);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playButton.getTag().equals(1)) {
                    playButton.setImageResource(R.drawable.ic_action_playback_pause);
                    playButton.setTag(2);
                } else {
                    playButton.setImageResource(R.drawable.ic_action_playback_play);
                    playButton.setTag(1);
                }
            }
        });
    }
}
