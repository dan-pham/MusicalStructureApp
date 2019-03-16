package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Create variables to pass through intent
    public static final String KEY_SONG = "KEY_SONG";
    public static final String KEY_ARTIST = "KEY_ARTIST";
    public static final String KEY_ALBUM = "KEY_ALBUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        // Create a list of songs
        ArrayList<Song> songs = new ArrayList<Song>();

        //List of added songs
        songs.add(new Song("Let It Snow!", "Bing Crosby", "Christmas"));
        songs.add(new Song("Rudolph The Red-Nosed Reindeer", "Burl Ives", "Christmas Classics"));
        songs.add(new Song("Happy Christmas", "John Lennon", "Lennon Legend"));
        songs.add(new Song("That's Christmas To Me", "Pentatonix", "A Pentatonix Christmas"));
        songs.add(new Song("White Christmas", "Pentatonix", "A Pentatonix Christmas"));
        songs.add(new Song("I'll Be Home For Christmas", "Pentatonix", "A Pentatonix Christmas"));
        songs.add(new Song("O Come, All Ye Faithful", "Pentatonix", "A Pentatonix Christmas"));
        songs.add(new Song("Carol of the Bells", "Peter Hollens", "A Hollens Family Christmas"));
        songs.add(new Song("Grown Up Christmas List", "Peter Hollens", "A Hollens Family Christmas"));
        songs.add(new Song("December Song", "Peter Hollens", "A Hollens Family Christmas"));
        songs.add(new Song("Believe", "Peter Hollens", "A Hollens Family Christmas"));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings.
        final SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of songs.
        listView.setAdapter(adapter);

        //When the user clicks on the item, pass the item details through the intent
        //Set a clickListener on that View
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Song item = (Song) adapter.getItem(i);
                Intent detailsIntent = new Intent(getApplicationContext(), DetailsActivity.class);
                detailsIntent.putExtra(KEY_SONG, item.getSongTitle());
                detailsIntent.putExtra(KEY_ARTIST, item.getArtistName());
                detailsIntent.putExtra(KEY_ALBUM, item.getAlbumName());
                startActivity(detailsIntent);
            }
        });
    }
}
