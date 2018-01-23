package com.example.suman.miniproject;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by suman on 01-10-2017.
 */

public class Favourites extends Fragment{

    View myView;

    public void Favourites()
    {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(" TOP TRENDING");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.favourites, container, false);

        ImageButton Ibtn = (ImageButton) myView.findViewById(R.id.GOT);
        Ibtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getActivity(),GOT.class);
                startActivity(i);

            }
        });

        ImageButton Ibtn1 = (ImageButton) myView.findViewById(R.id.Srii);
        Ibtn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent in = new Intent(getActivity(),Srimanthudu.class);
                startActivity(in);

            }
        });

        ImageButton Ibtn2 = (ImageButton) myView.findViewById(R.id.Dangg);
        Ibtn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent in = new Intent(getActivity(),Dangal.class);
                startActivity(in);

            }
        });




        return myView;
    }



}
