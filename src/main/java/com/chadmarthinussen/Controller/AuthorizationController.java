package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.AccessTypes.Authorization;
import com.chadmarthinussen.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/authorization")
    public class AuthorizationController {
        private final AuthorizationService authorizationService;

        public AuthorizationController(@Qualifier("AutorizationServiceImpl") AuthorizationService authorizationService) {
            this.authorizationService = authorizationService;
        }

        @PostMapping("/create")
        @ResponseBody
        public Authorization create(Authorization authorization) {
            return authorizationService.create(authorization);
        }

        @PostMapping("/update")
        @ResponseBody
        public Authorization update(Authorization authorization) {
            return authorizationService.update(authorization);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public Authorization read(@PathVariable String id) {
            return authorizationService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            authorizationService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<Authorization> getAll() {
            return authorizationService.getAll();
        }
    }