package com.chadmarthinussen.controller;

import com.chadmarthinussen.Domain.AccessTypes.Date;
import com.chadmarthinussen.Domain.TimeAndDateStamp.DateTracker;
import com.chadmarthinussen.factory.DateTrackerFactory;
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
public class DateTrackerControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/dateTracker";

    @Test
    public void testGetAllDateTrackers() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetDateTrackerById() {
        DateTracker dateTracker = restTemplate.getForObject(baseURL + "/dateTracker/1", DateTracker.class);
        System.out.println(dateTracker.getDatetrackerID());
        assertNotNull(dateTracker);
    }

    @Test
    public void testCreateDateTracker() {
        DateTracker dateTracker = DateTrackerFactory.getDateTracker("DT001", "TS001" , new Date(date));
        ResponseEntity<DateTracker> postResponse = restTemplate.postForEntity(baseURL + "/create", dateTracker, DateTracker.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test

    public void testUpdateDateTracker() {
        int id = 1;
        DateTracker dateTracker = restTemplate.getForObject(baseURL + "/dateTracker/" + id, DateTracker.class);

        restTemplate.put(baseURL + "/dateTrackers/" + id, dateTracker);
        DateTracker updatedDateTracker = restTemplate.getForObject(baseURL + "/DateTracker/" + id, DateTracker.class);
        assertNotNull(updatedDateTracker);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        DateTracker dateTracker = restTemplate.getForObject(baseURL + "/dateTrackers/" + id, DateTracker.class);
        assertNotNull(dateTracker);
        restTemplate.delete(baseURL + "/dateTrackers/" + id);
        try {
            dateTracker = restTemplate.getForObject(baseURL + "/dateTrackers/" + id, DateTracker.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}