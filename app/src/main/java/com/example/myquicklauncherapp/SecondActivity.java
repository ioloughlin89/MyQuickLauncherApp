package com.example.myquicklauncherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().hasExtra("PassingSomething")){
            TextView tvData = (TextView) findViewById(R.id.tvData);
            String text = getIntent().getExtras().getString("PassingSomething");
            tvData.setText(text);
        }
    }
}
