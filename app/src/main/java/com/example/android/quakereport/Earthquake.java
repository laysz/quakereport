package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by startupuser on 2017/10/12.
 */

public class Earthquake {

    private long mDate;

    private String mLocation;

    private double mMagnitude;

    public String getmUrl() {
        return mUrl;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public long getmDate() {

        return mDate;
    }

    private String mUrl;

    public Earthquake (double magnitude, String location, long date, String url) {

        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
        mUrl = url;

    }

}
