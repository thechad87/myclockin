package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.AccessTypes.TurnStileAccess;
import com.chadmarthinussen.services.TurnStileAccessService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/turnStileAccess")
    public class TurnStileAccessController {
        private final TurnStileAccessService turnStileAccessService;

        public TurnStileAccessController(@Qualifier("TurnStileAccessServiceImpl") TurnStileAccessService turnStileAccessService) {
            this.turnStileAccessService = turnStileAccessService;
        }

        @PostMapping("/create")
        @ResponseBody
        public TurnStileAccess create(TurnStileAccess turnStileAccess) {
            return turnStileAccessService.create(turnStileAccess);
        }

        @PostMapping("/update")
        @ResponseBody
        public TurnStileAccess update(TurnStileAccess turnStileAccess) {
            return turnStileAccessService.update(turnStileAccess);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public TurnStileAccess read(@PathVariable String id) {
            return turnStileAccessService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            turnStileAccessService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<TurnStileAccess> getAll() {
            return turnStileAccessService.getAll();
        }
    }