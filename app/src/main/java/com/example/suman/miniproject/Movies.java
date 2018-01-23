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

public class Movies extends Fragment{

    View myView;

    public void Movies()
    {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("MOVIES");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.movies, container, false);

        ImageButton Ibtn = (ImageButton) myView.findViewById(R.id.Beng);
        Ibtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getActivity(),English.class);
                startActivity(i);

            }
        });

        ImageButton Ibtn1 = (ImageButton) myView.findViewById(R.id.Btel);
        Ibtn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent in = new Intent(getActivity(),Telugu.class);
                startActivity(in);

            }
        });

        ImageButton Ibtn2 = (ImageButton) myView.findViewById(R.id.Bhin);
        Ibtn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent in = new Intent(getActivity(),Hindi.class);
                startActivity(in);

            }
        });




        return myView;
    }



    }
