package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.Location.SiteLocation;
import com.chadmarthinussen.services.SiteLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/siteLocation")
public class SiteLocationController {

    @Autowired
    private final SiteLocationService siteLocationService;

    public SiteLocationController(@Qualifier("SiteLocationServiceImpl") SiteLocationService siteLocationService) {
        this.siteLocationService = siteLocationService;
    }

    @PostMapping(value ="/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public SiteLocation create(SiteLocation siteLocation) {
        return siteLocationService.create(siteLocation);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public SiteLocation update(SiteLocation siteLocation) {
        return siteLocationService.update(siteLocation);
    }

    @GetMapping(value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SiteLocation read(@PathVariable String id) {
        return siteLocationService.read(id);
    }

    @GetMapping(value ="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        siteLocationService.delete(id);
    }

    @GetMapping(value ="/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <SiteLocation> getAll() {
        return siteLocationService.getAll();
    }
}