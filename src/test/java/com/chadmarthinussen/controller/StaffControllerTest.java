package com.chadmarthinussen.controller;

import com.chadmarthinussen.Domain.UserlType.Staff;
import com.chadmarthinussen.factory.StaffFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class StaffControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/staff";

    @Test
    public void testGetAllStaffs() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetStaffByID() {
        Staff staff = restTemplate.getForObject(baseURL + "/staff/1", Staff.class);
        System.out.println(staff.getStaffID());
        assertNotNull(staff);
    }

    @Test
    public void testCreateStaff() {
        Staff staff = StaffFactory.getStaff(Name.name(), "7000001");
        ResponseEntity<Staff> postResponse = restTemplate.postForEntity(baseURL + "/create", staff, Staff.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateStaff() {
        int id = 1;
        Staff staff = restTemplate.getForObject(baseURL + "/staff/" + id, Staff.class);

        restTemplate.put(baseURL + "/staffs/" + id, staff);
        Staff updatedStaff = restTemplate.getForObject(baseURL + "/Staff/" + id, Staff.class);
        assertNotNull(updatedStaff);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Staff staff = restTemplate.getForObject(baseURL + "/staffs/" + id, Staff.class);
        assertNotNull(staff);
        restTemplate.delete(baseURL + "/staffs/" + id);
        try {
            staff = restTemplate.getForObject(baseURL + "/staffs/" + id, Staff.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}