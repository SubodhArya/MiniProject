package com.example.suman.miniproject;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.TextView;
import android.text.util.Linkify;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by suman on 01-10-2017.
 */

public class ASM extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private Button add;
    FirebaseAuth auth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asm);

        TextView textView1 = (TextView) findViewById(R.id.cpr2);
        textView1.setText("https://fmovies.se/film/the-amazing-spider-man.80m3");
        Linkify.addLinks(textView1, Linkify.WEB_URLS);
        databaseReference= FirebaseDatabase.getInstance().getReference();


        VideoView videoView = (VideoView)findViewById(R.id.streamasm);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        Uri uri= Uri.parse("http://videos.hd-trailers.net/the-amazing-spider-man-trailer-5.1-480p-HDTN.mp4");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.start();

    }
    public void saveUserInfo()
    {
        String name= "THE AMAZING SPIDERMAN" ;
        UserProfile userProfile= new UserProfile(name);
        FirebaseUser user= auth.getInstance().getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userProfile);
        Toast.makeText(this,"Added to Wish list!",Toast.LENGTH_LONG).show();

    }
    public void onPR(View v)
    {
        if(R.id.fav3 == v.getId())
        {
            saveUserInfo();
        }
    }



}
