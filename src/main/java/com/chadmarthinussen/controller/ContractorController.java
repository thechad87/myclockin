package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.UserlType.Contractor;
import com.chadmarthinussen.services.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/contractor")
public class ContractorController {

    @Autowired
    private final ContractorService contractorService;

    public ContractorController(@Qualifier("ContractorServiceImpl") ContractorService contractorService) {
        this.contractorService = contractorService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contractor create(Contractor contractor) {
        return contractorService.create(contractor);
    }

    @PostMapping(value= "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contractor update(Contractor contractor) {
        return contractorService.update(contractor);
    }

    @GetMapping(value ="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contractor read(@PathVariable String id) {
        return contractorService.read(id);
    }

    @GetMapping(value ="/delete/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        contractorService.delete(id);
    }

    @GetMapping(value= "/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <Contractor> getAll() {
        return contractorService.getAll();
    }
}