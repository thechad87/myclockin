package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.PersonalDetails.ContactDetails;
import com.chadmarthinussen.repository.ContactDetailsRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@Repository("ContactDetailsRepositoryImpl")
public class ContactDetailsRepositoryImpl implements ContactDetailsRepository {

    private static ContactDetailsRepositoryImpl repository = null;
    private Set<ContactDetails> contactDetailss;

    private ContactDetailsRepositoryImpl(){
        this.contactDetailss = new HashSet<>();
    }

    private ContactDetails findContactDetails(String contactDetailsID) {
        return this.contactDetailss.stream()
                .filter(contactDetails -> contactDetails.getContactDetailsID().trim().equals(contactDetailsID))
                .findAny()
                .orElse(null);
    }

    public static ContactDetailsRepositoryImpl getRepository(){
        if (repository == null) repository = new ContactDetailsRepositoryImpl();
        return repository;
    }


    public ContactDetails create(ContactDetails contactDetails){
        this.contactDetailss.add(contactDetails);
        return contactDetails;
    }

    public ContactDetails read(final String contactDetailsID){
        ContactDetails contactDetails = findContactDetails(contactDetailsID);
        return contactDetails;
    }

    public void delete(String contactDetailsID) {
        ContactDetails contactDetails = findContactDetails(contactDetailsID);
        if (contactDetails != null) this.contactDetailss.remove(contactDetails);
    }

    public ContactDetails update(ContactDetails contactDetails){
        ContactDetails toDelete = findContactDetails(contactDetails.getContactDetailsID());
        if(toDelete != null) {
            this.contactDetailss.remove(toDelete);
            return create(contactDetails);
        }
        return null;
    }

    public Set<ContactDetails> getAll(){
        return this.contactDetailss;
    }
}