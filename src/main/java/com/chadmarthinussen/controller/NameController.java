package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.PersonalDetails.Name;
import com.chadmarthinussen.services.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/name")
public class NameController {

    @Autowired
    private final NameService nameService;

    public NameController(@Qualifier("NameServiceImpl") NameService nameService) {
        this.nameService = nameService;
    }

    @PostMapping(value ="/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Name create(Name name) {
        return nameService.create(name);
    }

    @PostMapping(value ="/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Name update(Name name) {
        return nameService.update(name);
    }

    @GetMapping(value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Name read(@PathVariable String id) {
        return nameService.read(id);
    }

    @GetMapping(value="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        nameService.delete(id);
    }

    @GetMapping(value = "/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <Name> getAll() {
        return nameService.getAll();
    }
}