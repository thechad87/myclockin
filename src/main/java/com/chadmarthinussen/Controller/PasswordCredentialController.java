package com.chadmarthinussen.Controller;

import com.chadmarthinussen.Domain.AccessTypes.PasswordCredential;
import com.chadmarthinussen.services.PasswordCredentialService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
    @RestController
    @RequestMapping("/passwordCredential")
    public class PasswordCredentialController {
        private final PasswordCredentialService passwordCredentialService;

        public PasswordCredentialController(@Qualifier("PasswordCredentialServiceImpl") PasswordCredentialService passwordCredentialService) {
            this.passwordCredentialService = passwordCredentialService;
        }

        @PostMapping("/create")
        @ResponseBody
        public PasswordCredential create(PasswordCredential passwordCredential) {
            return passwordCredentialService.create(passwordCredential);
        }

        @PostMapping("/update")
        @ResponseBody
        public PasswordCredential update(PasswordCredential passwordCredential) {
            return passwordCredentialService.update(passwordCredential);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public PasswordCredential read(@PathVariable String id) {
            return passwordCredentialService.read(id);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            passwordCredentialService.delete(id);
        }

        @GetMapping("/getAll/all")
        @ResponseBody
        public Set<PasswordCredential> getAll() {
            return passwordCredentialService.getAll();
        }
    }