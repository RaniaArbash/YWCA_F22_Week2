package com.example.ywca_f22_week2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        TextView msg = findViewById(R.id.reportText);
//        if (getIntent().hasExtra("msg"))
//            msg.setText(getIntent().getStringExtra("msg"));
//        else
//            msg.setText("No donation!!!");

        Donation dFromA = getIntent().getParcelableExtra("donationObject");

       // Donation dFromA =  ((MyApp)getApplication()).appDonationObject;

        String pm = (dFromA.paymentMethod == 0 ? "PayPal": "Credit Card");
        msg.setText("Your donation amount is " + dFromA.amount +
                        "$ and it is completed using " +  pm +  " at : " + dFromA.donation_date );

    }
}