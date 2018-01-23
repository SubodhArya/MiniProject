package com.example.suman.miniproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suman on 15-10-2017.
 */

public class Fav extends AppCompatActivity {
    ListView listViewArtists;
    DatabaseReference databaseReference;
    FirebaseAuth auth;
    List<UserProfile> artistlist;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fav);
        listViewArtists =(ListView)findViewById(R.id.listViewArtists);
        artistlist=new ArrayList<>();
        databaseReference= FirebaseDatabase.getInstance().getReference();


    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list


                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    UserProfile artist = postSnapshot.getValue(UserProfile.class);
                    //adding artist to the list
                    artistlist.add(artist);
                }

                //creating adapter
                ArtistList artistAdapter = new ArtistList(Fav.this, artistlist);
                //attaching adapter to the listview
                listViewArtists.setAdapter(artistAdapter);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}