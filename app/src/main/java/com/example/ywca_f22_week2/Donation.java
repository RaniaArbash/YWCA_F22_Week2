package com.example.ywca_f22_week2;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Donation implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    int id;

    @NonNull
    double amount;

    @ColumnInfo(name = "pm")
    int paymentMethod ; // 0 for paypal and 1 for credit card

    @Nullable
    String donation_date;


    public Donation(double amount, int paymentMethod, String donation_date) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.donation_date = donation_date;
    }

   public String getDonationInfo(){
        String pm = (this.paymentMethod == 0 ? "PayPal": "Credit Card");
        if (this.paymentMethod == -1)
            pm = "No Object";
        return "The Object amout is " + this.amount + "$ and the payment method is " + pm;
    }

    protected Donation(Parcel in) {
        id = in.readInt();
        amount = in.readDouble();
        paymentMethod = in.readInt();
        donation_date = in.readString();
    }

    public static final Creator<Donation> CREATOR = new Creator<Donation>() {
        @Override
        public Donation createFromParcel(Parcel in) {
            return new Donation(in);
        }

        @Override
        public Donation[] newArray(int size) {
            return new Donation[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeDouble(amount);
        parcel.writeInt(paymentMethod);
        parcel.writeString(donation_date);
    }


    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod(){
        return (this.paymentMethod == 0 ? "PayPal": "Credit Card");
    }

    public String getDonation_date() {
        return donation_date;
    }
}
