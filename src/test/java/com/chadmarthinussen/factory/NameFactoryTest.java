package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.PersonalDetails.Name;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ChadMarthinussen2 on 2019/04/22.
 */
public class NameFactoryTest {

    @Test
    public void getName() throws Exception {

        String ID = "345";
        String firstName = "joe";
        String middleName = "clean";
        String lastName = "soap";
        Name One = NameFactory.buildName(ID, firstName, middleName, lastName);
        System.out.println(One);
        Assert.assertEquals(firstName, One.getFirstName());
        Assert.assertEquals(middleName, One.getMiddleName());
    }

}
