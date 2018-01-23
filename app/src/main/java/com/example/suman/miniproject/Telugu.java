package com.example.suman.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Telugu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telugu);
    }
    public void onButtonClick(View v)
    {
        if(R.id.sri == v.getId())
        {
            Intent i=new Intent(Telugu.this,Srimanthudu.class);
            startActivity(i);
        }
    }
     public void onNPTClick(View v)
    {
        if(R.id.nannaku == v.getId())
        {
            Intent i=new Intent(Telugu.this,NPT.class);
            startActivity(i);
        }
    }
    public void onERClick(View v)
    {
        if(R.id.expr == v.getId())
        {
            Intent i=new Intent(Telugu.this,ER.class);
            startActivity(i);
        }
    }


    public void onNSClick(View v)
    {
        if(R.id.nenu == v.getId())
        {
            Intent i=new Intent(Telugu.this,NS.class);
            startActivity(i);
        }
    }
        
    }

