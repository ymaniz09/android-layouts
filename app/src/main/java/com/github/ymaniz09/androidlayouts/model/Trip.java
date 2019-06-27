package com.github.ymaniz09.androidlayouts.model;

import java.math.BigDecimal;

public class Trip {

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

}
