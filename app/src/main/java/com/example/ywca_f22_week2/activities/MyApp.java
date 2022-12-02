package com.example.ywca_f22_week2.activities;

import android.app.Application;

import com.example.ywca_f22_week2.DatabaseManager;
import com.example.ywca_f22_week2.Donation;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyApp extends Application {

    // application data

    Donation appDonationObject = new Donation(0,-1,"");
    ArrayList<Donation> appDonationList = new ArrayList<>(0);
    // No access to the context
    DatabaseManager databaseManager;
    static public ExecutorService executorService = Executors.newFixedThreadPool(4);
}
