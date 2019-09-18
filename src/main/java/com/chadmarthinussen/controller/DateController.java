package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.AccessTypes.Date;
import com.chadmarthinussen.services.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/date")
public class DateController {

    @Autowired
    private final DateService dateService;

    public DateController(@Qualifier("DateServiceImpl") DateService dateService) {
        this.dateService = dateService;
    }

    @PostMapping(value="/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Date create(Date date) {
        return dateService.create(date);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Date update(Date date) {
        return dateService.update(date);
    }

    @GetMapping(value= "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Date read(@PathVariable String id) {
        return dateService.read(id);
    }

    @GetMapping(value= "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        dateService.delete(id);
    }

    @GetMapping(value = "/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <Date> getAll() {
        return dateService.getAll();
    }
}