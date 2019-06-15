package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.AccessTypes.Date;
import com.chadmarthinussen.services.DateService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/date")
    public class DateController {
        private final DateService dateService;

        public DateController(@Qualifier("DateServiceImpl") DateService dateService) {
            this.dateService = dateService;
        }

        @PostMapping("/create")
        @ResponseBody
        public Date create(Date date) {
            return dateService.create(date);
        }

        @PostMapping("/update")
        @ResponseBody
        public Date update(Date date) {
            return dateService.update(date);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public Date read(@PathVariable String id) {
            return dateService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            dateService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<Date> getAll() {
            return dateService.getAll();
        }
    }