package com.example.ywca_f22_week2.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.example.ywca_f22_week2.R;

public class MainActivity extends AppCompatActivity {
    static int GoodCode = 100;
    static int BadCode = 0;
     int selectedColour = 0;
    Switch bgSwitch;
    int value = 100;
    ConstraintLayout layout;
    ActivityResultLauncher<Intent> secondActivityLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {
            layout = findViewById(R.id.root);
            selectedColour = savedInstanceState.getInt("bgcolour");
            layout.setBackgroundColor(selectedColour);
            value = savedInstanceState.getInt("value");
        }


        layout = findViewById(R.id.root);



        Log.d("Week2App","On create");
        EditText fav = findViewById(R.id.favalue);
        Button tosecond = findViewById(R.id.tosecond);
        // get the result.

        this.setTitle("Week 2 App");

        secondActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == GoodCode){ //
                             Intent resultIntent = result.getData();
                            int value =  resultIntent.getExtras().getInt("MFSTM");
                            Log.d("Week2App" ,  "value for second activity "+value );
                    }else if (result.getResultCode() == BadCode){
                            Log.d("Week2App" ,  "No value from second activity" );

                        }
                    }
                }

        );

        bgSwitch = findViewById(R.id.bgswitch);
        bgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bgSwitch.isChecked())// the user need dart mode
                {
                    value = 1000;
                    selectedColour = getResources().getColor(R.color.dark,null);
                    layout.setBackgroundColor(getResources().getColor(R.color.dark,null));
                }
                else
                {
                    value = 1000;
                    selectedColour = getResources().getColor(R.color.white,null);
                    layout.setBackgroundColor(getResources().getColor(R.color.white,null));

                }
            }
        });

        tosecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!fav.getText().toString().isEmpty()) {
                    String value = fav.getText().toString();
//                    // within the same app,
//                    // intent could be a message inside the app (Explicit intents) (between activities) or outside the app.
                   Intent firstIntent = new Intent(MainActivity.this, SecondActivity.class);
//                    // key - value pairs (extars)
                    firstIntent.putExtra("FirstValue", value);
                    firstIntent.putExtra("SecondValue", "My value from first activity : ");

                    // start the activity without waitinf for any result
                    // startActivity(firstIntent);

                    // start the activity that will return a result.
                    secondActivityLauncher.launch(firstIntent);

                }
            }
        });

//
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       boolean flag = true;
            switch (item.getItemId()){
                case R.id.toForthActivity:
                    Intent intent = new Intent(MainActivity.this, ForthActivity.class);
                    startActivity(intent);
                break;
                case R.id.toThirdActivity:
                    Intent tintent = new Intent(MainActivity.this, ThirdActivity.class);
                    startActivity(tintent);
                    break;

                case R.id.toDonation:
                    Intent dintent = new Intent(MainActivity.this, DonationActivity.class);
                    startActivity(dintent);
                    break;
                case R.id.exit:
                    finish();

            }

       return flag;
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("value",value);
        outState.putInt("bgcolour",selectedColour);

    }
}