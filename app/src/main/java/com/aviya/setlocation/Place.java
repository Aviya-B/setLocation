package com.aviya.setlocation;

import android.app.Notification;
import android.location.Location;

public class Place
{
    private String name;
    private int lat,lng;
    private Settings settings;

    public Place(String name,int lat, int lng,Settings settings){
        this.name= name;
        this.lat = lat;
        this.lng = lng;
        this.settings=settings;
        //this.ifRecord=ifRecord;
}

//    public boolean isIfRecord() {
//        return ifRecord;
//    }
//
//    public void setIfRecord(boolean ifRecord) {
//        this.ifRecord = ifRecord;
//    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
}
