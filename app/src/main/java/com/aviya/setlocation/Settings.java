package com.aviya.setlocation;

public class Settings {

    private double radius;
    private boolean isSilent;
    private String numForSMS;

    public Settings (double radius, boolean isSilent, String numForSMS){

        this.radius=radius;
        this.isSilent=isSilent;
        this.numForSMS=numForSMS;
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

    public String getNumForSMS() {
        return numForSMS;
    }

    public void setNumForSMS(String numForSMS) {
        this.numForSMS = numForSMS;
    }
}
