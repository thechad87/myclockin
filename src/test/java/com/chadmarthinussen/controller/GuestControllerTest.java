package com.chadmarthinussen.controller;

import com.chadmarthinussen.Domain.UserlType.Guest;
import com.chadmarthinussen.factory.GuestFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class GuestControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/guest";

    @Test
    public void testGetAllGuests() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetGuestByID() {
        Guest guest = restTemplate.getForObject(baseURL + "/guest/1", Guest.class);
        System.out.println(guest.getGuestAssignedID());
        assertNotNull(guest);
    }

    @Test
    public void testCreateGuest() {
        Guest guest = GuestFactory.getGuest("Amazon", "007", "James Bond", "072000007");
        ResponseEntity<Guest> postResponse = restTemplate.postForEntity(baseURL + "/create", guest, Guest.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateGuest() {
        int id = 1;
        Guest guest = restTemplate.getForObject(baseURL + "/guest/" + id, Guest.class);

        restTemplate.put(baseURL + "/guests/" + id, guest);
        Guest updatedGuest = restTemplate.getForObject(baseURL + "/Guest/" + id, Guest.class);
        assertNotNull(updatedGuest);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Guest guest = restTemplate.getForObject(baseURL + "/guests/" + id, Guest.class);
        assertNotNull(guest);
        restTemplate.delete(baseURL + "/guests/" + id);
        try {
            guest = restTemplate.getForObject(baseURL + "/guests/" + id, Guest.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}