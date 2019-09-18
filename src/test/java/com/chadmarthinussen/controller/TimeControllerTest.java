package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.AccessTypes.Time;
import com.chadmarthinussen.factory.TimeFactory;
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
public class TimeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/clockin/time";

    @Test
    public void testGetAllTimes() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetTimeByID() {
        Time time = restTemplate.getForObject(baseURL + "/time/1", Time.class);
        System.out.println(time.getTimeID());
        assertNotNull(time);
    }

    @Test
    public void testCreateTime() {
        Time time = TimeFactory.buildTime("234", "01", "06", "12");
        ResponseEntity<Time> postResponse = restTemplate.postForEntity(baseURL + "/create", time, Time.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateTime() {
        int id = 1;
        Time time = restTemplate.getForObject(baseURL + "/time/" + id, Time.class);

        restTemplate.put(baseURL + "/times/" + id, time);
        Time updatedTime = restTemplate.getForObject(baseURL + "/Time/" + id, Time.class);
        assertNotNull(updatedTime);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Time time = restTemplate.getForObject(baseURL + "/times/" + id, Time.class);
        assertNotNull(time);
        restTemplate.delete(baseURL + "/times/" + id);
        try {
            time = restTemplate.getForObject(baseURL + "/times/" + id, Time.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}