package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.AccessTypes.PasswordCredential;
import com.chadmarthinussen.repository.PasswordCredentialRepository;
import com.chadmarthinussen.repository.impl.PasswordCredentialRepositoryImpl;
import com.chadmarthinussen.services.PasswordCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Service("PasswordCredentialServiceImpl")
//@Service
public class PasswordCredentialServiceImpl implements PasswordCredentialService {

    @Autowired
    private PasswordCredentialRepository repository;
    private static PasswordCredentialServiceImpl service = null;

    private PasswordCredentialServiceImpl() {
        this.repository = PasswordCredentialRepositoryImpl.getRepository();
    }

    public static PasswordCredentialServiceImpl getService(){
        if (service == null) service = new PasswordCredentialServiceImpl();
        return service;
    }

    @Override
    public PasswordCredential create(PasswordCredential passwordCredential) {
        return this.repository.create(passwordCredential);
    }

    @Override
    public PasswordCredential update(PasswordCredential passwordCredential) {
        return this.repository.update(passwordCredential);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public PasswordCredential read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<PasswordCredential> getAll() {
        return this.repository.getAll();
    }
}
