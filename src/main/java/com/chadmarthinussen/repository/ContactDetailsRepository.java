package com.chadmarthinussen.repository;

import com.chadmarthinussen.domain.PersonalDetails.ContactDetails;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
public interface ContactDetailsRepository extends IRepository<ContactDetails,String> {
    Set<ContactDetails> getAll();
}

