package com.chadmarthinussen.factory;


import com.chadmarthinussen.domain.UserlType.Guest;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
public class GuestFactory {

        public static Guest buildGuest(String organizationsName,String  guestAssignedID, String fullName, String contactDetails) {
            return new Guest.Builder().organizationsName(organizationsName).guestAssignedID(guestAssignedID).fullName(fullName).contactDetails(contactDetails).build();
        }
}