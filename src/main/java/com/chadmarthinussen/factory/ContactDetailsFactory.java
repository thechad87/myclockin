package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.PersonalDetails.ContactDetails;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
public class ContactDetailsFactory {


    public static ContactDetails buildContactDetails(String contactDetailsID, String tellPhoneNumber, String cellPhoneNumber, String emailAddress) {
        return new ContactDetails.Builder().contactDetailsID(contactDetailsID).tellPhoneNumber(tellPhoneNumber).cellPhoneNumber(cellPhoneNumber).emailAddress(emailAddress).build();
    }
}

