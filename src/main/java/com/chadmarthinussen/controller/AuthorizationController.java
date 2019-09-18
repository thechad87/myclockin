package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.AccessTypes.Authorization;
import com.chadmarthinussen.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/authorization")
public class AuthorizationController {

    @Autowired
    private final AuthorizationService authorizationService;

    public AuthorizationController(@Qualifier("AuthorizationServiceImpl") AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Authorization create(Authorization authorization) {
        return authorizationService.create(authorization);
    }

    @PostMapping(value ="/update" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Authorization update(Authorization authorization) {
        return authorizationService.update(authorization);
    }

    @GetMapping(value ="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Authorization read(@PathVariable String id) {
        return authorizationService.read(id);
    }

    @GetMapping(value ="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        authorizationService.delete(id);
    }

    @GetMapping(value = "/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <Authorization> getAll() {
        return authorizationService.getAll();
    }
}