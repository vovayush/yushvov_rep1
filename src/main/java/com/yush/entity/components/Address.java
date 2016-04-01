package com.yush.entity.components;


import com.yush.entity.SceletonEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address extends SceletonEntity {

    @Column(name = "country")
    private String country;

    @Column(name = "region")
    private String region;

    @Column(name = "raion")
    private String raion;

    @Column(name = "locality")
    private String locality;

    @Column(name = "streetname")
    private String streetName;

    @Column(name = "buildnumber")
    private String number;

    @Column(name = "apartment")
    private String apartment;

    @Column(name = "advancedinfo")
    private String advanced;

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", raion='" + raion + '\'' +
                ", locality='" + locality + '\'' +
                ", streetName='" + streetName + '\'' +
                ", number='" + number + '\'' +
                ", apartment='" + apartment + '\'' +
                ", advanced='" + advanced + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRaion() {
        return raion;
    }

    public void setRaion(String raion) {
        this.raion = raion;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getAdvanced() {
        return advanced;
    }

    public void setAdvanced(String advanced) {
        this.advanced = advanced;
    }
}
