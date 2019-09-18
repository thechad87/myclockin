package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.UserlType.Administrator;
import com.chadmarthinussen.repository.AdministratorRepository;
import com.chadmarthinussen.repository.impl.AdministratorRepositoryImpl;
import com.chadmarthinussen.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
@Service("AdministratorServiceImp")
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    private AdministratorRepository repository;
    private static AdministratorServiceImpl service = null;

    private AdministratorServiceImpl() {
        this.repository = AdministratorRepositoryImpl.getRepository();
    }

    public static AdministratorServiceImpl getService() {
        if (service == null) service = new AdministratorServiceImpl();
        return service;
    }

    @Override
    public Administrator create(Administrator administrator) {
        return this.repository.create(administrator);
    }

    @Override
    public Administrator update(Administrator administrator) {
        return this.repository.update(administrator);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Administrator read(String s) {
        return this.repository.read(s);
    }

//    @Override
//    public Administrator retrieveByDesc(String genderDesc) {
//        return this.repository.retrieveByDesc(genderDesc);
//    }

    @Override
    public Set <Administrator> getAll() {
        return this.repository.getAll();
    }
}
