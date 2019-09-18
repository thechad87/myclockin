package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.UserlType.Intern;
import com.chadmarthinussen.services.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/intern")
public class InternController {

    @Autowired
    private final InternService internService;

    public InternController(@Qualifier("InternServiceImpl") InternService internService) {
        this.internService = internService;
    }

    @PostMapping(value ="/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Intern create(Intern intern) {
        return internService.create(intern);
    }

    @PostMapping(value= "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Intern update(Intern intern) {
        return internService.update(intern);
    }

    @GetMapping(value="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Intern read(@PathVariable String id) {
        return internService.read(id);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        internService.delete(id);
    }

    @GetMapping(value= "/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <Intern> getAll() {
        return internService.getAll();
    }
}