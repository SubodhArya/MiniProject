package com.example.suman.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Hindi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hindi);

    }
    public void onDClick(View v)
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


