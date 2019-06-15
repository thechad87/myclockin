package com.chadmarthinussen.controller;

import com.chadmarthinussen.Domain.Location.SiteLocation;
import com.chadmarthinussen.factory.SiteLocationFactory;
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
public class SiteLocationControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/siteLocation";

    @Test
    public void testGetAllSiteLocations() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetSiteLocationByID() {
        SiteLocation siteLocation = restTemplate.getForObject(baseURL + "/siteLocation/1", SiteLocation.class);
        System.out.println(siteLocation.getSiteLocationID());
        assertNotNull(siteLocation);
    }

    @Test
    public void testCreateSiteLocation() {
        SiteLocation siteLocation = SiteLocationFactory.getSiteLocation("S1001", "156" , "Edward_Street", "Cape_Town", "Cape_Town", "8000");
        ResponseEntity<SiteLocation> postResponse = restTemplate.postForEntity(baseURL + "/create", siteLocation, SiteLocation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateSiteLocation() {
        int id = 1;
        SiteLocation siteLocation = restTemplate.getForObject(baseURL + "/siteLocation/" + id, SiteLocation.class);

        restTemplate.put(baseURL + "/siteLocations/" + id, siteLocation);
        SiteLocation updatedSiteLocation = restTemplate.getForObject(baseURL + "/SiteLocation/" + id, SiteLocation.class);
        assertNotNull(updatedSiteLocation);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        SiteLocation siteLocation = restTemplate.getForObject(baseURL + "/siteLocations/" + id, SiteLocation.class);
        assertNotNull(siteLocation);
        restTemplate.delete(baseURL + "/siteLocations/" + id);
        try {
            siteLocation = restTemplate.getForObject(baseURL + "/siteLocations/" + id, SiteLocation.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}