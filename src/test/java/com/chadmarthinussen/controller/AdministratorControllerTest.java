package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.UserlType.Administrator;
import com.chadmarthinussen.factory.AdministratorFactory;
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
public class AdministratorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/clockin/administrator";

    @Test
    public void testGetAllAdministrators() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity <String> entity = new HttpEntity <String>(null, headers);
        ResponseEntity <String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetAdministratorById() {
        Administrator administrator = restTemplate.getForObject(baseURL + "/administrator/1", Administrator.class);
        System.out.println(administrator.getAdministratorID());
        assertNotNull(administrator);
    }

    @Test
    public void testCreateAdministrator() {
        Administrator administrator = AdministratorFactory.buildAdministrator("#00166F", true, true);
        ResponseEntity <Administrator> postResponse = restTemplate.postForEntity(baseURL + "/create", administrator, Administrator.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateAdministrator() {
        int id = 1;
        Administrator administrator = restTemplate.getForObject(baseURL + "/administrator/" + id, Administrator.class);

        restTemplate.put(baseURL + "/administrators/" + id, administrator);
        Administrator updatedAdministrator = restTemplate.getForObject(baseURL + "/Administrator/" + id, Administrator.class);
        assertNotNull(updatedAdministrator);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Administrator administrator = restTemplate.getForObject(baseURL + "/administrators/" + id, Administrator.class);
        assertNotNull(administrator);
        restTemplate.delete(baseURL + "/administrators/" + id);
        try {
            administrator = restTemplate.getForObject(baseURL + "/administrators/" + id, Administrator.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
