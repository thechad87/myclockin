package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.Domain.AccessTypes.Authorization;
import com.chadmarthinussen.repository.AuthorizationRepository;
import com.chadmarthinussen.repository.impl.AuthorizationRepositoryImpl;
import com.chadmarthinussen.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Service("AuthorizationServiceImpl")
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private AuthorizationRepository repository;
    private static AuthorizationServiceImpl service = null;

    private AuthorizationServiceImpl() {
        this.repository = AuthorizationRepositoryImpl.getRepository();
    }

    public static AuthorizationServiceImpl getService(){
        if (service == null) service = new AuthorizationServiceImpl();
        return service;
    }

    @Override
    public Authorization create(Authorization authorization) {
        return this.repository.create(authorization);
    }

    @Override
    public Authorization update(Authorization authorization) {
        return this.repository.update(authorization);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Authorization read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Authorization> getAll() {
        return this.repository.getAll();
    }
}




















