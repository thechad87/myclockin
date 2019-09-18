package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.ResponseObject;
import com.chadmarthinussen.domain.UserlType.Guest;
import com.chadmarthinussen.factory.GuestFactory;
import com.chadmarthinussen.factory.ResponseObjectFactory;
import com.chadmarthinussen.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/guest")
public class GuestController {

    @Autowired
    private final GuestService guestService;

    public GuestController(@Qualifier("GuestServiceImpl") GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping(value = "/create/{guest}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createGender(@PathVariable String guest) {
        System.out.println("Entered Value: " + guest);
        ResponseObject responseObj = ResponseObjectFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Gender created!");
        Guest savedGuest;
        if (guest == null || guest.trim().isEmpty() || guest.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide a guest!");
        } else {
            savedGuest = guestService.retrieveByDesc(guest);
            if (savedGuest != null) {
                responseObj.setResponseDescription("Gender already exist!");
            } else {
                savedGuest = GuestFactory.buildGuest(guest, " ", " "," ");
                savedGuest = guestService.create(savedGuest);
            }
            responseObj.setResponse(savedGuest);
        }
        return ResponseEntity.ok(responseObj);
    }
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObject responseObj = ResponseObjectFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        Set <Guest> genders = guestService.getAll();
        responseObj.setResponse(genders);
        return ResponseEntity.ok(responseObj);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Guest update(Guest guest) {
        return guestService.update(guest);
    }

    @GetMapping(value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Guest read(@PathVariable String id) {
        return guestService.read(id);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        guestService.delete(id);
    }

}

//
//    @GetMapping(value ="/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Set <Guest> getAll() {
//        return guestService.getAll();
//    }

//    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Guest create(Guest guest) {
//        return guestService.create(guest);
//    }
//