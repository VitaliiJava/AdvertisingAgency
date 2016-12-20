package com.lviv.advertisingagency;

import java.io.Serializable;

/**
 * Created by Vitalik on 26.09.2016.
 */
public class AdvertisingPlatform implements Serializable {
    private OS os;
    private Browser browser;
    private String nameOfPlatform;
    private int countFilesWithAdvertising;
    private int countFilesWithOutadvertising;

    AdvertisingPlatform() {

    }

    public AdvertisingPlatform(OS os, Browser browser, String nameOfPlatform, int countFilesWithAdvertising, int countFilesWithOutadvertising) {
        this.os = os;
        this.browser = browser;
        this.nameOfPlatform = nameOfPlatform;
        this.countFilesWithAdvertising = countFilesWithAdvertising;
        this.countFilesWithOutadvertising = countFilesWithOutadvertising;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdvertisingPlatform)) return false;

        AdvertisingPlatform that = (AdvertisingPlatform) o;

        if (getCountFilesWithAdvertising() != that.getCountFilesWithAdvertising()) return false;
        if (getCountFilesWithOutadvertising() != that.getCountFilesWithOutadvertising()) return false;
        if (getOs() != that.getOs()) return false;
        if (getBrowser() != that.getBrowser()) return false;
        return getNameOfPlatform().equals(that.getNameOfPlatform());

    }

    @Override
    public int hashCode() {
        int result = getOs().hashCode();
        result = 31 * result + getBrowser().hashCode();
        result = 31 * result + getNameOfPlatform().hashCode();
        result = 31 * result + getCountFilesWithAdvertising();
        result = 31 * result + getCountFilesWithOutadvertising();
        return result;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public String getNameOfPlatform() {
        return nameOfPlatform;
    }

    public void setNameOfPlatform(String nameOfPlatform) {
        this.nameOfPlatform = nameOfPlatform;
    }

    public int getCountFilesWithAdvertising() {
        return countFilesWithAdvertising;
    }

    public void setCountFilesWithAdvertising(int countFilesWithAdvertising) {
        this.countFilesWithAdvertising = countFilesWithAdvertising;
    }

    public int getCountFilesWithOutadvertising() {
        return countFilesWithOutadvertising;
    }

    public void setCountFilesWithOutadvertising(int countFilesWithOutadvertising) {
        this.countFilesWithOutadvertising = countFilesWithOutadvertising;
    }

    @Override
    public String toString() {
        return "Advertising Platform {" +
                "Operating System =" + os +
                ", Browser = " + browser +
                ", Name of Platform = '" + nameOfPlatform + '\'' +
                ", Count Files with Reclame = " + countFilesWithAdvertising +
                ", Count Files without Reclame = " + countFilesWithOutadvertising +
                "}\n";
    }
}
