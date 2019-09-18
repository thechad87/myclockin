package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.TimeAndDateStamp.TimeTracker;
import com.chadmarthinussen.services.TimeTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/timeTracker")
public class TimeTrackerController {

    @Autowired
    private final TimeTrackerService timeTrackerService;

    public TimeTrackerController(@Qualifier("TimeTrackerServiceImpl") TimeTrackerService timeTrackerService) {
        this.timeTrackerService = timeTrackerService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public TimeTracker create(TimeTracker timeTracker) {
        return timeTrackerService.create(timeTracker);
    }

    @PostMapping(value ="/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public TimeTracker update(TimeTracker timeTracker) {
        return timeTrackerService.update(timeTracker);
    }

    @GetMapping(value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TimeTracker read(@PathVariable String id) {
        return timeTrackerService.read(id);
    }

    @GetMapping(value ="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        timeTrackerService.delete(id);
    }

    @GetMapping(value ="/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <TimeTracker> getAll() {
        return timeTrackerService.getAll();
    }
}