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

public class BH extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private Button add;
    FirebaseAuth auth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bh);

        TextView textView1 = (TextView) findViewById(R.id.cpr10);
        textView1.setText("https://fmovies.se/film/baaghi.mn7v");
        Linkify.addLinks(textView1, Linkify.WEB_URLS);
        databaseReference= FirebaseDatabase.getInstance().getReference();


        VideoView videoView = (VideoView)findViewById(R.id.streambh);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        Uri uri= Uri.parse("http://dl2.herodls.me/siteuploads//files/sfd83/41333/Baaghi%20(2016)%20Movie%20Trailer-(HeroMaza.In).mp4");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.start();

    }
    public void saveUserInfo()
    {
        String name= "BHAAGI" ;
        UserProfile userProfile= new UserProfile(name);
        FirebaseUser user= auth.getInstance().getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userProfile);
        Toast.makeText(this,"Added to Wish list!",Toast.LENGTH_LONG).show();

    }
    public void onPR(View v)
    {
        if(R.id.fav11 == v.getId())
        {
            saveUserInfo();
        }
    }



}
