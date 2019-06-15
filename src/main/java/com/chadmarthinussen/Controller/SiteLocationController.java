package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.Location.SiteLocation;
import com.chadmarthinussen.services.SiteLocationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/siteLocation")
    public class SiteLocationController {
        private final SiteLocationService siteLocationService;

        public SiteLocationController(@Qualifier("SiteLocationServiceImpl") SiteLocationService siteLocationService) {
            this.siteLocationService = siteLocationService;
        }

        @PostMapping("/create")
        @ResponseBody
        public SiteLocation create(SiteLocation siteLocation) {
            return siteLocationService.create(siteLocation);
        }

        @PostMapping("/update")
        @ResponseBody
        public SiteLocation update(SiteLocation siteLocation) {
            return siteLocationService.update(siteLocation);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public SiteLocation read(@PathVariable String id) {
            return siteLocationService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            siteLocationService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<SiteLocation> getAll() {
            return siteLocationService.getAll();
        }
    }