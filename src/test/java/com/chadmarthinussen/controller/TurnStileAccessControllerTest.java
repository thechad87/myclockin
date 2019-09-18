package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.AccessTypes.Time;
import com.chadmarthinussen.domain.AccessTypes.TurnStileAccess;
import com.chadmarthinussen.factory.TimeFactory;
import com.chadmarthinussen.factory.TurnStileAccessFactory;
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
public class TurnStileAccessControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/clockin/turnStileAccess";

    @Test
    public void testGetAllTurnStileAccesss() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetTurnStileAccessByID() {
        TurnStileAccess turnStileAccess = restTemplate.getForObject(baseURL + "/turnStileAccess/1", TurnStileAccess.class);
        System.out.println(turnStileAccess.getTurnStileAccessID());
        assertNotNull(turnStileAccess);
    }

    @Test
    @Ignore
    public void testCreateTurnStileAccess() {
        Time time = new TimeFactory().buildTime("01", "01","60", "2");
        TurnStileAccess turnStileAccess = TurnStileAccessFactory.buildTurnStileAccess("#001", true , time);
        ResponseEntity<TurnStileAccess> postResponse = restTemplate.postForEntity(baseURL + "/create", turnStileAccess, TurnStileAccess.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateTurnStileAccess() {
        int id = 1;
        TurnStileAccess turnStileAccess = restTemplate.getForObject(baseURL + "/turnStileAccess/" + id, TurnStileAccess.class);

        restTemplate.put(baseURL + "/turnStileAccesss/" + id, turnStileAccess);
        TurnStileAccess updatedTurnStileAccess = restTemplate.getForObject(baseURL + "/TurnStileAccess/" + id, TurnStileAccess.class);
        assertNotNull(updatedTurnStileAccess);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        TurnStileAccess turnStileAccess = restTemplate.getForObject(baseURL + "/turnStileAccesss/" + id, TurnStileAccess.class);
        assertNotNull(turnStileAccess);
        restTemplate.delete(baseURL + "/turnStileAccesss/" + id);
        try {
            turnStileAccess = restTemplate.getForObject(baseURL + "/turnStileAccesss/" + id, TurnStileAccess.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}