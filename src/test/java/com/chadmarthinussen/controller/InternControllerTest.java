package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.UserlType.Intern;
import com.chadmarthinussen.factory.InternFactory;
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
public class InternControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/clockin/intern";

    @Test
    public void testGetAllInterns() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity <String> entity = new HttpEntity <String>(null, headers);
        ResponseEntity <String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetInternByID() {
        Intern intern = restTemplate.getForObject(baseURL + "/intern/1", Intern.class);
        System.out.println(intern.getInternID());
        assertNotNull(intern);
    }

    @Test
    public void testCreateIntern() {
        Intern intern = InternFactory.buildIntern(true, "I001");
        ResponseEntity <Intern> postResponse = restTemplate.postForEntity(baseURL + "/create", intern, Intern.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateIntern() {
        int id = 1;
        Intern intern = restTemplate.getForObject(baseURL + "/intern/" + id, Intern.class);

        restTemplate.put(baseURL + "/interns/" + id, intern);
        Intern updatedIntern = restTemplate.getForObject(baseURL + "/Intern/" + id, Intern.class);
        assertNotNull(updatedIntern);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Intern intern = restTemplate.getForObject(baseURL + "/interns/" + id, Intern.class);
        assertNotNull(intern);
        restTemplate.delete(baseURL + "/interns/" + id);
        try {
            intern = restTemplate.getForObject(baseURL + "/interns/" + id, Intern.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}