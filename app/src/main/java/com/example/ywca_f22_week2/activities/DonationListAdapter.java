package com.example.ywca_f22_week2.activities;

import android.content.Context;
import android.view.LayoutInflater;
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

    interface ItemListener{
        void onClicked(int post);
    }

    Context context;
    ArrayList<Donation> list;
    ItemListener listener;

    public DonationListAdapter(Context context, ArrayList<Donation> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DonationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.list_recycler_adapter_row,parent,false);
       return new DonationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DonationViewHolder holder, int position) {
        holder.amoutText.setText(list.get(position).getAmount() + "");
        holder.dateText.setText(list.get(position).getDonation_date());
        holder.pmText.setText(list.get(position).getPaymentMethod());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // inner class
    public class DonationViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener
    {
        TextView amoutText;
        TextView pmText;
        TextView dateText;
        public DonationViewHolder(@NonNull View itemView) {
            super(itemView);
            amoutText =  itemView.findViewById(R.id.rrow_amount);
            pmText =  itemView.findViewById(R.id.rrow_pm);
            dateText =  itemView.findViewById(R.id.rrow_date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClicked( getAdapterPosition());

        }
    }


}
