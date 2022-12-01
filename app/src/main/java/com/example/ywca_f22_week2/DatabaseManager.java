package com.example.ywca_f22_week2;

import android.content.Context;

import androidx.room.Room;

public class DatabaseManager {

    Context context;
    DonationDataBase db;

    public DatabaseManager(Context context) {
        this.context = context;
    }

    public DonationDataBase getDB(){
        if (db == null){
            db = Room.databaseBuilder(context,
                    DonationDataBase.class, "donationDB").build();
        }
        return db;
    }


}
