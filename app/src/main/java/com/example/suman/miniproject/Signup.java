package com.example.suman.miniproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.suman.miniproject.R.layout.signup;

/**
 * Created by suman on 27-09-2017.
 */

public class Signup extends AppCompatActivity {
DataBaseHelper helper =new DataBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(signup);


    }

    public void onCreateButton(View v)
    {

        EditText Sname= (EditText)findViewById(R.id.Sname);
        EditText SDOB= (EditText)findViewById(R.id.SDOB);
        EditText Semail= (EditText)findViewById(R.id.Semail);
        EditText Spass1= (EditText)findViewById(R.id.Spass1);
        EditText Spass2= (EditText)findViewById(R.id.Spass2);

        String Snamestr= Sname.getText().toString();
        String SDOBstr= SDOB.getText().toString();
        String Semailstr= Semail.getText().toString();
        String Spass1str= Spass1.getText().toString();
        String Spass2str= Spass2.getText().toString();

        if(!Spass1str.equals(Spass2str))
        {
            Toast pass= Toast.makeText(Signup.this,"Passwords Do not Match",Toast.LENGTH_SHORT);
            pass.show();
        }
        else
        {
            Contact c =new Contact();
            c.setName(Snamestr);
            c.setDOB(SDOBstr);
            c.setEmail(Semailstr);
            c.setPass(Spass1str);
            helper.insertContact(c);
            Toast pass2= Toast.makeText(Signup.this,"Successfully Created.Go back and Log in",Toast.LENGTH_SHORT);
            pass2.show();
        }
    }
}
