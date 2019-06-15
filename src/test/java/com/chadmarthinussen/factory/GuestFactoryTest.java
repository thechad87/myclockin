package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.UserlType.Guest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
public class GuestFactoryTest {

    @Test
    public void getGuest(){

        String organizName = "Java Sun";
        long guestID  = 123456789;
        String fulName = "Joe Barber";
        Guest One = GuestFactory.getGuest(organizName, guestID, fulName, "0730513131");
        System.out.println(One);
        Assert.assertEquals(String.valueOf(guestID), One.getGuestAssignedID());
    }

}


//    private String organizationsName;
//    private long guestAssignedID;
//    private String name;
//    private String contactDetails;