package com.chadmarthinussen.controller;

import com.chadmarthinussen.domain.AccessTypes.TurnStileAccess;
import com.chadmarthinussen.services.TurnStileAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("clockin/turnStileAccess")
public class TurnStileAccessController {

    @Autowired
    private final TurnStileAccessService turnStileAccessService;

    public TurnStileAccessController(@Qualifier("TurnStileAccessServiceImpl") TurnStileAccessService turnStileAccessService) {
        this.turnStileAccessService = turnStileAccessService;
    }

    @PostMapping(value ="/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public TurnStileAccess create(TurnStileAccess turnStileAccess) {
        return turnStileAccessService.create(turnStileAccess);
    }

    @PostMapping(value ="/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public TurnStileAccess update(TurnStileAccess turnStileAccess) {
        return turnStileAccessService.update(turnStileAccess);
    }

    @GetMapping(value ="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TurnStileAccess read(@PathVariable String id) {
        return turnStileAccessService.read(id);
    }

    @GetMapping(value ="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String id) {
        turnStileAccessService.delete(id);
    }

    @GetMapping(value = "/getAll/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set <TurnStileAccess> getAll() {
        return turnStileAccessService.getAll();
    }
}