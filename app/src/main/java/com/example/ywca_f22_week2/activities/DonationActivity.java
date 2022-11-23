package com.example.ywca_f22_week2.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.example.ywca_f22_week2.Donation;
import com.example.ywca_f22_week2.R;

import java.util.Calendar;
import java.util.Date;

public class DonationActivity extends AppCompatActivity {

    RadioButton ppRB;
    RadioButton ccRB;
    EditText amountText;
    Donation currentDonationObject;
    Switch bgSwitch;
    RelativeLayout layout;
    int selectedColour = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            selectedColour = savedInstanceState.getInt("bgcolour");
            layout.setBackgroundColor(selectedColour);

        }
        setContentView(R.layout.activity_donation);
        ppRB = findViewById(R.id.ppRB);
        ccRB = findViewById(R.id.ccRB);
        amountText = findViewById(R.id.amountText);
        layout = findViewById(R.id.roodlayout);
        currentDonationObject = ((MyApp)getApplication()).appDonationObject;
        Log.d("Week2App", currentDonationObject.getDonationInfo());


        Button donate_button = findViewById(R.id.donatebutton);
        donate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateUI()){
//                    int payment_method = 0;
//                    if (ccRB.isSelected())
//                        payment_method = 1;
//                    else
//                        payment_method = 0;

                    int payment_method = (ccRB.isChecked()? 1 : 0);
                    double amount = Double.parseDouble(amountText.getText().toString());
                    Date donationTime = Calendar.getInstance().getTime();

                    currentDonationObject = new Donation(amount, payment_method , donationTime.toString());
                    ((MyApp)getApplication()).appDonationObject = currentDonationObject;

                    ((MyApp)getApplication()).appDonationList.add(currentDonationObject);


                    Log.d("Week2App", currentDonationObject.getDonationInfo());
                    showTheAlert(currentDonationObject);
                }


            }
        });

        bgSwitch = findViewById(R.id.bgswitch);
        bgSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bgSwitch.isChecked())// the user need dart mode
                {
                    selectedColour = R.color.dark;
                    layout.setBackgroundColor(getResources().getColor(R.color.dark,null));
                }
                    else
                {
                    selectedColour = R.color.white;
                    layout.setBackgroundColor(getResources().getColor(R.color.white,null));

                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.donation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean flag = true;
        switch (item.getItemId()) {
            case R.id.torecycler:
                Intent i = new Intent(DonationActivity.this,DonationRecyclerList.class);
                startActivity(i);
                break;
        }
        return flag;
    }
            boolean validateUI(){
        boolean valid = false;
        if (!amountText.getText().toString().isEmpty() && (
            ppRB.isChecked() || ccRB.isChecked() ))
                 valid = true;
        return valid;


    }

    void showTheAlert(Donation d){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Thank You for Your " +d.getAmount()+ " donation.")
                .setTitle("All Done!!");
        builder.setNegativeButton("OK",null);

        builder.setPositiveButton("Show a Report",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // open a report activity
                Intent toReport = new Intent(DonationActivity.this, ReportActivity.class);
                toReport.putExtra("donationObject", d);
                startActivity(toReport);
            }
        });
       builder.create().show();
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("bgcolour",selectedColour);

    }
}