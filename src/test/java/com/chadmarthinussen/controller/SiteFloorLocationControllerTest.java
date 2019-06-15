package com.chadmarthinussen.controller;

import com.chadmarthinussen.Domain.Location.SiteFloorLocation;
import com.chadmarthinussen.factory.SiteFloorLocationFactory;
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
public class SiteFloorLocationControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/siteFloorLocation";

    @Test
    public void testGetAllSiteFloorLocations() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetSiteFloorLocationByID() {
        SiteFloorLocation siteFloorLocation = restTemplate.getForObject(baseURL + "/siteFloorLocation/1", SiteFloorLocation.class);
        System.out.println(siteFloorLocation.getSiteFloorLocationID());
        assertNotNull(siteFloorLocation);
    }

    @Test
    public void testCreateSiteFloorLocation() {
        SiteFloorLocation siteFloorLocation = SiteFloorLocationFactory.getBuildingFloorLocation("SF001", "4_Dennis_Street", "03", "M1");
        ResponseEntity<SiteFloorLocation> postResponse = restTemplate.postForEntity(baseURL + "/create", siteFloorLocation, SiteFloorLocation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateSiteFloorLocation() {
        int id = 1;
        SiteFloorLocation siteFloorLocation = restTemplate.getForObject(baseURL + "/siteFloorLocation/" + id, SiteFloorLocation.class);

        restTemplate.put(baseURL + "/siteFloorLocations/" + id, siteFloorLocation);
        SiteFloorLocation updatedSiteFloorLocation = restTemplate.getForObject(baseURL + "/SiteFloorLocation/" + id, SiteFloorLocation.class);
        assertNotNull(updatedSiteFloorLocation);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        SiteFloorLocation siteFloorLocation = restTemplate.getForObject(baseURL + "/siteFloorLocations/" + id, SiteFloorLocation.class);
        assertNotNull(siteFloorLocation);
        restTemplate.delete(baseURL + "/siteFloorLocations/" + id);
        try {
            siteFloorLocation = restTemplate.getForObject(baseURL + "/siteFloorLocations/" + id, SiteFloorLocation.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}