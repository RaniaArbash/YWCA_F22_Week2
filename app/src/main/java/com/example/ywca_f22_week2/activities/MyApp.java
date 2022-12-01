package com.example.ywca_f22_week2.activities;

import android.app.Application;

import com.example.ywca_f22_week2.DatabaseManager;
import com.example.ywca_f22_week2.Donation;

import java.util.ArrayList;

public class MyApp extends Application {

    // application data

    Donation appDonationObject = new Donation(0,-1,"");
    ArrayList<Donation> appDonationList = new ArrayList<>(0);

    DatabaseManager databaseManager;

}
