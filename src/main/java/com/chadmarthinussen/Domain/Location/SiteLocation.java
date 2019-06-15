package com.chadmarthinussen.Domain.Location;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */

@EntityScan
public class SiteLocation {

    private String siteLocationID;
    private String streetNumber;
    private String streetsName;
    private String city;
    private String town;
    private String postalCode;

    public SiteLocation() {
    }

    public SiteLocation(Builder builder) {
        this.siteLocationID = builder.siteLocationID;
        this.streetNumber = builder.streetNumber;
        this.streetsName = builder.streetsName;
        this.city = builder.city;
        this.town = builder.town;
        this.postalCode = builder.postalCode;
    }

    public String getSiteLocationID() {
        return siteLocationID;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetsName() {
        return streetsName;
    }

    public String getCity() {
        return city;
    }

    public String getTown() {
        return town;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "SiteLocation{" +
                "siteLocationID=" + siteLocationID +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetsName='" + streetsName + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }

    public static class Builder{

        private String siteLocationID;
        private String streetNumber;
        private String streetsName;
        private String city;
        private String town;
        private String postalCode;

        public Builder sitelocationID(String siteLocationID) {
            this.siteLocationID = siteLocationID;
            return this;
        }

        public Builder streetNumber(String streetNumber){
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder streetsName(String streetsName){
            this.streetsName = streetsName;
            return this;
        }

        public Builder city(String city){
            this.city = city;
            return this;
        }

        public Builder town(String town){
            this.town = town;
            return this;
        }
        public Builder postalCode(String postalCode){
            this.postalCode = postalCode;
            return this;
        }

        public SiteLocation build() {
            return new SiteLocation(this);
        }

    }
}