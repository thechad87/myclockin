package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.AccessTypes.Date;
import com.chadmarthinussen.factory.DateFactory;
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
public class DateControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/clockin/date";

    @Test
    public void testGetAllDates() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity <String> entity = new HttpEntity <String>(null, headers);
        ResponseEntity <String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetDateById() {
        Date date = restTemplate.getForObject(baseURL + "/date/1", Date.class);
        System.out.println(date.getDateID());
        assertNotNull(date);
    }

    @Test
    public void testCreateDate() {
        Date date = DateFactory.buildDate("0106201901", "01", "06", "2019");
        ResponseEntity <Date> postResponse = restTemplate.postForEntity(baseURL + "/create", date, Date.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateDate() {
        int id = 1;
        Date date = restTemplate.getForObject(baseURL + "/date/" + id, Date.class);

        restTemplate.put(baseURL + "/dates/" + id, date);
        Date updatedDate = restTemplate.getForObject(baseURL + "/Date/" + id, Date.class);
        assertNotNull(updatedDate);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Date date = restTemplate.getForObject(baseURL + "/dates/" + id, Date.class);
        assertNotNull(date);
        restTemplate.delete(baseURL + "/dates/" + id);
        try {
            date = restTemplate.getForObject(baseURL + "/dates/" + id, Date.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}