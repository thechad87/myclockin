package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.UserlType.Administrator;
import com.chadmarthinussen.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

@RestController
@RequestMapping("/administrator")
public class AdministratorController {
    @Autowired
    @Qualifier("AdministratorServiceImpl")
    private AdministratorService service;

    @PostMapping("/create")
    @ResponseBody
    public Administrator create(Administrator administrator) {
        return service.create(administrator);
    }

    @PostMapping("/update")
    @ResponseBody
    public Administrator update(Administrator administrator) {
        return service.update(administrator);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Administrator read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Administrator> getAll() {
        return service.getAll();
    }

}
