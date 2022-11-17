package com.example.ywca_f22_week2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ywca_f22_week2.R;

public class ForthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);
        TextView selecteCollegeText = findViewById(R.id.selected_college);
        Spinner college_spinner = findViewById(R.id.college_spinner);

        String[] collge_names = {"Seneca" , "Humber","Centennial","Niagara"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinner_row,
                R.id.row_college_name,
                collge_names);

        college_spinner.setAdapter(adapter);
        college_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selecteCollegeText.setText(collge_names[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ListView collegeList = findViewById(R.id.list);
        String[] list_collge_names = {"Seneca" , "Humber","Centennial","Niagara","Sherden", "Ottawa"};


        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this,
                R.layout.list_row,
                R.id.row_list_college_name,
                list_collge_names
                );

        collegeList.setAdapter(listAdapter);
        collegeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ForthActivity.this,
                        "The selecte College is " +
                                list_collge_names[i],Toast.LENGTH_LONG).show();
            }
        });


    }
}