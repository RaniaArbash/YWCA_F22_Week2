package com.example.ywca_f22_week2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Week2App", "Second Activity created ");
        setContentView(R.layout.activity_second);
        TextView sat = findViewById(R.id.satext);

        if( getIntent().hasExtra("FirstValue")) {
            String s = getIntent().getExtras().getString("FirstValue");
            String s2 = getIntent().getExtras().getString("SecondValue");
            sat.setText(s2 + s);


        }
    }

}
