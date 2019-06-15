package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.PersonalDetails.Name;
import com.chadmarthinussen.services.NameService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/Name")
    public class NameController {
        private final NameService nameService;

        public NameController(@Qualifier("NameServiceImpl") NameService nameService) {
            this.nameService = nameService;
        }

        @PostMapping("/create")
        @ResponseBody
        public Name create(Name name) {
            return nameService.create(name);
        }

        @PostMapping("/update")
        @ResponseBody
        public Name update(Name name) {
            return nameService.update(name);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public Name read(@PathVariable String id) {
            return nameService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            nameService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<Name> getAll() {
            return nameService.getAll();
        }
    }