package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.UserlType.Contractor;
import com.chadmarthinussen.services.ContractorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/contractor")
    public class ContractorController {
        private final ContractorService contractorService;

        public ContractorController(@Qualifier("ContractorServiceImpl") ContractorService contractorService) {
            this.contractorService = contractorService;
        }

        @PostMapping("/create")
        @ResponseBody
        public Contractor create(Contractor contractor) {
            return contractorService.create(contractor);
        }

        @PostMapping("/update")
        @ResponseBody
        public Contractor update(Contractor contractor) {
            return contractorService.update(contractor);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public Contractor read(@PathVariable String id) {
            return contractorService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            contractorService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<Contractor> getAll() {
            return contractorService.getAll();
        }
    }