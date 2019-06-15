package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.Location.SiteFloorLocation;
import com.chadmarthinussen.services.SiteFloorLocationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/siteFloorLocation")
    public class SiteFloorLocationController {
        private final SiteFloorLocationService siteFloorLocationService;

        public SiteFloorLocationController(@Qualifier("SiteFloorLocationServiceImpl") SiteFloorLocationService siteFloorLocationService) {
            this.siteFloorLocationService = siteFloorLocationService;
        }

        @PostMapping("/create")
        @ResponseBody
        public SiteFloorLocation create(SiteFloorLocation siteFloorLocation) {
            return siteFloorLocationService.create(siteFloorLocation);
        }

        @PostMapping("/update")
        @ResponseBody
        public SiteFloorLocation update(SiteFloorLocation siteFloorLocation) {
            return siteFloorLocationService.update(siteFloorLocation);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public SiteFloorLocation read(@PathVariable String id) {
            return siteFloorLocationService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            siteFloorLocationService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<SiteFloorLocation> getAll() {
            return siteFloorLocationService.getAll();
        }
    }