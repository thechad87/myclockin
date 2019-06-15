package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.Domain.UserlType.Contractor;
import com.chadmarthinussen.repository.ContractorRepository;
import com.chadmarthinussen.repository.impl.ContractorRepositoryImpl;
import com.chadmarthinussen.services.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */

@Service("ContractorServiceImpl")
public class ContractorServiceImpl implements ContractorService {

    private static ContractorServiceImpl service = null;
    @Autowired
    private ContractorRepository repository;

    private ContractorServiceImpl() {
        this.repository = ContractorRepositoryImpl.getRepository();
    }

    public static ContractorServiceImpl getService(){
        if (service == null) service = new ContractorServiceImpl();
        return service;
    }

    @Override
    public Contractor create(Contractor contractor) {
        return this.repository.create(contractor);
    }

    @Override
    public Contractor update(Contractor contractor) {
        return this.repository.update(contractor);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Contractor read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Contractor> getAll() {
        return this.repository.getAll();
    }
}

