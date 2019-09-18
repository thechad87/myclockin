package com.chadmarthinussen.services.impl;

import com.chadmarthinussen.domain.AccessTypes.TurnStileAccess;
import com.chadmarthinussen.repository.TurnStileAccessRepository;
import com.chadmarthinussen.repository.impl.TurnStileAccessRepositoryImpl;
import com.chadmarthinussen.services.TurnStileAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@Service("TurnStileAccessServiceImpl")
//@Service
public class TurnStileAccessServiceImpl implements TurnStileAccessService {

    @Autowired
    private TurnStileAccessRepository repository;
    private static TurnStileAccessServiceImpl service = null;

    private TurnStileAccessServiceImpl() {
        this.repository = TurnStileAccessRepositoryImpl.getRepository();
    }

    public static TurnStileAccessServiceImpl getService(){
        if (service == null) service = new TurnStileAccessServiceImpl();
        return service;
    }

    @Override
    public TurnStileAccess create(TurnStileAccess turnStileAccess) {
        return this.repository.create(turnStileAccess);
    }

    @Override
    public TurnStileAccess update(TurnStileAccess turnStileAccess) {
        return this.repository.update(turnStileAccess);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public TurnStileAccess read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<TurnStileAccess> getAll() {
        return this.repository.getAll();
    }
}
