package com.example.suman.miniproject;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;
import java.util.Random;





/**
 * Created by suman on 01-10-2017.
 */

public class Reminders extends Fragment{
    AlarmManager alarmManager;
    private PendingIntent pending_intent;

    private TimePicker alarmTimePicker;
    private TextView alarmTextView;

    private AlarmReceiver alarm;


    Reminders inst;
    Context context;

    View myView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("REMINDERS");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView=inflater.inflate(R.layout.reminders,container,false);





        Button Ibtn = (Button) myView.findViewById(R.id.reminder);
        Ibtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getActivity(),Mains.class);
                startActivity(i);

            }
        });


        return myView;


    }
}

