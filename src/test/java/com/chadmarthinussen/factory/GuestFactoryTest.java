package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.UserlType.Guest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
public class GuestFactoryTest {

    @Test
    public void getGuest(){

        String organizationName = "Java Sun";
        String guestID  = "123456789";
        String fullName = "Joe Barber";
        String contanctDetails = "123456";
        Guest One = GuestFactory.buildGuest(organizationName, guestID, fullName , contanctDetails);
        System.out.println(One);
        Assert.assertEquals(String.valueOf(guestID), One.getGuestAssignedID());
    }

}


//    private String organizationsName;
//    private long guestAssignedID;
//    private String name;
//    private String contactDetails;