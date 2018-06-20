package com.aviya.setlocation;

import android.app.Notification;
import android.location.Location;

public class Place
{
    private String name;
    private Location location;
    private double radius;
    private boolean isSilent;
    private String msg;
    private boolean ifRecord;

    public Place(String name,Location location, double radius,boolean isSilent,boolean ifRecord){
        this.name= name;
        this.location=location;
        this.radius=radius;
        this.isSilent=isSilent;
        this.msg="message";
        this.ifRecord=ifRecord;
}

    public boolean isIfRecord() {
        return ifRecord;
    }

    public void setIfRecord(boolean ifRecord) {
        this.ifRecord = ifRecord;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isSilent() {
        return isSilent;
    }

    public void setSilent(boolean silent) {
        isSilent = silent;
    }
}
