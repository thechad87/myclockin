package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.UserlType.Guest;
import com.chadmarthinussen.services.GuestService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@RestController
@RequestMapping("/guest")
public class GuestController {
    private final GuestService guestService;

    public GuestController(@Qualifier("GuestServiceImpl") GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Guest create(Guest guest) {
        return guestService.create(guest);
    }

    @PostMapping("/update")
    @ResponseBody
    public Guest update(Guest guest) {
        return guestService.update(guest);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Guest read(@PathVariable String id) {
        return guestService.read(id);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        guestService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Guest> getAll() {
        return guestService.getAll();
    }
}