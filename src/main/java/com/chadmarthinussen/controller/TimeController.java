package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.AccessTypes.Time;
import com.chadmarthinussen.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/time")
public class TimeController {

    @Autowired
    private final TimeService timeService;

    public TimeController(@Qualifier("TimeServiceImpl") TimeService timeService) {
        this.timeService = timeService;
    }

    @PostMapping(value ="/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Time create(Time time) {
        return timeService.create(time);
    }

    @PostMapping(value ="/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Time update(Time time) {
        return timeService.update(time);
    }

    @GetMapping(value ="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Time read(@PathVariable String id) {
        return timeService.read(id);
    }

    @GetMapping(value= "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        timeService.delete(id);
    }

    @GetMapping(value="/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <Time> getAll() {
        return timeService.getAll();
    }
}