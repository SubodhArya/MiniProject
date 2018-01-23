package com.example.suman.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class English extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.english);
    }

    public void onButtonClick(View v)
    {
        if(R.id.Pacificrim == v.getId())
        {
            Intent i=new Intent(English.this,PacificRim.class);
            startActivity(i);
        }
    }
    public void onBVSMClick(View v)
    {
        if(R.id.Batman == v.getId())
        {
            Intent i=new Intent(English.this,BVSM.class);
            startActivity(i);
        }
    }
    public void onASMClick(View v)
    {
        if(R.id.Spiderman == v.getId())
        {
            Intent i=new Intent(English.this,ASM.class);
            startActivity(i);
        }
    }


    public void onAClick(View v)
    {
        if(R.id.Anabelle == v.getId())
        {
            Intent i=new Intent(English.this,Anabelle.class);
            startActivity(i);
        }
    }
}



