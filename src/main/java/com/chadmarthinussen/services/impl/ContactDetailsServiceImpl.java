package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.PersonalDetails.ContactDetails;
import com.chadmarthinussen.repository.ContactDetailsRepository;
import com.chadmarthinussen.repository.impl.ContactDetailsRepositoryImpl;
import com.chadmarthinussen.services.ContactDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Service("ContactDetailsServiceImpl")
//@Service
public class ContactDetailsServiceImpl implements ContactDetailsService {

    private static ContactDetailsServiceImpl service = null;
    @Autowired
    private ContactDetailsRepository repository;

    private ContactDetailsServiceImpl() {
        this.repository = ContactDetailsRepositoryImpl.getRepository();
    }

    public static ContactDetailsServiceImpl getService(){
        if (service == null) service = new ContactDetailsServiceImpl();
        return service;
    }

    @Override
    public ContactDetails create(ContactDetails contactDetails) {
        return this.repository.create(contactDetails);
    }

    @Override
    public ContactDetails update(ContactDetails contactDetails) {
        return this.repository.update(contactDetails);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public ContactDetails read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<ContactDetails> getAll() {
        return this.repository.getAll();
    }
}

