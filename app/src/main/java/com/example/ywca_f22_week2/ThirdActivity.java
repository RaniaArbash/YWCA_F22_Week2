package com.example.ywca_f22_week2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ThirdActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> cameraActivityLauncher;
    static int My_Camara_Request_Code = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ImageView photo = findViewById(R.id.photo);
        Button search = findViewById(R.id.searchID);
        EditText searchtext = findViewById(R.id.query);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!searchtext.getText().toString().isEmpty()) {
//                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
//                    intent.putExtra(SearchManager.QUERY, searchtext.getText().toString().isEmpty());
//                    if (intent.resolveActivity(getPackageManager()) != null)
//                        startActivity(intent);

                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + searchtext.getText().toString().isEmpty()));
                   // if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    //}


                }
            }
        });



        cameraActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                // what I need to do with the image
                if (result.getResultCode() == RESULT_OK){
                    Bitmap image = result.getData().getParcelableExtra("data");
                    photo.setImageBitmap(image);
                }
            }
        });


        Button cameraButton = findViewById(R.id.camera);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if we have a good permission to open camera app

                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)  {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                  //  if (intent.resolveActivity(getPackageManager()) != if (intent.resolveActivity(getPackageManager()) != n null)
                        cameraActivityLauncher.launch(intent);
                }else {
                    requestPermissions(new String[] {Manifest.permission.CAMERA}, My_Camara_Request_Code);
                }


                }

            });





        }
    }
