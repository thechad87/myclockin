package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.UserlType.Intern;
import com.chadmarthinussen.services.InternService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/Intern")
    public class InternController {
        private final InternService internService;

        public InternController(@Qualifier("InternServiceImpl") InternService internService) {
            this.internService = internService;
        }

        @PostMapping("/create")
        @ResponseBody
        public Intern create(Intern intern) {
            return internService.create(intern);
        }

        @PostMapping("/update")
        @ResponseBody
        public Intern update(Intern intern) {
            return internService.update(intern);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public Intern read(@PathVariable String id) {
            return internService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            internService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<Intern> getAll() {
            return internService.getAll();
        }
    }