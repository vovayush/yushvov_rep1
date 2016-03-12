package com.yush.entity.components;


public class Address {
    private Integer id;
    private String country;
    private String region;
    private String raion;
    private String locality;
    private String streetName;
    private String number;
    private String apartment;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
