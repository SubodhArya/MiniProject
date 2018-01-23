package com.example.suman.miniproject;

/**
 * Created by suman on 15-10-2017.
 */

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Belal on 2/26/2017.
 */

public class ArtistList extends ArrayAdapter<UserProfile> {
    private Activity context;
    List<UserProfile> artists;

    public ArtistList(Activity context, List<UserProfile> artists) {
        super(context, R.layout.wishlist, artists);
        this.context = context;
        this.artists = artists;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.wishlist, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);


        UserProfile artist = artists.get(position);
        textViewName.setText(artist.getUserName());


        return listViewItem;
    }
}

