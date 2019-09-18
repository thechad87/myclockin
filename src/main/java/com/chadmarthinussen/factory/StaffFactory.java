package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.PersonalDetails.Name;
import com.chadmarthinussen.domain.UserlType.Staff;

/**
 * Created by ChadMarthinussen2 on 2019/04/10.
 * student number : 208031197
 *
 */

public class StaffFactory {

    //double check about the Name name(composite class is added to the builder)
    public static Staff buildStaff(Name name, String staffID){
        return new Staff.Builder().name(name).staffID(staffID).build();
    }
}
