package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.UserlType.Staff;
import com.chadmarthinussen.services.StaffService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/staff")
    public class StaffController {
        private final StaffService staffService;

        public StaffController(@Qualifier("StaffServiceImpl") StaffService staffService) {
            this.staffService = staffService;
        }

        @PostMapping("/create")
        @ResponseBody
        public Staff create(Staff staff) {
            return staffService.create(staff);
        }

        @PostMapping("/update")
        @ResponseBody
        public Staff update(Staff staff) {
            return staffService.update(staff);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public Staff read(@PathVariable String id) {
            return staffService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            staffService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<Staff> getAll() {
            return staffService.getAll();
        }
    }