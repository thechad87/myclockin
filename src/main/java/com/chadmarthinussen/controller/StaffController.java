package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.UserlType.Staff;
import com.chadmarthinussen.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/staff")
public class StaffController {

    @Autowired
    private final StaffService staffService;

    public StaffController(@Qualifier("StaffServiceImpl") StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Staff create(Staff staff) {
        return staffService.create(staff);
    }

    @PostMapping(value ="/update" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Staff update(Staff staff) {
        return staffService.update(staff);
    }

    @GetMapping(value ="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Staff read(@PathVariable String id) {
        return staffService.read(id);
    }

    @GetMapping(value ="/delete/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        staffService.delete(id);
    }

    @GetMapping(value="/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <Staff> getAll() {
        return staffService.getAll();
    }

}