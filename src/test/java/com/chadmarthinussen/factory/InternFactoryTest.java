package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.UserlType.Intern;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/23.
 */
public class InternFactoryTest {

    @Test
    public void getIntern(){

        boolean ifIntern = true;
        long interID = 1567998875;
        Intern one = InternFactory.getIntern(ifIntern, interID);
        Assert.assertEquals(interID, one.getInternID());

    }

}

//    private boolean isIntern;
//    private long internID;