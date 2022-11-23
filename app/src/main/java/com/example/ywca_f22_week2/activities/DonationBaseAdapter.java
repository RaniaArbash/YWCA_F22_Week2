package com.example.ywca_f22_week2.activities;

import android.app.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ywca_f22_week2.Donation;
import com.example.ywca_f22_week2.R;

import java.util.ArrayList;

public class DonationBaseAdapter extends BaseAdapter {

    // list of donations to render
    // the context

    ArrayList<Donation> list;
    Context context;

    DonationBaseAdapter(ArrayList<Donation> dlist, Context c){
        this.list = dlist;
        context = c;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.list_base_adapter_row,viewGroup,false);

        TextView at = v.findViewById(R.id.row_amount);
        at.setText(String.valueOf(list.get(i).getAmount()));

        TextView pmt = v.findViewById(R.id.row_pm);
        pmt.setText(list.get(i).getPaymentMethod());

        TextView dt = v.findViewById(R.id.row_date);
        dt.setText(list.get(i).getDonation_date());

        return v;
    }
}
