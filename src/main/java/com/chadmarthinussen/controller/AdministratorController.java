package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.ResponseObject;
import com.chadmarthinussen.domain.UserlType.Administrator;
import com.chadmarthinussen.factory.AdministratorFactory;
import com.chadmarthinussen.factory.ResponseObjectFactory;
import com.chadmarthinussen.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by Chad Marthinussen on 2019/06/08.
 */

@RestController
@RequestMapping("clockin/administrator")
public class AdministratorController {

    @Autowired
    @Qualifier("AdministratorServiceImp")
    private AdministratorService administratorService;

    @PostMapping(value = "/create/{administrator}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createAdministrator(@PathVariable String administrator) {
        System.out.println("Entered Value: " + administrator);
        ResponseObject responseObj = ResponseObjectFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Administrator created!");
        Administrator savedAdministrator;
        if (administrator == null || administrator.trim().isEmpty() || administrator.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Users has no admin rights!");
        } else {
            savedAdministrator = administratorService.read(administrator);
            if (savedAdministrator != null) {
                responseObj.setResponseDescription("Gender already exist!");
            } else {
                savedAdministrator = AdministratorFactory.buildAdministrator(administrator, true, true);
                savedAdministrator = administratorService.create(savedAdministrator);
            }
            responseObj.setResponse(savedAdministrator);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObject responseObj = ResponseObjectFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Successful");
        Set <Administrator> admin = administratorService.getAll();
        responseObj.setResponse(admin);
        return ResponseEntity.ok(responseObj);
    }

        @PostMapping("/update")
    public Administrator update(Administrator administrator) {
        return administratorService.update(administrator);
    }

    @GetMapping(value ="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        administratorService.delete(id);

    }

    @GetMapping(value ="/read/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Administrator read(@PathVariable String id) {
        return administratorService.read(id);
    }

    //    @PostMapping(value ="/create", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Administrator create(Administrator administrator) {
//        return service.create(administrator);
//    }
//
//
//    @GetMapping(value = "/read/all" , produces = MediaType.APPLICATION_JSON_VALUE)
//    public Set<Administrator> getAll() {
//        return service.getAll();
//    }
}
