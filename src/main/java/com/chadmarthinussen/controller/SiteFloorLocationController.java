package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.Location.SiteFloorLocation;
import com.chadmarthinussen.services.SiteFloorLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/siteFloorLocation")
public class SiteFloorLocationController {

    @Autowired
    private final SiteFloorLocationService siteFloorLocationService;

    public SiteFloorLocationController(@Qualifier("SiteFloorLocationServiceImpl") SiteFloorLocationService siteFloorLocationService) {
        this.siteFloorLocationService = siteFloorLocationService;
    }

    @PostMapping(value ="/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public SiteFloorLocation create(SiteFloorLocation siteFloorLocation) {
        return siteFloorLocationService.create(siteFloorLocation);
    }

    @PostMapping(value= "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public SiteFloorLocation update(SiteFloorLocation siteFloorLocation) {
        return siteFloorLocationService.update(siteFloorLocation);
    }

    @GetMapping(value= "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SiteFloorLocation read(@PathVariable String id) {
        return siteFloorLocationService.read(id);
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        siteFloorLocationService.delete(id);
    }

    @GetMapping(value = "/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <SiteFloorLocation> getAll() {
        return siteFloorLocationService.getAll();
    }
}