package com.chadmarthinussen.controller;

import com.chadmarthinussen.Domain.PersonalDetails.ContactDetails;
import com.chadmarthinussen.factory.ContactDetailsFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ContactDetailsControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/contactDetails";

    @Test
    public void testGetAllContactDetailss() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetContactDetailsByID() {
        ContactDetails contactDetails = restTemplate.getForObject(baseURL + "/contactDetails/1", ContactDetails.class);
        System.out.println(contactDetails.getTellPhoneNumber());
        assertNotNull(contactDetails);
    }

    @Test
    public void testCreateContactDetails() {
        ContactDetails contactDetails = ContactDetailsFactory.getContactDetails("#001", "021708333", "0825990099", "cmarty@gmail.com");
        ResponseEntity<ContactDetails> postResponse = restTemplate.postForEntity(baseURL + "/create", contactDetails, ContactDetails.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateContactDetails() {
        int id = 1;
        ContactDetails contactDetails = restTemplate.getForObject(baseURL + "/contactDetails/" + id, ContactDetails.class);

        restTemplate.put(baseURL + "/contactDetailss/" + id, contactDetails);
        ContactDetails updatedContactDetails = restTemplate.getForObject(baseURL + "/ContactDetails/" + id, ContactDetails.class);
        assertNotNull(updatedContactDetails);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        ContactDetails contactDetails = restTemplate.getForObject(baseURL + "/contactDetailss/" + id, ContactDetails.class);
        assertNotNull(contactDetails);
        restTemplate.delete(baseURL + "/contactDetailss/" + id);
        try {
            contactDetails = restTemplate.getForObject(baseURL + "/contactDetailss/" + id, ContactDetails.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
