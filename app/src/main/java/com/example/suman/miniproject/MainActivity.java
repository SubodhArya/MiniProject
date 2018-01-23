package com.example.suman.miniproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import static com.example.suman.miniproject.R.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
    }
    public void onButtonClick(View v)
    {
        if(R.id.Bdisplay == v.getId())
        {
            Intent i=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(i);
        }
    }
}
