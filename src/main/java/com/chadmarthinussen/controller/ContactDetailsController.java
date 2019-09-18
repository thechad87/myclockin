package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.PersonalDetails.ContactDetails;
import com.chadmarthinussen.services.ContactDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/contactDetails")
public class ContactDetailsController {

    @Autowired
    private final ContactDetailsService contactDetailsService;

    public ContactDetailsController(@Qualifier("ContactDetailsServiceImpl") ContactDetailsService contactDetailsService) {
        this.contactDetailsService = contactDetailsService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ContactDetails create(ContactDetails contactDetails) {
        return contactDetailsService.create(contactDetails);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ContactDetails update(ContactDetails contactDetails) {
        return contactDetailsService.update(contactDetails);
    }

    @GetMapping(value ="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ContactDetails read(@PathVariable String id) {
        return contactDetailsService.read(id);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        contactDetailsService.delete(id);
    }

    @GetMapping(value= "/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <ContactDetails> getAll() {
        return contactDetailsService.getAll();
    }
}