package com.example.ywca_f22_week2.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.ywca_f22_week2.Donation;
import com.example.ywca_f22_week2.R;

public class DonationRecyclerList extends AppCompatActivity
        implements DonationListAdapter.ItemListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_recycler_list);

        RecyclerView list = findViewById(R.id.donationRecyclerList);
        DonationListAdapter adapter = new DonationListAdapter(this,
                ((MyApp)getApplication()).appDonationList);
        adapter.listener = this;
        list.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        list.setLayoutManager(llm);


    }

    @Override
    public void onClicked(int post) {
        showTheAlert(((MyApp)getApplication()).appDonationList.get(post));
    }

    void showTheAlert(Donation d){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("The Selected Donation is  " +d.getAmount()+ " donation,it completed on " + d.getDonation_date())
                .setTitle("Info!!");
        builder.setNegativeButton("OK",null);


        builder.create().show();
    }

}