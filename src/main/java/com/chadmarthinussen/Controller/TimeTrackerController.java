package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.TimeAndDateStamp.TimeTracker;
import com.chadmarthinussen.services.TimeTrackerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/timeTracker")
    public class TimeTrackerController {
        private final TimeTrackerService timeTrackerService;

        public TimeTrackerController(@Qualifier("TimeTrackerServiceImpl") TimeTrackerService timeTrackerService) {
            this.timeTrackerService = timeTrackerService;
        }

        @PostMapping("/create")
        @ResponseBody
        public TimeTracker create(TimeTracker timeTracker) {
            return timeTrackerService.create(timeTracker);
        }

        @PostMapping("/update")
        @ResponseBody
        public TimeTracker update(TimeTracker timeTracker) {
            return timeTrackerService.update(timeTracker);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public TimeTracker read(@PathVariable String id) {
            return timeTrackerService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            timeTrackerService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<TimeTracker> getAll() {
            return timeTrackerService.getAll();
        }
    }