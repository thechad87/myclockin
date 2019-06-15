package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.Domain.UserlType.Intern;
import com.chadmarthinussen.repository.InternRepository;
import com.chadmarthinussen.repository.impl.InternRepositoryImpl;
import com.chadmarthinussen.services.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Service("InternServiceImpl")
public class InternServiceImpl implements InternService {

    @Autowired
    private InternRepository repository;
    private static InternServiceImpl service = null;

    private InternServiceImpl() {
        this.repository = InternRepositoryImpl.getRepository();
    }

    public static InternServiceImpl getService(){
        if (service == null) service = new InternServiceImpl();
        return service;
    }

    @Override
    public Intern create(Intern intern) {
        return this.repository.create(intern);
    }

    @Override
    public Intern update(Intern intern) {
        return this.repository.update(intern);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Intern read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Intern> getAll() {
        return this.repository.getAll();
    }
}