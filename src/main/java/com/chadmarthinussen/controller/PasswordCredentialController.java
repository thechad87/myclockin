package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.AccessTypes.PasswordCredential;
import com.chadmarthinussen.services.PasswordCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/passwordCredential")
public class PasswordCredentialController {

    @Autowired
    private final PasswordCredentialService passwordCredentialService;

    public PasswordCredentialController(@Qualifier("PasswordCredentialServiceImpl") PasswordCredentialService passwordCredentialService) {
        this.passwordCredentialService = passwordCredentialService;
    }

    @PostMapping(value ="/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public PasswordCredential create(PasswordCredential passwordCredential) {
        return passwordCredentialService.create(passwordCredential);
    }

    @PostMapping(value ="/update" , produces = MediaType.APPLICATION_JSON_VALUE)
    public PasswordCredential update(PasswordCredential passwordCredential) {
        return passwordCredentialService.update(passwordCredential);
    }

    @GetMapping(value ="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PasswordCredential read(@PathVariable String id) {
        return passwordCredentialService.read(id);
    }

    @GetMapping(value ="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        passwordCredentialService.delete(id);
    }

    @GetMapping(value ="/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <PasswordCredential> getAll() {
        return passwordCredentialService.getAll();
    }
}