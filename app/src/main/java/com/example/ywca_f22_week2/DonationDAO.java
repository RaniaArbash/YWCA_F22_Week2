package com.example.ywca_f22_week2;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.ArrayList;

@Dao
public interface DonationDAO {

    @Insert
    void insertOneDonation(Donation d);

    @Delete
    void deleteOneDonation(Donation d);

    @Query("delete from Donation")
    void deleteAllDonation();

    @Query("select * from Donation") // compile time checking
    Donation[] getAllDonations();

    @Query("select * from Donation where amount >= :a")
    Donation[] getDonationsWithAmountMoreThan(double a);

    @Query("select * from Donation where pm == :pm")
    Donation[] getDonationsWithSpecificPM(int pm);



}
