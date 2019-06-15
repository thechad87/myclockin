package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.TimeAndDateStamp.DateTracker;
import com.chadmarthinussen.services.DateTrackerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/dateTracker")
    public class DateTrackerController {
        private final DateTrackerService dateTrackerService;

        public DateTrackerController(@Qualifier("DateTrackerServiceImpl") DateTrackerService dateTrackerService) {
            this.dateTrackerService = dateTrackerService;
        }

        @PostMapping("/create")
        @ResponseBody
        public DateTracker create(DateTracker dateTracker) {
            return dateTrackerService.create(dateTracker);
        }

        @PostMapping("/update")
        @ResponseBody
        public DateTracker update(DateTracker dateTracker) {
            return dateTrackerService.update(dateTracker);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public DateTracker read(@PathVariable String id) {
            return dateTrackerService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            dateTrackerService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<DateTracker> getAll() {
            return dateTrackerService.getAll();
        }
    }