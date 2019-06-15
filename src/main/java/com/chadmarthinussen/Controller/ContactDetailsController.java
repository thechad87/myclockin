package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.PersonalDetails.ContactDetails;
import com.chadmarthinussen.services.ContactDetailsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/contactDetails")
    public class ContactDetailsController {
        private final ContactDetailsService contactDetailsService;

        public ContactDetailsController(@Qualifier("ContactDetailsServiceImpl") ContactDetailsService contactDetailsService) {
            this.contactDetailsService = contactDetailsService;
        }

        @PostMapping("/create")
        @ResponseBody
        public ContactDetails create(ContactDetails contactDetails) {
            return contactDetailsService.create(contactDetails);
        }

        @PostMapping("/update")
        @ResponseBody
        public ContactDetails update(ContactDetails contactDetails) {
            return contactDetailsService.update(contactDetails);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public ContactDetails read(@PathVariable String id) {
            return contactDetailsService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            contactDetailsService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<ContactDetails> getAll() {
            return contactDetailsService.getAll();
        }
    }