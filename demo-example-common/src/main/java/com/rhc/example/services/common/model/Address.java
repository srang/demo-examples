package com.rhc.example.services.common.model;

/**
 * Created by srang on 8/15/16.
 */
public class Address {
    private String streetNumber;
    private String aptNum;
    private String city;
    private String state;
    private String zip;

    public Address(String streetNumber, String aptNum, String city, String state, String zip) {
        this.streetNumber = streetNumber;
        this.aptNum = aptNum;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }


    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getAptNum() {
        return aptNum;
    }

    public void setAptNum(String aptNum) {
        this.aptNum = aptNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNumber='" + streetNumber + '\'' +
                ", aptNum='" + aptNum + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
