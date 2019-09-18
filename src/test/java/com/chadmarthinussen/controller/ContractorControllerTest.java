package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.UserlType.Contractor;
import com.chadmarthinussen.factory.ContractorFactory;
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
public class ContractorControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/clockin/contractor";

    @Test
    public void testGetAllContractors() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity <String> entity = new HttpEntity <String>(null, headers);
        ResponseEntity <String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetContractorByID() {
        Contractor contractor = restTemplate.getForObject(baseURL + "/contractor/1", Contractor.class);
        System.out.println(contractor.getContractorID());
        assertNotNull(contractor);
    }

    @Test
    public void testCreateContractor() {
        Contractor contractor = ContractorFactory.buildContractor(true, "12", "C0001");
        ResponseEntity <Contractor> postResponse = restTemplate.postForEntity(baseURL + "/create", contractor, Contractor.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateContractor() {
        int id = 1;
        Contractor contractor = restTemplate.getForObject(baseURL + "/contractor/" + id, Contractor.class);

        restTemplate.put(baseURL + "/contractors/" + id, contractor);
        Contractor updatedContractor = restTemplate.getForObject(baseURL + "/Contractor/" + id, Contractor.class);
        assertNotNull(updatedContractor);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Contractor contractor = restTemplate.getForObject(baseURL + "/contractors/" + id, Contractor.class);
        assertNotNull(contractor);
        restTemplate.delete(baseURL + "/contractors/" + id);
        try {
            contractor = restTemplate.getForObject(baseURL + "/contractors/" + id, Contractor.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
