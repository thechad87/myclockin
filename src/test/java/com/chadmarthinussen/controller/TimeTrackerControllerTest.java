package com.chadmarthinussen.controller;

import com.chadmarthinussen.Domain.AccessTypes.Time;
import com.chadmarthinussen.Domain.TimeAndDateStamp.TimeTracker;
import com.chadmarthinussen.factory.TimeFactory;
import com.chadmarthinussen.factory.TimeTrackerFactory;
import org.junit.Ignore;
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
public class TimeTrackerControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/timeTracker";

    @Test
    public void testGetAllTimeTrackers() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetTimeTrackerByID() {
        TimeTracker timeTracker = restTemplate.getForObject(baseURL + "/timeTracker/1", TimeTracker.class);
        System.out.println(timeTracker.getTimeTrackerID());
        assertNotNull(timeTracker);
    }

    @Test
    @Ignore
    public void testCreateTimeTracker() {
//        Time time = TimeFactory.getTime("CL01", "09", "50", "08");
        TimeTracker timeTracker = TimeTrackerFactory.getTimeTracker("Clock01", true);
        ResponseEntity<TimeTracker> postResponse = restTemplate.postForEntity(baseURL + "/create", timeTracker, TimeTracker.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateTimeTracker() {
        int id = 1;
        TimeTracker timeTracker = restTemplate.getForObject(baseURL + "/timeTracker/" + id, TimeTracker.class);

        restTemplate.put(baseURL + "/timeTrackers/" + id, timeTracker);
        TimeTracker updatedTimeTracker = restTemplate.getForObject(baseURL + "/TimeTracker/" + id, TimeTracker.class);
        assertNotNull(updatedTimeTracker);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        TimeTracker timeTracker = restTemplate.getForObject(baseURL + "/timeTrackers/" + id, TimeTracker.class);
        assertNotNull(timeTracker);
        restTemplate.delete(baseURL + "/timeTrackers/" + id);
        try {
            timeTracker = restTemplate.getForObject(baseURL + "/timeTrackers/" + id, TimeTracker.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}