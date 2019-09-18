package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.TimeAndDateStamp.DateTracker;
import com.chadmarthinussen.services.DateTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/dateTracker")
public class DateTrackerController {

    @Autowired
    private final DateTrackerService dateTrackerService;

    public DateTrackerController(@Qualifier("DateTrackerServiceImpl") DateTrackerService dateTrackerService) {
        this.dateTrackerService = dateTrackerService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public DateTracker create(DateTracker dateTracker) {
        return dateTrackerService.create(dateTracker);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public DateTracker update(DateTracker dateTracker) {
        return dateTrackerService.update(dateTracker);
    }

    @GetMapping(value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DateTracker read(@PathVariable String id) {
        return dateTrackerService.read(id);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        dateTrackerService.delete(id);
    }

    @GetMapping(value= "/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <DateTracker> getAll() {
        return dateTrackerService.getAll();
    }
}