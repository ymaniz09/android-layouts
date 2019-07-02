package com.github.ymaniz09.androidlayouts.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class Trip implements Parcelable {

    private final String mPlace;
    private final String mImage;
    private final int mDays;
    private final BigDecimal mValue;

    public Trip(String place, String image, int days, BigDecimal value) {
        this.mPlace = place;
        this.mImage = image;
        this.mDays = days;
        this.mValue = value;
    }

    private Trip(Parcel parcel) {
        this.mPlace = parcel.readString();
        this.mImage = parcel.readString();
        this.mDays = parcel.readInt();
        this.mValue = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
    }

    public String getPlace() {
        return mPlace;
    }

    public String getImage() {
        return mImage;
    }

    public int getDays() {
        return mDays;
    }

    public BigDecimal getValue() {
        return mValue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mPlace);
        dest.writeString(mImage);
        dest.writeInt(mDays);
        dest.writeValue(mValue);
    }

    public static final Creator<Trip> CREATOR = new Creator<Trip>() {
        @Override
        public Trip createFromParcel(Parcel in) {
            return new Trip(in);
        }

        @Override
        public Trip[] newArray(int size) {
            return new Trip[size];
        }
    };
}
