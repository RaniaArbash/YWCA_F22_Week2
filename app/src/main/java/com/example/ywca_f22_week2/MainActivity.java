package com.example.ywca_f22_week2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Week2App","On create");
        EditText fav = findViewById(R.id.favalue);
        Button tosecond = findViewById(R.id.tosecond);
        tosecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!fav.getText().toString().isEmpty()) {
                    String value = fav.getText().toString();
                    // within the same app,
                    // intent could be a message inside the app (Explicit intents) (between activities) or outside the app.
                    Intent firstIntent = new Intent(MainActivity.this, SecondActivity.class);
                    // key - value pairs (extars)
                    firstIntent.putExtra("FirstValue", value);
                    firstIntent.putExtra("SecondValue", "My value from first activity : ");
                    startActivity(firstIntent);
                }
            }
        });



    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Week2App","On pause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Week2App","On resume");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Week2App","On start");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Week2App","On restart");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Week2App","On stop");

    }
}