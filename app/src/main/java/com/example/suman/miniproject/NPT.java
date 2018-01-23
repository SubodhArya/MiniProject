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

public class NPT  extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private Button add;
    FirebaseAuth auth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.npt);

        TextView textView1 = (TextView) findViewById(R.id.cpr5);
        textView1.setText("https://fmovies.se/film/nannaku-prematho.n5q8");
        Linkify.addLinks(textView1, Linkify.WEB_URLS);
        databaseReference= FirebaseDatabase.getInstance().getReference();


        VideoView videoView = (VideoView)findViewById(R.id.streamnpt);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        Uri uri= Uri.parse("http://docs.google.com/uc?export=download&id=0B718pmDeQIWGeHU0ZnpncWJBVjA");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.start();

    }

    public void saveUserInfo()
    {
        String name= "NANNAKU PREMATHO" ;
        UserProfile userProfile= new UserProfile(name);
        FirebaseUser user= auth.getInstance().getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userProfile);
        Toast.makeText(this,"Added to Wish list!",Toast.LENGTH_LONG).show();

    }
    public void onPR(View v)
    {
        if(R.id.fav6 == v.getId())
        {
            saveUserInfo();
        }
    }

}
