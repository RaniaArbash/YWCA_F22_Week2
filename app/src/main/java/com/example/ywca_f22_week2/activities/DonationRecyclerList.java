package com.example.ywca_f22_week2.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.ywca_f22_week2.DatabaseManager;
import com.example.ywca_f22_week2.Donation;
import com.example.ywca_f22_week2.R;

import java.util.ArrayList;
import java.util.Arrays;

public class DonationRecyclerList extends AppCompatActivity
        implements DonationListAdapter.ItemListener ,
        DatabaseManager.DatabaseListener {
    DonationListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_recycler_list);

        RecyclerView list = findViewById(R.id.donationRecyclerList);
        adapter = new DonationListAdapter(this,
                ((MyApp)getApplication()).appDonationList);
        ((MyApp)getApplication()).databaseManager.listener = this;
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchViewMenu = menu.findItem(R.id.searchview);

        SearchView searchView = (SearchView) searchViewMenu.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("Donation app submit",query);

                if (!query.isEmpty() && isNumeric(query)) {
                    ((MyApp) getApplication()).databaseManager.getDonationsWithLimitsAsync(Double.parseDouble(query));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
              //  Log.d("Donation app change",newText);
                if (newText.length() == 0)
                {
                    adapter.list = ((MyApp)getApplication()).appDonationList;
                    adapter.notifyDataSetChanged();
                }
                return false;
            }
        });


        return true;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }


    @Override
    public void onInsertCompleted() {

    }

    @Override
    public void onFetchingCompleted(Donation[] list) {

    }

    @Override
    public void onFetchDonationsWithLimitsCompleted(Donation[] list) {
       // adapter = new DonationListAdapter(this, new ArrayList<Donation>(Arrays.asList(list));
        adapter.list = new ArrayList<Donation>(Arrays.asList(list));
        adapter.notifyDataSetChanged();
    }
}