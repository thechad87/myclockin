package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.PersonalDetails.Name;
import com.chadmarthinussen.repository.NameRepository;
import com.chadmarthinussen.repository.impl.NameRepositoryImpl;
import com.chadmarthinussen.services.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Service("NameServiceImpl")
//@Service
public class NameServiceImpl implements NameService {

    @Autowired
    private NameRepository repository;
    private static NameServiceImpl service = null;

    private NameServiceImpl() {
        this.repository = NameRepositoryImpl.getRepository();
    }

    public static NameServiceImpl getService(){
        if (service == null) service = new NameServiceImpl();
        return service;
    }

    @Override
    public Name create(Name name) {
        return this.repository.create(name);
    }

    @Override
    public Name update(Name name) {
        return this.repository.update(name);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Name read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Name> getAll() {
        return this.repository.getAll();
    }
}
