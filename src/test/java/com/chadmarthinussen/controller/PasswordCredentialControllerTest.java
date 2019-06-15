package com.chadmarthinussen.controller;

import com.chadmarthinussen.Domain.AccessTypes.PasswordCredential;
import com.chadmarthinussen.factory.PasswordCredentialFactory;
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
public class PasswordCredentialControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/passwordCredential";

    @Test
    public void testGetAllPasswordCredentials() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetPasswordCredentialByID() {
        PasswordCredential passwordCredential = restTemplate.getForObject(baseURL + "/passwordCredential/1", PasswordCredential.class);
        System.out.println(passwordCredential.getUserPasswordCredentials());
        assertNotNull(passwordCredential);
    }

    @Test
    public void testCreatePasswordCredential() {
        PasswordCredential passwordCredential = PasswordCredentialFactory.getPasswordCredential("#cput@2019", "joe soap", "joesoap@gmail.com");
        ResponseEntity<PasswordCredential> postResponse = restTemplate.postForEntity(baseURL + "/create", passwordCredential, PasswordCredential.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdatePasswordCredential() {
        int id = 1;
        PasswordCredential passwordCredential = restTemplate.getForObject(baseURL + "/passwordCredential/" + id, PasswordCredential.class);

        restTemplate.put(baseURL + "/passwordCredentials/" + id, passwordCredential);
        PasswordCredential updatedPasswordCredential = restTemplate.getForObject(baseURL + "/PasswordCredential/" + id, PasswordCredential.class);
        assertNotNull(updatedPasswordCredential);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        PasswordCredential passwordCredential = restTemplate.getForObject(baseURL + "/passwordCredentials/" + id, PasswordCredential.class);
        assertNotNull(passwordCredential);
        restTemplate.delete(baseURL + "/passwordCredentials/" + id);
        try {
            passwordCredential = restTemplate.getForObject(baseURL + "/passwordCredentials/" + id, PasswordCredential.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}