package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.PersonalDetails.Name;

/**
 * Created by ChadMarthinussen2 on 2019/04/22.
 */
public class NameFactory {


    public static Name buildName(String nameID, String firstName, String middleName, String lastName){
        return new Name.Builder().nameID(nameID).firstName(firstName).middleName(middleName).lastName(lastName).build();

    }
}
