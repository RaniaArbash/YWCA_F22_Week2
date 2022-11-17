package com.example.ywca_f22_week2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ywca_f22_week2.Donation;
import com.example.ywca_f22_week2.R;

public class ReportActivity extends AppCompatActivity {

    ListView donationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        TextView msg = findViewById(R.id.reportText);
        donationList = findViewById(R.id.donationsList);

        DonationBaseAdapter adapter = new DonationBaseAdapter(((MyApp)getApplication()).appDonationList,
                ReportActivity.this);
        donationList.setAdapter(adapter);

//        if (getIntent().hasExtra("msg"))
//            msg.setText(getIntent().getStringExtra("msg"));
//        else
//            msg.setText("No donation!!!");

        Donation dFromA = getIntent().getParcelableExtra("donationObject");

       // Donation dFromA =  ((MyApp)getApplication()).appDonationObject;

        String pm = (dFromA.getPaymentMethod() == 0 ? "PayPal": "Credit Card");
        msg.setText("Your donation amount is " + dFromA.getAmount() +
                        "$ and it is completed using " +  pm +  " at : " + dFromA.getDonation_date() );

    }
}