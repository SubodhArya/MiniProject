package com.example.suman.miniproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BB extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private Button add;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bb);
        TextView textView = (TextView) findViewById(R.id.cprbb);
        textView.setText("https://fmovies.se/film/breaking-bad-1.xjnw");
        Linkify.addLinks(textView, Linkify.WEB_URLS);
        databaseReference= FirebaseDatabase.getInstance().getReference();

        VideoView videoView = (VideoView)findViewById(R.id.streambb);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        Uri uri= Uri.parse("http://docs.google.com/uc?export=download&id=0B718pmDeQIWGcnVhMFFUNHNSWU0" +
                "");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.start();


    }
    public void saveUserInfo()
    {
        String name= "BREAKING BAD" ;
        UserProfile userProfile= new UserProfile(name);
        FirebaseUser user= auth.getInstance().getCurrentUser();

        databaseReference.child(user.getUid()).setValue(userProfile);
        Toast.makeText(this,"Added to Wish list!",Toast.LENGTH_LONG).show();

    }
    public void onPR(View v)
    {
        if(R.id.fav13 == v.getId())
        {
            saveUserInfo();
        }
    }

   /* public void onDClick(View v)
    {
        if(R.id.dang == v.getId())
        {
            Intent i=new Intent(Hindi.this,Dangal.class);
            startActivity(i);
        }
    }
    public void onJLClick(View v)
    {
        if(R.id.jolly == v.getId())
        {
            Intent i=new Intent(Hindi.this,JL.class);
            startActivity(i);
        }
    }
    public void onBHClick(View v)
    {
        if(R.id.bhaagi == v.getId())
        {
            Intent i=new Intent(Hindi.this,BH.class);
            startActivity(i);
        }
    }


  /*  public void onNSClick(View v)
    {
        if(R.id.nenu == v.getId())
        {
            Intent i=new Intent(Telugu.this,NS.class);
            startActivity(i);
        }
    }*/


}


