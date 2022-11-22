package com.example.ywca_f22_week2.activities;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ywca_f22_week2.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ywca_f22_week2.Donation;

import java.util.ArrayList;


public class DonationListAdapter extends
        RecyclerView.Adapter<DonationListAdapter.DonationViewHolder> {


    Context context;
    ArrayList<Donation> list;

    @NonNull
    @Override
    public DonationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DonationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DonationViewHolder extends RecyclerView.ViewHolder{

        TextView amoutText;
        TextView pmText;
        TextView dateText;
        public DonationViewHolder(@NonNull View itemView) {
            super(itemView);
            amoutText =  itemView.findViewById(R.id.rrow_amount);
            pmText =  itemView.findViewById(R.id.rrow_pm);
            dateText =  itemView.findViewById(R.id.rrow_date);



        }
    }


}
