package com.example.myquicklauncherapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnGoogle, btnSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoogle = findViewById(R.id.btnGoogle);
        btnSecondActivity = findViewById(R.id.btnSecondActivity);

        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //what is its context and where do we need it to go
                Intent startIntent = new Intent(getApplicationContext(),SecondActivity.class);
                //now we want to put values from here into the textview
                //the following is a key value pair, passing something being the unique key and the value as hello world
                //when you type in one double quote after ut extra - it asks for a name == key, after you put a comma and another double quote
                //it asks for the value you want to associate with that key.
                startIntent.putExtra("PassingSomething", "Hello World" );

                startActivity(startIntent);
            }
        });

        //launch activity outside app
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "https://www.google.com";
                Uri webAddress = Uri.parse(google);
                //dont need the context for an external intent
                Intent googleIntent = new Intent(Intent.ACTION_VIEW, webAddress);

                if (googleIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(googleIntent);
                }
            }
        });



    }
}
