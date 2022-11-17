package com.example.ywca_f22_week2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ywca_f22_week2.R;

public class SecondActivity extends AppCompatActivity {
    static int GoodCode = 100;
    static int BadCode = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Week2App", "Second Activity created ");
        setContentView(R.layout.activity_second);
        TextView sat = findViewById(R.id.satext);
        EditText valueTF = findViewById(R.id.value);

        if( getIntent().hasExtra("FirstValue")) {
            String s = getIntent().getExtras().getString("FirstValue");
            String s2 = getIntent().getExtras().getString("SecondValue");
            sat.setText(s2 + s);
        }

        Button backtoMain = findViewById(R.id.returnToMain);
        backtoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (valueTF.getText().toString().isEmpty()){
                    Intent resultIntent = new Intent();
                    setResult(BadCode,resultIntent);
                    finish();// dismiss
                }else {
                    Intent resultIntent = new Intent();
                    // function to check if the string is integer before parsing
                    resultIntent.putExtra("MFSTM", Integer.parseInt( valueTF.getText().toString()));
                    setResult(GoodCode,resultIntent);

                    finish();// dismiss
                }

            }
        });
    }

}
