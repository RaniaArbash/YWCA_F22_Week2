package com.example.ywca_f22_week2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.room.Room;

import com.example.ywca_f22_week2.activities.MyApp;

public class DatabaseManager {

   public interface DatabaseListener{
        public void onInsertCompleted();
        public void onFetchingCompleted(Donation [] list);
    }

   public DatabaseListener listener;
    Context context;
    DonationDataBase db;
// create a handler to communicate with main thread.
    Handler handler = new Handler(Looper.getMainLooper());

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


    public void insertNewDonationAsync(Donation d){
            MyApp.executorService.execute(new Runnable() {
                @Override
                public void run() {// run in background thread
                    getDB().getDao().insertOneDonation(d);// task needs time
                    handler.post(new Runnable() { // executed in main thread
                        @Override
                        public void run() {
                            listener.onInsertCompleted();
                        }
                    });
                }
            });
    }
    public void getAllDonationsAsync(){
        MyApp.executorService.execute(new Runnable() {
            @Override
            public void run() {// run in background thread
                Donation [] list = getDB().getDao().getAllDonations();
                handler.post(new Runnable() { // executed in main thread
                    @Override
                    public void run() {
                        listener.onFetchingCompleted(list);
                    }
                });
            }
        });


    }

}
