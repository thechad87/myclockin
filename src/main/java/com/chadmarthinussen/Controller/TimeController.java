package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.AccessTypes.Time;
import com.chadmarthinussen.services.TimeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/staff")
    public class TimeController {
        private final TimeService timeService;

        public TimeController(@Qualifier("TimeServiceImpl") TimeService timeService) {
            this.timeService = timeService;
        }

        @PostMapping("/create")
        @ResponseBody
        public Time create(Time time) {
            return timeService.create(time);
        }

        @PostMapping("/update")
        @ResponseBody
        public Time update(Time time) {
            return timeService.update(time);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public Time read(@PathVariable String id) {
            return timeService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            timeService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<Time> getAll() {
            return timeService.getAll();
        }
    }