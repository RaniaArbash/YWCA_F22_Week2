package com.example.ywca_f22_week2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    static int GoodCode = 100;
    static int BadCode = 0;

    ActivityResultLauncher<Intent> secondActivityLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}