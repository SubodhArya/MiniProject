package com.example.suman.miniproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by suman on 27-09-2017.
 */
import static com.example.suman.miniproject.R.*;

public class Display extends Activity {
    DataBaseHelper helper;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        helper = new DataBaseHelper( this);
        super.onCreate(savedInstanceState);

        setContentView(layout.display);


    }
    public void onButtonClick3(View v) {


        if (v.getId() == R.id.signin) {

            EditText a = (EditText) findViewById(R.id.username);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.pass);
            String pass1 = b.getText().toString();

            boolean password = helper.searchPass(str ,pass1);

            //if (pass1.equals(password))
                if (password == true)


                {


                Intent i = new Intent(this, Welcome.class);
                i.putExtra("username", str);


                startActivity(i);
                return;
            }
            else{
                   Toast passout = Toast.makeText(Display.this, "Password Incorrect", Toast.LENGTH_SHORT);
                    passout.show();
               }

        }
    }
    public void onButtonClick2(View v) {

        if( v.getId() == id.signup)
        {
            Intent i;
            i = new Intent(this,Signup.class);
            startActivity(i);
        }
    }
}
