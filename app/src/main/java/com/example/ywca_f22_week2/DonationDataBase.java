package com.example.ywca_f22_week2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Donation.class},version = 1)
public abstract class DonationDataBase extends RoomDatabase {
    public abstract DonationDAO getDao();
}
