package com.example.ywca_f22_week2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class DonationActivity extends AppCompatActivity {

    RadioButton ppRB;
    RadioButton ccRB;
    EditText amountText;
    Donation currentDonationObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        ppRB = findViewById(R.id.ppRB);
        ccRB = findViewById(R.id.ccRB);
        amountText = findViewById(R.id.amountText);

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



                    Log.d("Week2App", currentDonationObject.getDonationInfo());
                    showTheAlert(currentDonationObject);
                }


            }
        });
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

        builder.setMessage("Thank You for Your " +d.amount+ " donation.")
                .setTitle("All Done!!");

        builder.setNegativeButton("OK",null);

        builder.setPositiveButton("Show a Report",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // open a report activity
                Intent toReport = new Intent(DonationActivity.this, ReportActivity.class);
                toReport.putExtra("donationObject", d);

//                String pm = (d.paymentMethod == 0 ? "PayPal": "Credit Card");
//                toReport.putExtra("msg","Your donation amount is " + d.amount +
//                        " and it is completed using " +  pm );

                startActivity(toReport);

            }
        });
       builder.create().show();
    }

}