package com.chadmarthinussen.services;

import com.chadmarthinussen.Domain.PersonalDetails.ContactDetails;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface ContactDetailsService extends IService<ContactDetails, String> {
        Set <ContactDetails> getAll();
}
