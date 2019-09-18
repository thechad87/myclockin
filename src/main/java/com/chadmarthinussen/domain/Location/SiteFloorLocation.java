package com.chadmarthinussen.domain.Location;


import org.springframework.boot.autoconfigure.domain.EntityScan;

;import javax.persistence.Id;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */

@EntityScan
public class SiteFloorLocation {

    @Id
    private String siteFloorLocationID;
    private String siteFloorLocationEntrance;
    private String buildingLocation;
    private String floorNumber;

    public SiteFloorLocation(Builder builder) {
        this.siteFloorLocationID = builder.siteFloorLocationID;
        this.siteFloorLocationEntrance = builder.siteFloorLocationEntrance;
        this.buildingLocation = builder.buildingLocation;
        this.floorNumber = builder.floorNumber;
    }

    public String getSiteFloorLocationID() {
        return siteFloorLocationID;
    }

    public String getBuildingLocation() {
        return buildingLocation;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public String getSiteFloorLocationEntrance() {
        return siteFloorLocationEntrance;
    }

    @Override
    public String toString() {
        return "SiteFloorLocation{" +
                "siteFloorLocationID='" + siteFloorLocationID + '\'' +
                ", siteFloorLocationEntrance='" + siteFloorLocationEntrance + '\'' +
                ", buildingLocation='" + buildingLocation + '\'' +
                ", floorNumber='" + floorNumber + '\'' +
                '}';
    }

    public static class Builder{

        private String siteFloorLocationID;
        private String siteFloorLocationEntrance;
        private String buildingLocation;
        private String floorNumber;

        public Builder siteFloorLocationID(String siteFloorLocationID) {
            this.siteFloorLocationID = siteFloorLocationID;
            return this;
        }

        public Builder siteFloorLocationEntrance(String siteFloorLocationEntrance) {
            this.siteFloorLocationEntrance = siteFloorLocationEntrance;
            return this;
        }

        public Builder buildingLocation(String buildingLocation){
            this.buildingLocation = buildingLocation;
            return this;
        }

        public Builder floorNumber(String floorNumber){
            this.floorNumber = floorNumber;
            return this;
        }

        public Builder copy(SiteFloorLocation siteFloorLocation ){
            this.siteFloorLocationID = siteFloorLocation.siteFloorLocationID;
            this.siteFloorLocationEntrance = siteFloorLocation.siteFloorLocationEntrance;
            this.buildingLocation = siteFloorLocation.buildingLocation;
            this.floorNumber = siteFloorLocation.floorNumber;
            return this;
        }

        public SiteFloorLocation build() {
            return new SiteFloorLocation(this);
        }
    }

}

