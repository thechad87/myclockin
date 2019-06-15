package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.Location.SiteLocation;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
public class SiteLocationFactory {

    //double check about the Name name(composite class is added to the builder)
    public static SiteLocation buildSiteLocation(String siteLocationID, String streetNumber, String streetsName, String city, String town, String postalCode){
        return new SiteLocation.Builder().sitelocationID(siteLocationID).streetNumber(streetNumber).streetsName(streetsName).city(city).town(town).postalCode(postalCode).build();
    }
}
